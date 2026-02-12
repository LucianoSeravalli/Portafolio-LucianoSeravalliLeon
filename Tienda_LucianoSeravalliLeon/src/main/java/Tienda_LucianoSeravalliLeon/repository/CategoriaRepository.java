/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
<<<<<<< Updated upstream
 */
package Tienda_LucianoSeravalliLeon.repository;

=======
 *
package Tienda_LucianoSeravalliLeon.repository;
>>>>>>> Stashed changes
import Tienda_LucianoSeravalliLeon.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    public List<Categoria> findByActivoTrue();
}