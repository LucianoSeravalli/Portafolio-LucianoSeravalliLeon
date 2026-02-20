package Tienda_LucianoSeravalliLeon.repository;

import Tienda_LucianoSeravalliLeon.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Método personalizado para obtener solo las categorías activas
    public List<Producto> findByActivoTrue();
}