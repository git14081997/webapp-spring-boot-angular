
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { hostname } from '../hostname';
import { buscarToken } from '../libproyecto';


@Component({
	selector: 'app-upload-image',
	standalone: true,
	imports: [],
	templateUrl: './upload-image.component.html',
	styleUrl: './upload-image.component.css'
})
export class UploadImageComponent implements OnInit {

	archivoImagen: any;
	http = inject(HttpClient);
	getToken;
	parametroServicio:any = {};


	constructor()
	{
		this.archivoImagen = {};
		this.getToken = buscarToken;
		this.parametroServicio = {};

		this.parametroServicio.url = "/api/image";
		this.parametroServicio.headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': this.getToken()
		});

	}


	ngOnInit(): void {
	}


	upImage()
	{
		let enlaceTemp: string = hostname + this.parametroServicio.url;

		this.http.post<any>(
			enlaceTemp,
			this.archivoImagen,	
			this.parametroServicio.headers
		).subscribe((RESPONSE:any) => {});
	
	}


	onFileChange(unObjetoN: any)
	{

		const target: DataTransfer = <DataTransfer>(unObjetoN.target);
		if (target.files.length !== 1)
		{
			throw new Error('Selecciona una imagen !');
		}

		const reader: FileReader = new FileReader();
		reader.readAsBinaryString(target.files[0]);

		reader.onload = (e: any) => 
		{
		};


	}


} // class 
