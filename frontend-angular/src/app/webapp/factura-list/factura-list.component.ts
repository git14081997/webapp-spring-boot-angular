
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';
import { buscarToken, cantidadPorPagina } from '../libproyecto';

@Component({
  selector: 'app-factura-list',
  standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
	],
  templateUrl: './factura-list.component.html',
  styleUrl: './factura-list.component.css'
})
export class FacturaListComponent implements OnInit {

	parametroServicio: any;
	http;

	service: PruebasService;
	parametros: any;

	facturaSeleccionada: any;
	facturas: any[];

	verLista: string;
	verEditable: string;

	crearOrActualizar: string;
	tmp:any;

	formatoDeFecha = formatoDeFecha;
	@Input() idCliente: string;

	detallesPorFactura: any[];
	getToken = buscarToken;

	/* variables de paginacion */
	enlaceActual: string = "";
	paramActual: string = "";

	opcionesCantidadPorPagina = cantidadPorPagina;
	pagina: number = 0; // 0 es la primer pagina

	cantidad: number = this.opcionesCantidadPorPagina[0];
	paginasDisponibles: number = 1;

	paginasDisponiblesArray: any[] = [];
	total: number = 0;
	/* variables de paginacion */

	constructor()
	{
		this.service = new PruebasService;

		this.http = inject(HttpClient);
		this.parametros = {};
		
		this.facturaSeleccionada = {};
		this.facturaSeleccionada.buscar = "";

		this.facturas = [];
		this.verLista = 'S';
		this.verEditable = 'N';
		this.crearOrActualizar = 'C';
		this.formatoDeFecha = formatoDeFecha;

		this.idCliente = "";
		this.detallesPorFactura = [];
		this.getToken = buscarToken;

		this.parametroServicio = {};
		this.parametroServicio.url = "/api/factura";
		this.parametroServicio.headers = new HttpHeaders(
		{
		'Content-Type': 'application/json',
		'Accept': 'application/json',
		'Authorization': this.getToken()
		}
		);


		/* variables de paginacion */
		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "";

		this.opcionesCantidadPorPagina = cantidadPorPagina;
		this.pagina = 0; // 0 es la primer pagina

		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.paginasDisponibles = 1;

		this.paginasDisponiblesArray = [];
		this.total = 0;
		/* variables de paginacion */


	} // constructor 
	
	
	ngOnInit(): void {

		/*
		this.opcionesCantidadPorPagina = cantidadPorPagina;
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];

		this.facturas = [];
		this.detallesPorFactura = [];

		this.parametroServicio.url = "/api/factura";
		this.parametroServicio.headers = new HttpHeaders(
		{
		'Content-Type': 'application/json',
		'Accept': 'application/json',
		'Authorization': this.getToken()
		}
		);
		this.enlaceActual = this.parametroServicio.url;

		if( this.idCliente == "" ){
			this.getPorPagina(this.enlaceActual);
		}
		else {
			this.buscarEnDb( this.idCliente );
		}

		*/
		this.getPorPagina(this.enlaceActual);


	}


	formatoTexto(){
		for( let objetoN of this.facturas ){
			objetoN.cumpleanoss = formatoDeFecha( objetoN.cumpleanos );

			if(objetoN.tipoPago == 'C'){
				objetoN.tipoPagoDetalle = "Credito";
			}

			if(objetoN.tipoPago == 'E'){
				objetoN.tipoPagoDetalle = "Efectivo";
			}

			if(objetoN.tipoPago == 'V'){
				objetoN.tipoPagoDetalle = "Visto/Consignacion";
			}

			if(objetoN.tipoPago == 'D'){
				objetoN.tipoPagoDetalle = "Devuelto";
			}

			if(objetoN.tipoPago == 'P'){
				objetoN.tipoPagoDetalle = "Perdida";
			}	

		}
	}


	verVentanaAgregar() {
		this.facturaSeleccionada = {};
		this.verLista = 'N';
		this.verEditable = 'S';
		this.crearOrActualizar = 'C';
	}


	verListado() {
		this.verLista = 'S';
		this.verEditable = 'N';
		this.facturaSeleccionada = {};
	}


	agregar(parametros: any) {
		this.service.post(
			this.parametroServicio,
			parametros
		).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			this.getPorPagina(this.enlaceActual);
		});
	}


	actualizar(parametros: any) {
		this.service.put(
			this.parametroServicio,
			parametros
		).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			this.facturaSeleccionada = {};
			window.location.reload();
		});
	}


	actualizarSeleccionado(parametros: any) {
		this.facturaSeleccionada = parametros;
		this.verLista = 'N';
		this.verEditable = 'S';
		this.getDetallePorFactura(this.facturaSeleccionada.id);
	}
	

	buscarEnDb(nombreCliente: any){

		this.http.get<any>(
			hostname + this.parametroServicio.url + '/nombre/' + nombreCliente,
			this.parametroServicio.headers
		).subscribe((RESPONSE:any) => {
			
			this.facturas = RESPONSE;
			this.formatoTexto();

			this.actualizarContadores(0,this.facturas.length);
			this.paginasDisponiblesArray = [];
			for (let i = 0; i < this.paginasDisponibles; i++) {
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}

		});

	}


	limpiarBusqueda(){
		this.facturaSeleccionada.buscar = "";
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina(this.enlaceActual);
	}

	
	getDetallePorFactura(facturaId:number) {
		let enlaceFacturaDetalle = hostname + this.parametroServicio.url + "detalle/" + facturaId;
		this.http.get<any>( enlaceFacturaDetalle, this.parametroServicio.headers)
		.subscribe((RESPONSE:any) => {
			this.detallesPorFactura = RESPONSE;
		});
	}


	pedidoDevuelto(){
		this.http.post<any>(
			hostname + this.parametroServicio.url + '/dev/' + this.facturaSeleccionada.id,
			this.parametroServicio.headers
		).subscribe(() => {
			window.location.reload();
		});

	}


	confirmarPedido(){
		this.http.post<any>(
			hostname + this.parametroServicio.url + '/yes/' + this.facturaSeleccionada.id,
			this.parametroServicio.headers
		).subscribe(() => {
			window.location.reload();
		});
	}

	



		/* metodos para paginacion */
		actualizarContadores(pagDisponibles: number, total: number){
			this.paginasDisponibles = pagDisponibles;
			this.total = total;
			this.paginasDisponiblesArray = [];
			for (let i = 0; i < this.paginasDisponibles; i++) {
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}
		}
	
		setCantidadPorPag() {
			this.pagina = 0;
			this.getPorPagina(this.enlaceActual);
		}
	
		getPorPaginaNum(numPagina: number) {
			if (numPagina >= this.paginasDisponibles) {
				console.log("posible falla en get facturas ")
				numPagina = this.paginasDisponibles - 1;
			}
			if (numPagina <= 0) {
				numPagina = 0;
			}
			this.pagina = numPagina;
			this.getPorPagina(this.enlaceActual);
		}
	
	
		getPorPagina(urlAlRecurso: string) {
			let urlGetPaginado = hostname + urlAlRecurso + "/" + this.pagina + "/" + this.cantidad;
			this.http.get<any>(urlGetPaginado, this.parametroServicio.headers).subscribe((RESPONSE: any) => {
				this.tmp = RESPONSE;
				this.facturas = this.tmp.content;
				this.actualizarContadores(this.tmp.totalPages, this.tmp.totalElements);
				this.formatoTexto();
				this.tmp = {};
			});
		}
		/* metodos para paginacion */

}
