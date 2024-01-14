
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
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Page<Usuario> findByNombreCompletoContainingIgnoreCaseOrId(Pageable pageable, String nombre, Integer usuarioId);


	/*

	Page<Usuario> findByNombreContainingIgnoreCaseAndApellidoContainingIgnoreCase(Pageable pageable,String nombre, String apellido);

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

List<User> findByNameIsNull();
List<User> findByNameIsNotNull();
List<User> findByNameStartingWith(String prefix);
List<User> findByNameEndingWith(String suffix);
List<User> findByNameContaining(String infix);
List<User> findByActiveTrue();
List<User> findByActiveFalse();
List<User> findByNameLike(String likePattern);
List<User> findByAgeLessThan(Integer age);
List<User> findByAgeLessThanEqual(Integer age);
List<User> findByAgeGreaterThan(Integer age);
List<User> findByAgeGreaterThanEqual(Integer age);
List<User> findByAgeBetween(Integer startAge, Integer endAge);
List<User> findByAgeIn(Collection<Integer> ages);
List<User> findByBirthDateAfter(ZonedDateTime birthDate);
List<User> findByBirthDateBefore(ZonedDateTime birthDate);
List<User> findByNameOrAge(String name, Integer age);
List<User> findByNameOrAgeAndActive(String name, Integer age, Boolean active);
List<User> findByNameOrderByName(String name);
List<User> findByNameOrderByNameAsc(String name);
List<User> findByNameOrderByNameDesc(String name);
List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
findDistinctByLastnameAndFirstname
findByLastnameAndFirstname
findByFirstnameIgnoreCase
findByActiveFalse
findByActiveTrue
findByAgeNotIn(Collection<Age> ages)
findByAgeIn(Collection<Age> ages)
findByLastnameNot
findByAgeOrderByLastnameDesc
findByFirstnameContaining
findByFirstnameStartingWith
findByFirstnameEndingWith
findByFirstnameNotLike
findByFirstnameLike


@Query("select u from User u where u.emailAddress = ?1")
User findByEmailAddress(String emailAddress);







	*/


}
