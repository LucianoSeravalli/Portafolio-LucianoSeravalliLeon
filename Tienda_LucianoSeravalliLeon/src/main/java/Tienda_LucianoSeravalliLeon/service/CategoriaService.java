/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
<<<<<<< Updated upstream
<<<<<<< Updated upstream
 */
package Tienda_LucianoSeravalliLeon.service;

=======
 *
package Tienda_LucianoSeravalliLeon.service;
>>>>>>> Stashed changes
=======
 *
package Tienda_LucianoSeravalliLeon.service;
>>>>>>> Stashed changes
import Tienda_LucianoSeravalliLeon.domain.Categoria;
import Tienda_LucianoSeravalliLeon.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.dao.DataIntegrityViolationException;
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

@Service
public class CategoriaService {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    // Permite crear una única instancia de CategoriaRepository, y la crea automáticamente
>>>>>>> Stashed changes
=======
    // Permite crear una única instancia de CategoriaRepository, y la crea automáticamente
>>>>>>> Stashed changes
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        if (activo) {
=======
        if (activo) { // Solo activos...
>>>>>>> Stashed changes
=======
        if (activo) { // Solo activos...
>>>>>>> Stashed changes
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream

    @Transactional(readOnly = true)
    public Optional<Categoria> getCategoria(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Transactional
    public void save(Categoria categoria, MultipartFile imagenFile) {
        categoria = categoriaRepository.save(categoria);
        if (!imagenFile.isEmpty()) { //Si no está vacio... pasaron una imagen...
            try {
                String rutaImagen = firebaseStorageService.uploadImage(
                        imagenFile, "categoria",
                        categoria.getIdCategoria());
                categoria.setRutaImagen(rutaImagen);
                categoriaRepository.save(categoria);
            } catch (IOException e) {
            }
        }
    }

    @Transactional
    public void delete(Integer idCategoria) {
        // Verifica si la categoria existe antes de intentar eliminarlo
        if (!categoriaRepository.existsById(idCategoria)) {
            // Lanza una excepción para indicar que el usuario no fue encontrado
            throw new IllegalArgumentException("La categoría con ID " + idCategoria + " no existe.");
        }
        try {
            categoriaRepository.deleteById(idCategoria);
        } catch (DataIntegrityViolationException e) {
            // Lanza una nueva excepción para encapsular el problema de integridad de datos
            throw new IllegalStateException("No se puede eliminar la categoría. Tiene datos asociados.", e);
        }
    }
}
=======
}
>>>>>>> Stashed changes
=======
}
>>>>>>> Stashed changes
