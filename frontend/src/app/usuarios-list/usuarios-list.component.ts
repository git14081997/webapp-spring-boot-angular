
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
	cantidad: number = 1;
	total: number = 1;
	opcionesCantidadPorPagina = [1, 10, 25];
	paginasDisponibles :number = 1;
	paginasDisponiblesArray: any[] = [];

	tmp:any;

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina();
	}

	getMesLetras(mes:number): string {
		let mesEnLetras = "";
		if(mes == 1){
			mesEnLetras = "ENERO";
		}
		if(mes == 2){
			mesEnLetras = "FEBRERO";
		}
		if(mes == 3){
			mesEnLetras = "MARZO";
		}

		if(mes == 4){
			mesEnLetras = "ABRIL";
		}
		if(mes == 5){
			mesEnLetras = "MAYO";
		}
		if(mes == 6){
			mesEnLetras = "JUNIO";
		}

		if(mes == 7){
			mesEnLetras = "JULIO";
		}
		if(mes == 8){
			mesEnLetras = "AGOSTO";
		}
		if(mes == 9){
			mesEnLetras = "SEPTIEMBRE";
		}

		if(mes == 10){
			mesEnLetras = "OCTUBRE";
		}
		if(mes == 11){
			mesEnLetras = "NOVIEMBRE";
		}
		if(mes == 12){
			mesEnLetras = "DICIEMBRE";
		}
		return mesEnLetras;
	}


	formatoDeFecha(campoFecha:any) :string {
		
		if(campoFecha == null){
			return "";
		}

		let fechaString = new Date(campoFecha.toString());

		let mes = fechaString.getMonth()+1;
		let dia = fechaString.getDate();

		let diaTxt = "";
		if( dia < 10 ){
			diaTxt = "0"+dia;
		}
		else {
			diaTxt = ""+dia;
		}

		return diaTxt + " " + this.getMesLetras(mes) + " " + fechaString.getFullYear() + " ";

	}

	setCantidadPorPag(){
		this.pagina = 0;
		this.getPorPagina();
	}

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio, this.pagina, this.cantidad
			).subscribe((RESPONSE: any) => {


				this.tmp = RESPONSE;
				console.log(RESPONSE);

				this.objetos = this.tmp.content;
				this.paginasDisponibles = this.tmp.totalPages;
				this.total = this.tmp.totalElements;

				for( let objetoN of this.objetos ){
					objetoN.cumpleanoss = this.formatoDeFecha( objetoN.cumpleanos );
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

}
