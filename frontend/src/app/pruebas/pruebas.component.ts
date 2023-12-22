
import { Component, OnInit } from '@angular/core';
import { CommonModule} from '@angular/common';
import { PruebasService } from './pruebas.service';
import { FormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';

@Component({
selector: 'app-pruebas',
standalone: true,
imports: [
CommonModule,FormsModule,HttpClientModule,
ButtonModule,TableModule
],
templateUrl: './pruebas.component.html',
styleUrl: './pruebas.component.css'
})
export class PruebasComponent implements OnInit {

	parametros:any = {};
	private service: PruebasService;
	datosDB:any = {};
	datosDBArray :any[] = [];

	constructor(){
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getArtistas();
	}

	getArtistas(){
		let pagina = 0;
		let cantidadPorPagina = 3;
		this.service.getPaginado(pagina, cantidadPorPagina).subscribe((ans31) => {
			this.datosDBArray = ans31.content;
		});	
	}

	agregarArtista() {
		this.service.post(this.parametros).subscribe( (ans29) => {
			console.log(ans29);
			this.getArtistas();
		});
	}

	actualizarArtista() {
		this.service.put(this.parametros).subscribe( (ans35) => {
			console.log(ans35);
			this.getArtistas();
		});
	}

	buscarArtista() {
		this.service.getById(this.parametros.id).subscribe((ans41:any) => {
			console.log(ans41);
			this.datosDB = ans41;
		});
	}

	eliminarArtista() {
		this.service.deleteById(this.parametros.id).subscribe((ans47) => {
			console.log(ans47);
			this.getArtistas();
		});
	}

	editar(unObjetoN:any){
		console.log(unObjetoN);
		this.parametros = unObjetoN;
	}

	eliminarArtistaByID(unObjetoID:number) {
		this.service.deleteById(unObjetoID).subscribe((ans67) => {
			console.log(ans67);
			this.getArtistas();
		});
	}

}
