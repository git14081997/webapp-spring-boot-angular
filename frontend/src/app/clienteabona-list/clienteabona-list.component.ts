
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
  selector: 'app-clienteabona-list',
  standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
	],
  templateUrl: './clienteabona-list.component.html',
  styleUrl: './clienteabona-list.component.css'
})
export class ClienteabonaListComponent implements OnInit {

	private parametroServicio: ParametroServicio = {
		url: "/api/clienteabona",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	}

	private http = inject(HttpClient);

	objetos: any[] = [];

	pagina: number = 0;
	cantidad: number = 10;
	total: number = 1;
	opcionesCantidadPorPagina = [10, 25, 50, 100];
	paginasDisponibles :number = 1;
	paginasDisponiblesArray: any[] = [];

	tmp:any;

	@Input() idCliente: string = "";

	formatoDeFecha = formatoDeFecha;
	
	constructor() {
	}

	ngOnInit(): void {
		this.getPorPagina();
	}
	
	getPorPagina() {
		
		this.http.get( hostname + this.parametroServicio.url +
			"/" + this.pagina + "/" + this.cantidad +
			"/" + this.idCliente,
			this.parametroServicio.headers
		).subscribe((RESPONSE: any) => {

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

	setCantidadPorPag(){
		this.pagina = 0;
		this.getPorPagina();
	}


}
