
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PruebasService } from './pruebas.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ParametroServicio } from './ParametroServicio';

@Component({
	selector: 'app-pruebas',
	standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
		ButtonModule, TableModule
	],
	templateUrl: './pruebas.component.html',
	styleUrl: './pruebas.component.css'
})
export class PruebasComponent implements OnInit {

	parametroServicio: ParametroServicio = {
		url: "http://localhost:8001/api/artista",
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
	pagina: number = 0;
	cantidad: number = 10;

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina(this.pagina, this.cantidad);
	}

	getPorId(id:number) {
		this.service.getById(this.parametroServicio,id).subscribe((RESPONSE: any) => {
			this.objetos = RESPONSE;
		});
	}

	getPorPagina(pagina: number, cantidad: number) {
		this.service.getPaginado(this.parametroServicio,pagina, cantidad).subscribe((RESPONSE: any) => {
			this.objetos = RESPONSE.content;
		});
	}

	agregar(parametros: any) {
		this.service.post(this.parametroServicio,parametros).subscribe((RESPONSE) => {
			this.getPorPagina(this.pagina, this.cantidad);
		});
	}

	actualizar(parametros: any) {
		this.service.put(this.parametroServicio,parametros).subscribe((RESPONSE) => {
			this.getPorPagina(this.pagina, this.cantidad);
		});
	}

	eliminarPorID(id: number) {
		this.service.deleteById(this.parametroServicio,id).subscribe((RESPONSE) => {
			this.getPorPagina(this.pagina, this.cantidad);
		});
	}

	editar(objetoSeleccionado: any) {
		this.objetoSeleccionado = objetoSeleccionado;
		console.log(this.objetoSeleccionado);
	}

	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
	}

}
