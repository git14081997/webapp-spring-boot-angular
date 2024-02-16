
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PruebasService } from '../pruebas/pruebas.service';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';
import { IVA } from '../impuestos';
import { buscarToken } from '../libproyecto';

@Component({
selector: 'app-crear-pedido',
standalone: true,
imports: [
CommonModule, FormsModule, HttpClientModule,
],
templateUrl: './crear-pedido.component.html',
styleUrl: './crear-pedido.component.css'
})
export class CrearPedidoComponent implements OnInit {

http = inject(HttpClient);
service: PruebasService;
parametros: any = {};
productoSeleccionado: any = {};
productosEncontrados: any[] = [];
objetosPedido: any[] = [];
todoElPedido:any = {};
clientesEncontrados: any[] = [];

tiposDePago: any[] = [
	{ "id": "C", "nombre": "Crédito" },
	{ "id": "E", "nombre": "Efectivo" },
	{ "id": "V", "nombre": "Visto" },
];

parametroServicio: any = {};
getToken = buscarToken;

constructor() {
this.service = new PruebasService;
}

ngOnInit(): void {

	this.parametroServicio.url = "/api/factura";
	this.parametroServicio.headers = new HttpHeaders(
	{
	'Content-Type': 'application/json',
	'Accept': 'application/json',
	'Authorization': this.getToken()
	}
	);

}

limpiarBusqueda(){
this.parametros.buscar = "";
this.productosEncontrados = [];
}


getPaginadoBuscando(nombre: string) {
return this.http.get<any>(
hostname + '/api/producto/0/20/buscar?nombre=' + nombre,
this.parametroServicio.headers).subscribe((RESPONSE:any) => {
this.productosEncontrados = RESPONSE.content;
for(let productoN of this.productosEncontrados){
	productoN.precioVentaMin = productoN.precioVenta;
}
});
}


quitarDelPedido(index: number) {
this.objetosPedido.splice(index, 1);
this.actualizarDetallePedido();
}


agregarAlPedido(objetoN:any, index:number)
{

objetoN.productoId = objetoN.id;

if( objetoN.existencias > 0)
{

	if(objetoN.cantidadProductoVendido == undefined)
	{
		objetoN.cantidadProductoVendido = 1;
	}

// se agrega al pedido
this.objetosPedido.push(objetoN);
// se quita de resultados previos
this.productosEncontrados.splice(index, 1);
this.actualizarDetallePedido();
} // if existencias > 0
else
{
	confirm("No hay existencias de este producto en el inventario !");
}

} // agregarAlPedido



guardarPedido()
{

	if (
		this.objetosPedido.length > 0 &&
		this.todoElPedido.tipoPago != undefined &&
		this.todoElPedido.tipoPago != null &&
		this.todoElPedido.usuarioId != undefined && 
		this.todoElPedido.usuarioId != null 
	)
	{

		this.todoElPedido.usuarioId = Number(this.todoElPedido.usuarioId );

		this.actualizarDetallePedido();

		this.service.post(this.parametroServicio,this.todoElPedido).subscribe((facturaN) => {
				let facturaId = facturaN.id;
				facturaId = JSON.stringify(facturaId);
				localStorage.setItem('id', facturaId );
				window.location.href = '/facturas';
			}
		);



	} // verificacion/validacion de los detalles para el pedido 

	else
	{
		alert("Selecciona el cliente, los productos que comprará y el tipo de pedido !");
	}


}



dosDecimales (xnumber:number) :number {
return Number(xnumber.toFixed(2));
}




actualizarDetallePedido()
{

this.todoElPedido.costoTotal = 0;
this.todoElPedido.ganancia = 0;
this.todoElPedido.iva = 0;
this.todoElPedido.subtotal = 0;
this.todoElPedido.total = 0;

if( this.objetosPedido.length > 0 )
{


for(let productoPedido of this.objetosPedido )
{

	if( productoPedido.cantidadProductoVendido > productoPedido.existencias )
	{
		productoPedido.cantidadProductoVendido = productoPedido.existencias;
		//alert("Solo tienes y puedes vender: "+ productoPedido.existencias + " unidades del producto " + productoPedido.nombre );
	} // si cantidadProductoVendido > productoPedido.existencias

productoPedido.precioVentaPorProducto = this.dosDecimales(productoPedido.precioVenta );

productoPedido.subtotalPorProducto = this.dosDecimales(productoPedido.cantidadProductoVendido * productoPedido.precioVentaPorProducto ) ;
productoPedido.ivaDelSubtotalPorProducto = this.dosDecimales((productoPedido.subtotalPorProducto * IVA) );

productoPedido.gananciaUnidad = this.dosDecimales( 
	productoPedido.precioVentaPorProducto - productoPedido.ivaDelSubtotalPorProducto - productoPedido.costoUnidad
);
productoPedido.ganancia = productoPedido.gananciaUnidad;

productoPedido.costoDelSubtotalPorProducto = this.dosDecimales((productoPedido.costoUnidad * productoPedido.cantidadProductoVendido) );
productoPedido.gananciaDelSubtotalPorProducto = this.dosDecimales((productoPedido.ganancia * productoPedido.cantidadProductoVendido) );

this.todoElPedido.costoTotal += productoPedido.costoDelSubtotalPorProducto;
this.todoElPedido.ganancia += productoPedido.gananciaDelSubtotalPorProducto;

productoPedido.nombreProducto = productoPedido.nombre;

this.todoElPedido.total += this.dosDecimales(productoPedido.subtotalPorProducto );

productoPedido.ivaDelSubtotalPorProducto =  
this.dosDecimales((productoPedido.subtotalPorProducto * IVA) );

} // FOR

this.todoElPedido.detalle = this.objetosPedido;
this.todoElPedido.subtotal = this.dosDecimales(this.todoElPedido.total );
this.todoElPedido.iva = this.dosDecimales((this.todoElPedido.total * IVA) );
this.todoElPedido.total = this.dosDecimales((this.todoElPedido.subtotal + this.todoElPedido.iva) );

} // FI

else {
this.todoElPedido.detalle = null;

}

}




getClientes(nombre: string){
	return this.http.get<any>(hostname + '/api/usuario' + "/" + 0 + "/" + 20 +
		"/buscar" + "?nombre="+nombre,
		this.parametroServicio.headers).subscribe((RESPONSE:any) => {
		this.clientesEncontrados = RESPONSE.content;
	});
}


limpiarBusquedaClientes(){
	this.parametros.buscarCliente = "";
}


setClienteCompra(clienteEncontrado:any, indice: number ){
	this.todoElPedido.usuarioId = clienteEncontrado.id;

	this.todoElPedido.usuarioNombre =
		clienteEncontrado.nombre 
		+ " " + clienteEncontrado.nombreDos
		+ " " + clienteEncontrado.apellido
		+ " " + clienteEncontrado.apellidoDos;

}


validarNewPrecioVenta(objetoN:any)
{
	if( objetoN.precioVenta >= objetoN.costoUnidad )
	{
		this.actualizarDetallePedido();
	}
	else
	{
		objetoN.precioVenta = objetoN.costoUnidad;
	}
}



}
