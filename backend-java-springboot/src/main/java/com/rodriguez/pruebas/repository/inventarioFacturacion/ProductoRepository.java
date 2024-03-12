
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	Page<Producto> findByNombreContainingIgnoreCaseOrId(Pageable pageable, String nombre, Integer id);

	Page<Producto> findByImagenIsNotNull(Pageable pageable);

}
