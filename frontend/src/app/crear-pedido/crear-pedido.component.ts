
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

		objetoN.cantidadProductoVendido = 1;
		objetoN.precioVentaPorProducto = objetoN.precioVenta;

		objetoN.subtotalPorProducto = objetoN.cantidadProductoVendido * objetoN.precioVentaPorProducto;
		objetoN.ivaDelSubtotalPorProducto = objetoN.subtotalPorProducto * IVA;

		objetoN.gananciaUnidad = objetoN.ganancia;

		objetoN.costoDelSubtotalPorProducto = objetoN.costoUnidad * objetoN.cantidadProductoVendido;
		objetoN.gananciaDelSubtotalPorProducto = objetoN.ganancia * objetoN.cantidadProductoVendido;

		objetoN.nombreProducto = objetoN.nombre;

		let refProducto:any = {};
		refProducto.productoId = objetoN.id;
		objetoN.producto = refProducto;

		this.objetosPedido.push(objetoN);
	}

	guardarPedido(){
		// enviar
		console.log("Todo el detalle del pedido");
		console.log(this.todoElPedido);
	}

}
