
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

	Page<Usuario> findByNombreCompletoContainingIgnoreCase(Pageable pageable, String nombre);

	Page<Usuario> findByNombreContainingIgnoreCaseAndApellidoContainingIgnoreCase(Pageable pageable,String nombre, String apellido);

	/*

	List<Usuario> findByNombreIgnoreCase(String nombre);

	List<Usuario> findByNombreContaining(String nombre);

	List<Usuario> findByNombreNot(String nombre);

	List<Usuario> findByNombreAndApellido(String nombre, String apellido);

	List<Usuario> findByNombreLike(String nombre);

	List<Usuario> findByNombreEquals(String nombre);

	List<Usuario> findByCumpleanosBefore(Date cumpleanos);

	List<Usuario> findByPendienteDePagoLessThanEqual(BigDecimal pendienteDePago);


	@Query(
		value = "SELECT * FROM USUARIO order by ID ASC",
		countQuery = "SELECT COUNT(NUMERO_POLIZA) FROM USUARIO",
		nativeQuery = true
	)
	Page<Usuario> traerPorPagina(Pageable pageable);


  @Query("SELECT * FROM person WHERE lastname = :lastname")
  List<Person> findByLastname(String lastname);


  @Query("SELECT * FROM person WHERE lastname = :lastname")
  Stream<Person> streamByLastname(String lastname);


  @Query("SELECT * FROM person WHERE username = :#{ principal?.username }")
  Person findActiveUser();


findByBirthdateAfter(Date date)

findByAgeGreaterThan(int age)

findByAgeGreaterThanEqual(int age)

findByAgeBetween(int from, int to)

findByBirthdateBefore(Date date)


findByAgeNotBetween(int from, int to)

findByAgeNotIn(Collection ages)

findByFirstnameNotContaining(String name)

findByFirstnameNot(String name)


findByActiveIsTrue()



interface UserRepository extends CrudRepository<User, Long> {
  @Query("select firstName, lastName from User u where u.emailAddress = :email")
  User findByEmailAddress(@Param("email") String email);
}


@Modifying
@Query("UPDATE DUMMYENTITY SET name = :name WHERE id = :id")
boolean updateName(@Param("id") Long id, @Param("name") String name);







	*/


}
