
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * Esta clase contiene metodos básicos y avanzados
 * para acceder a la información de la base de datos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Repository("facturaDetalleRepository")
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Integer> {

	List<FacturaDetalle> findByFactura(Factura factura);

}
