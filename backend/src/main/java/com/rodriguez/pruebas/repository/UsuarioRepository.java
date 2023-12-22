
package com.rodriguez.pruebas.repository;

import com.rodriguez.pruebas.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos,
 * vinculada a la entidad tipo Usuario.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByNombreIgnoreCase(String nombre);

	List<Usuario> findByNombreContaining(String nombre);

	List<Usuario> findByNombreNot(String nombre);

	List<Usuario> findByNombreAndApellido(String nombre, String apellido);

	List<Usuario> findByNombreLike(String nombre);

	List<Usuario> findByNombreEquals(String nombre);

	List<Usuario> findByCumpleanosBefore(Date cumpleanos);

	List<Usuario> findByAlturaMetrosLessThanEqual(Double alturaMetros);


	@Query(
		value = "SELECT * FROM USUARIO order by ID ASC",
		countQuery = "SELECT COUNT(NUMERO_POLIZA) FROM USUARIO",
		nativeQuery = true
	)
	Page<Usuario> traerPorPagina(Pageable pageable);


}
