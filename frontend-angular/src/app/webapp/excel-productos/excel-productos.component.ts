
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { hostname } from '../hostname';
import * as XLSX from 'xlsx';
import { buscarToken } from '../libproyecto';

@Component({
	selector: 'app-excel-productos',
	standalone: true,
	imports: [],
	templateUrl: './excel-productos.component.html'
})
export class ExcelProductosComponent implements OnInit
{

	servidor: any = {};
	temporal:any;	

	productos: any[] = [];
	archivoLeido: boolean = false;

	http = inject(HttpClient);
	getToken = buscarToken;

	parametroServicio:any = {};

ngOnInit(): void
{

this.parametroServicio.url = "/api/producto";
this.parametroServicio.headers = new HttpHeaders({
'Content-Type': 'application/json',
'Accept': 'application/json',
'Authorization': this.getToken()
});

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
		this.temporal = RESPONSE;
		this.servidor.recibio = this.temporal.in;
		this.servidor.guardo = this.temporal.out;
		alert("Productos guardados :" + this.servidor.guardo );
		window.location.href = "/productos";
	});
}

	
upUsuarios()
{

	let enlaceTemp: string = hostname + "/api/usuario" + '/upload';

	this.http.post<any>( enlaceTemp, this.productos,	
		this.parametroServicio.headers).subscribe((RESPONSE:any) => {
		this.productos = [];
		this.temporal = RESPONSE;
		this.servidor.recibio = this.temporal.in;
		this.servidor.guardo = this.temporal.out;
		alert("Usuarios guardados :" + this.servidor.guardo );
		window.location.href = "/usuarios";
	});

}


} // componente 
