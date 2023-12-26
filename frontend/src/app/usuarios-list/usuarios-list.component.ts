
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';

@Component({
	selector: 'app-usuarios-list',
	standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
	],
	templateUrl: './usuarios-list.component.html',
	styleUrl: './usuarios-list.component.css'
})
export class UsuariosListComponent implements OnInit {

	private parametroServicio: ParametroServicio = {
		url: "api/usuario",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	}

	service: PruebasService;
	parametros: any = {};
	objetoSeleccionado: any = {};
	objetos: any[] = [];
	verLista: string = 'S';
	verEditable: string = 'N';
	crearOrActualizar: string = 'C';

	pagina: number = 0;
	cantidad: number = 2;
	total: number = 2;
	opcionesCantidadPorPagina = [2, 10, 50, 100];
	paginasDisponibles :number = 1;
	paginasDisponiblesArray: any[] = [];

	onPageChange(event: any) {
		this.pagina = event.first;
		this.cantidad = event.rows;
		this.getPorPagina();
	}

	setCantidadPorPagina(){
		this.getPorPagina();
	}

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina();
	}

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio, this.pagina, this.cantidad
			).subscribe((RESPONSE: any) => {

				console.log(RESPONSE);

				this.objetos = RESPONSE.content;
				this.paginasDisponibles = RESPONSE.totalPages;
				this.total = RESPONSE.totalElements;

				for( let objetoN of this.objetos ){
					
					let fechaString = new Date(objetoN.cumpleanos.toString());

					objetoN.cumpleanoss = fechaString.getFullYear() +
						"/" + (fechaString.getMonth()+1) + "/" + fechaString.getDate();
				}

				this.paginasDisponiblesArray = [];
				for(let i = 0; i < this.paginasDisponibles; i++){
					let newObj = { "numPagina": i };
					this.paginasDisponiblesArray.push(newObj);
				}

			});
	}


	getPorPaginaNum(numPagina:number) {
		this.pagina = numPagina;
		this.service.getPaginado(
			this.parametroServicio,
			this.pagina,
			this.cantidad).subscribe((RESPONSE: any) => {

				this.objetos = RESPONSE.content;
				this.paginasDisponibles = RESPONSE.totalPages;
				this.total = RESPONSE.totalElements;

				for( let objetoN of this.objetos ){
					let fechaString = new Date(objetoN.cumpleanos.toString());
					objetoN.cumpleanoss = fechaString.getFullYear() +
						"/" + (fechaString.getMonth()+1) + "/" + fechaString.getDate();
				}

				this.paginasDisponiblesArray = [];
				for(let i = 0; i < this.paginasDisponibles; i++){
					let newObj = { "numPagina": i };
					this.paginasDisponiblesArray.push(newObj);
				}

			});
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

}
