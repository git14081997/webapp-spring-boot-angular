
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { hostname } from '../hostname';

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

	private parametroServicio: ParametroServicio = {
		url: "/api/factura",
		headers: new HttpHeaders({
			'Content-Type': 'application/json;charset=utf-8',
			'Accept': 'application/json;charset=utf-8',
			'Authorization': 'Bearer '
		})
	}

	private parametroServicioDetallefacturas: ParametroServicio = {
		url: "/api/facturadetalle",
		headers: this.parametroServicio.headers
	}

	private http = inject(HttpClient);
	service: PruebasService;
	parametros: any = {};
	facturaSeleccionada: any = {};
	facturas: any[] = [];
	verLista: string = 'S';
	verEditable: string = 'N';
	crearOrActualizar: string = 'C';

	pagina: number = 0;
	cantidad: number = 10;
	total: number = 1;
	opcionesCantidadPorPagina = [10, 25, 50, 100];
	paginasDisponibles :number = 1;
	paginasDisponiblesArray: any[] = [];

	tmp:any;

	formatoDeFecha = formatoDeFecha;

	@Input() idCliente: string = "";

	detallesPorFactura: any[] = [];

	constructor() {
		this.service = new PruebasService;
	}

	
	ngOnInit(): void {

		if( this.idCliente == "" ){
			this.getPorPagina();
		}
		else {
			this.buscarEnDb( this.idCliente );
		}

	}



	setCantidadPorPag(){
		this.pagina = 0;
		this.getPorPagina();
	}

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio, this.pagina, this.cantidad
			).subscribe((RESPONSE: any) => {

				this.tmp = RESPONSE;

				this.facturas = this.tmp.content;
				this.paginasDisponibles = this.tmp.totalPages;
				this.total = this.tmp.totalElements;

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

				}

				this.paginasDisponiblesArray = [];
				for(let i = 0; i < this.paginasDisponibles; i++){
					let newObj = { "numPagina": i };
					this.paginasDisponiblesArray.push(newObj);
				}

			});
	}

	getPorPaginaNum(numPagina:number) {
		if(numPagina >= this.paginasDisponibles ){
			numPagina = this.paginasDisponibles - 1;
		}
		if(numPagina <= 0){
			numPagina = 0;
		}
		this.pagina = numPagina;
		this.getPorPagina();
	}


	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
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
			this.getPorPagina();
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
		console.log(parametros);
		this.getDetallePorFactura(parametros.id);
	}


	
	buscarEnDb(nombreCliente: any){

		return this.http.get<any>(
			hostname + '/api/factura/nombre/' + nombreCliente,
			this.parametroServicio.headers
		).subscribe((RESPONSE:any) => {

			
			this.facturas = RESPONSE;
			
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
			/// procesarInfo N facturas

		});

	}
	
	

	limpiarBusqueda(){
		this.facturaSeleccionada.buscar = "";
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina();
	}


	getDetallePorFactura(facturaId:number) {

		let enlace = this.parametroServicioDetallefacturas.url + "/" + facturaId;
		this.parametroServicioDetallefacturas.url = enlace;

		this.service.getAll(this.parametroServicioDetallefacturas)
			.subscribe((RESPONSE: any) => {
				this.detallesPorFactura = RESPONSE;
			}
		);


	}


	
}
