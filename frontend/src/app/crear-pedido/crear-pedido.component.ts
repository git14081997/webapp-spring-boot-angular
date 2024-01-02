
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { hostname } from '../hostname';
import { IVA } from '../impuestos';

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

	private parametroServicio: ParametroServicio = {
		url: "/api/usuario",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	}

	private http = inject(HttpClient);
	service: PruebasService;
	parametros: any = {};
	productoSeleccionado: any = {};
	productosEncontrados: any[] = [];
	objetosPedido: any[] = [];

	todoElPedido:any = {};

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
	}

	limpiarBusqueda(){
		this.parametros.buscar = "";
		this.productosEncontrados = [];
	}

	getPaginadoBuscando(nombre: string) {
		return this.http.get<any>(
			hostname + '/api/producto' + "/" + 0 + "/" + 10 +
			"/buscar" + "?nombre="+nombre,
			this.parametroServicio.headers).subscribe((RESPONSE:any) => {
				this.productosEncontrados = RESPONSE.content;
			});
	}

	quitarDelPedido(index: number) {
		this.objetosPedido.splice(index, 1);
		this.actualizarDetallePedido();
	}

	agregarAlPedido(objetoN:any, index:number){

		if(objetoN.cantidadProductoVendido == undefined){
			objetoN.cantidadProductoVendido = 1;
		}

		let refProducto:any = {};
		refProducto.productoId = objetoN.id;
		objetoN.producto = refProducto;

		// se agrega al pedido
		this.objetosPedido.push(objetoN);

		// se quita de resultados previos
		this.productosEncontrados.splice(index, 1);

		this.actualizarDetallePedido();

	}



	guardarPedido(){

		this.actualizarDetallePedido();

		// enviar
		console.log("-- -- P E D I D O -- --");
		console.log(this.todoElPedido);
		console.log("-- -- P E D I D O -- --");
	}



	dosDecimales (xnumber:number) :number {
		return Number(xnumber.toFixed(2));
	}




	actualizarDetallePedido(){

		this.todoElPedido.iva = 0;
		this.todoElPedido.subtotal = 0;
		this.todoElPedido.total = 0;

		if( this.objetosPedido.length > 0 ){

			for(let productoPedido of this.objetosPedido ){

				productoPedido.precioVentaPorProducto = this.dosDecimales(productoPedido.precioVenta );

				productoPedido.subtotalPorProducto = this.dosDecimales(productoPedido.cantidadProductoVendido * productoPedido.precioVentaPorProducto ) ;
				productoPedido.ivaDelSubtotalPorProducto = this.dosDecimales((productoPedido.subtotalPorProducto * IVA) );
		
				productoPedido.gananciaUnidad = this.dosDecimales(productoPedido.ganancia );
		
				productoPedido.costoDelSubtotalPorProducto = this.dosDecimales((productoPedido.costoUnidad * productoPedido.cantidadProductoVendido) );
				productoPedido.gananciaDelSubtotalPorProducto = this.dosDecimales((productoPedido.ganancia * productoPedido.cantidadProductoVendido) );
		
				productoPedido.nombreProducto = productoPedido.nombre;
		
				///

				this.todoElPedido.total += this.dosDecimales(productoPedido.subtotalPorProducto );

				productoPedido.ivaDelSubtotalPorProducto =  
				this.dosDecimales((productoPedido.subtotalPorProducto * IVA) );
	
			} // FOR

			this.todoElPedido.facturaDetalle = this.objetosPedido;
			this.todoElPedido.subtotal = this.dosDecimales(this.todoElPedido.total );
			this.todoElPedido.iva = this.dosDecimales((this.todoElPedido.total * IVA) );
			this.todoElPedido.total = this.dosDecimales((this.todoElPedido.subtotal + this.todoElPedido.iva) );

		} // FI

		else {
			this.todoElPedido.facturaDetalle = null;

		}

	}





}
