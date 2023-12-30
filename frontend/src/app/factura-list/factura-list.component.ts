
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

	private http = inject(HttpClient);
	service: PruebasService;
	parametros: any = {};
	objetoSeleccionado: any = {};
	objetos: any[] = [];
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

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina();
	}

	setCantidadPorPag(){
		this.pagina = 0;
		this.getPorPagina();
	}

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio, this.pagina, this.cantidad
			).subscribe((RESPONSE: any) => {

				this.tmp = RESPONSE;

				this.objetos = this.tmp.content;
				this.paginasDisponibles = this.tmp.totalPages;
				this.total = this.tmp.totalElements;

				for( let objetoN of this.objetos ){
					objetoN.cumpleanoss = formatoDeFecha( objetoN.cumpleanos );
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

	eliminarPorID(id: number) {
		this.service.deleteById(
			this.parametroServicio, id
		).subscribe((RESPONSE) => {
			this.getPorPagina();
		});
	}

	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
	}

	verVentanaAgregar() {
		this.objetoSeleccionado = {};
		this.verLista = 'N';
		this.verEditable = 'S';
		this.crearOrActualizar = 'C';
	}

	verListado() {
		this.verLista = 'S';
		this.verEditable = 'N';
		this.objetoSeleccionado = {};
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
			this.objetoSeleccionado = {};
			window.location.reload();
		});
	}

	actualizarSeleccionado(parametros: any) {
		this.objetoSeleccionado = parametros;
		this.crearOrActualizar = 'A';
		this.verLista = 'N';
		this.verEditable = 'S';
	}

	buscarEnDb(parametros: any){

		let descripcion = parametros;

		this.getPaginadoBuscando(
			this.parametroServicio, 0, 20, descripcion
		).subscribe((RESPONSE) => {

			this.tmp = RESPONSE;

			this.objetos = this.tmp.content;
			this.paginasDisponibles = this.tmp.totalPages;
			this.total = this.tmp.totalElements;

			this.paginasDisponiblesArray = [];
			for(let i = 0; i < this.paginasDisponibles; i++){
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}
		});
	}

	limpiarBusqueda(){
		this.objetoSeleccionado.buscar = "";
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina();
	}

	getPaginadoBuscando(parametro:ParametroServicio, 
		pagina: number, cantidad: number,descripcion: string): Observable<any> {

		return this.http.get<any>(
			hostname + parametro.url + "/" + pagina + "/" + cantidad +
			"/buscar" + "?descripcion="+descripcion,
			parametro.headers);
	}

}
