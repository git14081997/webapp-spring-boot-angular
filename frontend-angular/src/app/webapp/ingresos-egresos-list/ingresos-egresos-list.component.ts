
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';
import { dosDecimales } from '../libproyecto';
import { buscarToken, moneda } from '../libproyecto';
import { info } from 'node:console';

@Component({
	selector: 'app-ingresos-egresos-list',
	standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
	],
	templateUrl: './ingresos-egresos-list.component.html',
	styleUrl: './ingresos-egresos-list.component.css'
})
export class IngresosEgresosListComponent implements OnInit {

	http;
	registrosIngresosEgresos: any[];

	sumaIngresos:number;
	sumaEgresos:number;

	param: any;
	formatoDeFecha;

	dosDecimales;
	verAgregarGasto:string;
	
	parametroServicio: any;
	getToken;

	monedaActual;
	verHistorico:boolean;
	verHistoricoGanancias: boolean;

	constructor()
	{
		this.http = inject(HttpClient);
		this.registrosIngresosEgresos = [];
	
		this.sumaIngresos = 0;
		this.sumaEgresos = 0;
	
		this.param = {};

		this.formatoDeFecha = formatoDeFecha;
	
		this.dosDecimales = dosDecimales;
		this.verAgregarGasto = 'N';
		

		this.getToken = buscarToken;
	
		this.monedaActual = moneda;
		this.verHistorico = true;
		this.verHistoricoGanancias = false;

		this.parametroServicio = {};
		this.parametroServicio.url = "/api/ie";
		this.parametroServicio.headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': this.getToken()
		});

		let fechaActual = new Date();
		this.param.mes = fechaActual.getMonth() + 1;
		this.param.anio = fechaActual.getFullYear();

	} // constructor 


	ngOnInit(): void {
	}


	consultarIE()
	{
		this.http.get<any>(
			hostname + this.parametroServicio.url + "/" + this.param.anio + "/" + this.param.mes,
			this.parametroServicio.headers
		).subscribe((RESPONSE:any) => {
			this.registrosIngresosEgresos = RESPONSE;
			this.sumaEgresos = 0;
			this.sumaIngresos = 0;
			for( let lineaN of this.registrosIngresosEgresos  ){
				this.sumaIngresos += lineaN.ingresos;
				this.sumaEgresos += lineaN.egresos;
			}
		});
	}


	addGasto(){
		let logEgresoDetalle:any = {
			egresos: this.param.egresos,
			detalle: this.param.detalle
		};

		this.http.post<any>(
			hostname + this.parametroServicio.url, logEgresoDetalle, this.parametroServicio.headers
		).subscribe(() => {
			this.verAgregarGasto = 'N';
			this.param = {};
			window.location.reload();
		});
	}


	verVentanaAgregarGasto()
	{
		this.verHistorico = false;
		this.verHistoricoGanancias = false;

		if(this.verAgregarGasto == 'S'){
			this.verAgregarGasto = 'N';
		}
		else {
			this.verAgregarGasto = 'N';
		}
	}


	seleccionar(unObjeto:any)
	{
		this.param.seleccionado = unObjeto;
	}
	

	consultarGanancias()
	{
		this.verHistorico = false;
		this.verHistoricoGanancias = true;
		this.verAgregarGasto = 'N';

		this.http.get<any>(
			hostname + "/api/factura/resumen", this.parametroServicio.headers
		).subscribe((infoData:any) => {
			this.registrosIngresosEgresos = infoData.datos;
		});
	}


}
