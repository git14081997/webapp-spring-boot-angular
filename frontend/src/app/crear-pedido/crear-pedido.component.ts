
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
	}

	agregarAlPedido(objetoN:any){

		if(objetoN.cantidadProductoVendido == undefined){
			objetoN.cantidadProductoVendido = 1;
		}

		objetoN.precioVentaPorProducto = this.dosDecimales(objetoN.precioVenta,3);

		objetoN.subtotalPorProducto = this.dosDecimales(objetoN.cantidadProductoVendido * objetoN.precioVentaPorProducto, 3) ;
		objetoN.ivaDelSubtotalPorProducto = this.dosDecimales((objetoN.subtotalPorProducto * IVA), 3);

		objetoN.gananciaUnidad = this.dosDecimales(objetoN.ganancia,3);

		objetoN.costoDelSubtotalPorProducto = this.dosDecimales((objetoN.costoUnidad * objetoN.cantidadProductoVendido), 3);
		objetoN.gananciaDelSubtotalPorProducto = this.dosDecimales((objetoN.ganancia * objetoN.cantidadProductoVendido), 3);

		objetoN.nombreProducto = objetoN.nombre;

		let refProducto:any = {};
		refProducto.productoId = objetoN.id;
		objetoN.producto = refProducto;

		this.objetosPedido.push(objetoN);

		this.todoElPedido.total = 0;

		for(let productoPedido of this.objetosPedido ){

			this.todoElPedido.total += this.dosDecimales(productoPedido.subtotalPorProducto, 3);

			productoPedido.ivaDelSubtotalPorProducto =  
			this.dosDecimales((productoPedido.subtotalPorProducto * IVA), 3);

			console.log(productoPedido.subtotalPorProducto);
		}

		this.todoElPedido.facturaDetalle = this.objetosPedido;
		this.todoElPedido.iva = this.dosDecimales((this.todoElPedido.total * IVA), 3);
		this.todoElPedido.subtotal = this.dosDecimales(this.todoElPedido.total, 3);
		this.todoElPedido.total = this.dosDecimales((this.todoElPedido.subtotal + this.todoElPedido.iva), 3);

		console.log("total del pedido: " + this.todoElPedido.total);

	}



	guardarPedido(){
		// enviar
		console.log("Todo el detalle del pedido");
		console.log(this.todoElPedido);
	}


	dosDecimales (xnumber:number, posiciones:number) {

		if(posiciones < 0){
			posiciones = 0;
		}

		let s = xnumber.toString();
		let l = s.length;
		let decimalLength = s.indexOf('.') + 1;
		let numStr = s.substring(0, decimalLength + (posiciones-1));
		return Number(numStr);
	}

}
