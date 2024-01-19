
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { ParametroServicio } from '../../webapp/pruebas/ParametroServicio';
import { hostname } from '../../hostname';
import * as XLSX from 'xlsx';

@Component({
	selector: 'app-excel-productos',
	standalone: true,
	imports: [],
	templateUrl: './excel-productos.component.html',
	styleUrl: './excel-productos.component.css'
})
export class ExcelProductosComponent implements OnInit
{

	productos: any[] = [];
	archivoLeido: boolean = false;

	private http = inject(HttpClient);

	private parametroServicio: ParametroServicio = 
	{
		url: "/api/producto",
		headers: new HttpHeaders(
			{
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer ' + localStorage.getItem('token')
			}
		)
	}


	constructor()
	{
	}


	ngOnInit(): void
	{

		//localStorage.clear();
		//localStorage.setItem("token", "fas9df79asf79as8f79as8f7d9as87f9sa");

		let tokenSesion: string = localStorage.getItem('token') || "";

		if( tokenSesion.length > 0 )
		{
			console.log("hay token !");
			let tokenCompleto:string = "Bearer " + tokenSesion;
			tokenSesion = tokenCompleto;
			console.log(tokenSesion);
		}
		else
		{
			console.log("no hay token guardado");
		}

		this.parametroServicio.headers = new HttpHeaders(
			{
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': tokenSesion
			}
		);

	}


	servidor: any = {};
	temporal:any;

	upProductos()
	{


		let enlaceTemp: string = hostname + this.parametroServicio.url + '/upload';

		this.http.post<any>(
			enlaceTemp,
			this.productos,	
			this.parametroServicio.headers)
		.subscribe((RESPONSE:any) => 
		{

			this.productos = [];
			
			console.log("Response inicio");
			this.temporal = RESPONSE;
			console.log(RESPONSE);

			this.servidor.recibio = this.temporal.in;
			this.servidor.guardo = this.temporal.out;

			console.log("Response fin");

		});

		console.log("Se carga la información de productos a la base de datos !");

	}



onFileChange(unObjetoN:any)
{

const target: DataTransfer = <DataTransfer>(unObjetoN.target);
if (target.files.length !== 1)
{
	throw new Error('Cannot use multiple files');
}

const reader: FileReader = new FileReader();
reader.readAsBinaryString(target.files[0]);

reader.onload = (e: any) => 
{

const binarystr: string = e.target.result;
const wb: any = XLSX.read(binarystr, { type: 'binary' });
const wsname: string = wb.SheetNames[0];
const ws: any = wb.Sheets[wsname];
const data = XLSX.utils.sheet_to_json(ws);

this.productos = data as any[];
this.archivoLeido = true;
/*
if( this.productos.length > 0 )
{
this.archivoLeido = true;
}
*/


};


} // onFileChange

	

}
