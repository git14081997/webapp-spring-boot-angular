
import {Component, Input,inject} from '@angular/core';
import {CommonModule} from '@angular/common';
import { PruebasService } from './pruebas.service';
import { FormsModule } from '@angular/forms';

@Component({
selector: 'app-pruebas',
standalone: true,
imports: [
CommonModule,FormsModule
],
templateUrl: './pruebas.component.html',
styleUrl: './pruebas.component.css'
})
export class PruebasComponent {

	parametros:any = {};
	private service: PruebasService;
	datosDB:any;

	constructor(){
		this.service = new PruebasService;
	}

	agregar() {
		alert("hola " + this.parametros.nombre );
		/*
		this.service.getById(this.unObjeto).subscribe( (ansPost) => {
			console.log(ansPost);
		});
		*/	
	}

	buscar() {
		this.datosDB = 
		this.service.getArtistaById(this.parametros.id);

		console.log(this.datosDB);
	}

}
