
package com.rodriguez.pruebas.repository;

import com.rodriguez.pruebas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("categoriaRepository")
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
