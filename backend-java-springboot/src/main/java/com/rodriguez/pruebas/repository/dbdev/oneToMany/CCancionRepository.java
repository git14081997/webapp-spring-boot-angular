
package com.rodriguez.pruebas.repository.dbdev.oneToMany;

import com.rodriguez.pruebas.entity.dbdev.oneToMany.CCancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("ccancionRepository")
public interface CCancionRepository extends JpaRepository<CCancion, Integer> {
}
