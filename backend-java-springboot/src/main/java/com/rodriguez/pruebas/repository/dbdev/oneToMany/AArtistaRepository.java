
package com.rodriguez.pruebas.repository.dbdev.oneToMany;

import com.rodriguez.pruebas.entity.dbdev.oneToMany.AArtista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("aartistaRepository")
public interface AArtistaRepository extends JpaRepository<AArtista, Integer> {
	List<AArtista> findByNombre(String lastName);
}
