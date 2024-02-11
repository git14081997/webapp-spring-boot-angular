
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';
import { buscarToken, cantidadPorPagina } from '../libproyecto';

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

	parametroServicio: any = {};
	getToken = buscarToken;

	http = inject(HttpClient);
	objetoSeleccionado:any = {};
	objetos: any[] = [];
	tmp:any;
	@Input() idCliente: string = "";
	formatoDeFecha = formatoDeFecha;

	/* variables de paginacion */
	enlaceActual: string = "";
	paramActual: string = "";
	opcionesCantidadPorPagina = cantidadPorPagina;
	pagina: number = 0;
	cantidad: number = this.opcionesCantidadPorPagina[0];
	paginasDisponibles: number = 0;
	paginasDisponiblesArray: any[] = [];
	total: number = 0;
	/* variables de paginacion */

	ngOnInit(): void {

		this.opcionesCantidadPorPagina = cantidadPorPagina;
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];

		this.parametroServicio.url = "/api/clienteabona";
		this.parametroServicio.headers = new HttpHeaders(
		{
		'Content-Type': 'application/json',
		'Accept': 'application/json',
		'Authorization': this.getToken()
		}
		);

		this.enlaceActual = this.parametroServicio.url;

		this.paramActual = "/" + this.idCliente;
		this.getPorPagina(this.enlaceActual);
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
      numPagina = this.paginasDisponibles - 1;
    }
    if (numPagina <= 0) {
      numPagina = 0;
    }
    this.pagina = numPagina;
    this.getPorPagina(this.enlaceActual);
  }


	getPorPagina(urlAlRecurso: string) {
    let urlGetPaginado = hostname + urlAlRecurso + "/" + this.pagina + "/" + this.cantidad + this.paramActual;
    this.http.get<any>(urlGetPaginado, this.parametroServicio.headers).subscribe((RESPONSE: any) => {
      this.tmp = RESPONSE;
			this.objetos = this.tmp.content;
			this.actualizarContadores(this.tmp.totalPages, this.tmp.totalElements);
    });
  }
	/* metodos para paginacion */

}
