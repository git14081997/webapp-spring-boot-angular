
import { Component } from '@angular/core';
import { CommonModule} from '@angular/common';
import { PruebasService } from './pruebas.service';
import { FormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';

@Component({
selector: 'app-pruebas',
standalone: true,
imports: [
CommonModule,FormsModule,HttpClientModule,
ButtonModule
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

	agregarArtista() {
		this.service.post(this.parametros).subscribe( (ans29) => {
			console.log(ans29);
		});
	}

	actualizarArtista() {
		this.service.put(this.parametros).subscribe( (ans35) => {
			console.log(ans35);
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
		});
	}

}
