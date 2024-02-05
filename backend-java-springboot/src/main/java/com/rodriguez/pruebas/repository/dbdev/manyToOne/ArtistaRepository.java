
package com.rodriguez.pruebas.repository.dbdev.manyToOne;

import com.rodriguez.pruebas.entity.dbdev.manyToOne.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos,
 * vinculada a la entidad tipo Artista.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("artistaRepository")
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

	List<Artista> findByNombreIgnoreCase(String lastName);

}
