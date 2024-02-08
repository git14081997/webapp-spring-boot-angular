
package com.rodriguez.pruebas;

import com.rodriguez.pruebas.repository.dbdev.manyToMany.EscritorRepository;
import com.rodriguez.pruebas.repository.dbdev.manyToMany.LibroRepository;
import com.rodriguez.pruebas.repository.dbdev.manyToOne.ArtistaRepository;
import com.rodriguez.pruebas.repository.dbdev.manyToOne.CancionRepository;
import com.rodriguez.pruebas.repository.dbdev.oneToMany.AArtistaRepository;
import com.rodriguez.pruebas.repository.dbdev.oneToMany.CCancionRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.IngresosEgresosRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.InventarioRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.SpecialRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
//import org.springframework.context.annotation.Profile;


/**
 * Esta clase contiene pruebas de funcionamiento para
 * cada feature, haciendo que las futuras modificaciones/mantenimiento
 * sea predecible y pueda indicar claramente si se ha modificado algo
 * que ya funcionaba, cumpliendo algún objetivo concreto.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@SpringBootTest
//@Profile("rolpruebas")
class PruebasApplicationTests
{

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;

	@Autowired
	private FacturaDetalleRepository facturaDetalleRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private ImagenProductoRepository imagenProductoRepository;

	@Autowired
	private IngresosEgresosRepository ingresosEgresosRepository;

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private SpecialRepository specialRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;




	@Autowired
	private EscritorRepository escritorRepository;
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private CancionRepository cancionRepository;
	@Autowired
	private AArtistaRepository aArtistaRepository;
	@Autowired
	private CCancionRepository cCancionRepository;






	@Test
	void contextLoads(ApplicationContext applicationContext) throws Exception
	{
		assertThat(applicationContext).isNotNull();
	}



	@Test
	void reposotoriesInventarioFacturacion()
	{
		assertThat(clienteAbonaRepository).isNotNull();
		assertThat(facturaDetalleRepository).isNotNull();

		assertThat(facturaRepository).isNotNull();
		assertThat(imagenProductoRepository).isNotNull();

		assertThat(ingresosEgresosRepository).isNotNull();
		assertThat(inventarioRepository).isNotNull();

		assertThat(productoRepository).isNotNull();
		assertThat(specialRepository).isNotNull();

		assertThat(usuarioRepository).isNotNull();
	}



	@Test
	void reposotoriesDbDev()
	{
		assertThat(escritorRepository).isNotNull();
		assertThat(libroRepository).isNotNull();

		assertThat(artistaRepository).isNotNull();
		assertThat(cancionRepository).isNotNull();

		assertThat(aArtistaRepository).isNotNull();
		assertThat(cCancionRepository).isNotNull();
	}




}
