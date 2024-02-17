
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

	archivoImagen: File;
	http = inject(HttpClient);

	getToken;
	parametroServicio:any = {};

	enlace: string;

	constructor()
	{
		this.enlace = "";
		this.archivoImagen = new File([], "");

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


	onUpload()
	{
		let enlaceTemp: string = hostname + this.parametroServicio.url;

		const formData = new FormData();
    formData.append('file', this.archivoImagen);
		
		this.http.post<any>(
			enlaceTemp,
			formData,
			this.parametroServicio.headers
		).subscribe((RESPONSE) => {
			console.log('response', RESPONSE);
		});
	
	}



	onFileSelected(unObjetoN: any)
	{
		this.archivoImagen = unObjetoN.target.files[0];
		
		let urlLocalToImage =  URL.createObjectURL( this.archivoImagen );
		this.enlace = urlLocalToImage;

	}





} // class 
