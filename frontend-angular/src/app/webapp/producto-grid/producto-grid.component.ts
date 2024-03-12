
import { Component, OnInit } from '@angular/core';
import { ImgridComponent } from '../imgrid/imgrid.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';
import { buscarToken, cantidadPorPagina } from '../libproyecto';

@Component({
	selector: 'app-producto-grid',
	standalone: true,
	imports: [    
	ImgridComponent
],
	templateUrl: './producto-grid.component.html',
	styleUrl: './producto-grid.component.css'
})
export class ProductoGridComponent implements OnInit
{

	http;
	productos: any[];
	parametroServicio: any;

	pagina: number;
	cantidad: number;
	opcionesCantidadPorPagina: any[];

	constructor()
	{
		this.productos = [];
		this.http = inject(HttpClient);
		
		this.opcionesCantidadPorPagina = cantidadPorPagina;
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];

		this.parametroServicio = {};
		this.parametroServicio.url = hostname + "/api/producto/" + this.pagina + "/" + this.cantidad + "/image";

		this.parametroServicio.headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': buscarToken()
		});

	}


	ngOnInit(): void
	{
	}


	getProductoImage()
	{
		this.http.get<any>(
			this.parametroServicio.url,
			this.parametroServicio.headers
		).subscribe((ans:any) => {
			this.productos = ans.content;
			let max = this.productos.length;
			for( let i = 0; i < max; i++ )
			{
				this.productos[i].imagenLink = hostname + "/api/image/" + this.productos[i].image;
			}
		});
	}



}
