
package Tienda_LucianoSeravalliLeon.service;

import Tienda_LucianoSeravalliLeon.domain.Producto;
import Tienda_LucianoSeravalliLeon.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        if (activo) {
            return productoRepository.findByActivoTrue();
        }
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Producto> getProducto(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Transactional
    public void save(Producto categoria, MultipartFile imagenFile) {
        categoria = productoRepository.save(categoria);
        if (!imagenFile.isEmpty()) { //Si no está vacio... pasaron una imagen...
            try {
                String rutaImagen = firebaseStorageService.uploadImage(
                        imagenFile, "categoria",
                        categoria.getIdProducto());
                categoria.setRutaImagen(rutaImagen);
                productoRepository.save(categoria);
            } catch (IOException e) {
            }
        }
    }

    @Transactional
    public void delete(Integer idProducto) {
        // Verifica si la categoria existe antes de intentar eliminarlo
        if (!productoRepository.existsById(idProducto)) {
            // Lanza una excepción para indicar que el usuario no fue encontrado
            throw new IllegalArgumentException("La categoría con ID " + idProducto + " no existe.");
        }
        try {
            productoRepository.deleteById(idProducto);
        } catch (DataIntegrityViolationException e) {
            // Lanza una nueva excepción para encapsular el problema de integridad de datos
            throw new IllegalStateException("No se puede eliminar la categoría. Tiene datos asociados.", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Producto> consultaDerivada(double precioInf, double precioSup) {
        return productoRepository.findByPrecioBetweenOrderByPrecioAsc(precioInf, precioSup);
    }
    
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoRepository.consultaJPQL(precioInf, precioSup);
    }

    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoRepository.consultaSQL(precioInf, precioSup);
    }
}
