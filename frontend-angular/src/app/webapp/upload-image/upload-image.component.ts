
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

	productoId :number;


	constructor()
	{
		this.productoId = 0;
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


	ngOnInit(): void
	{
		this.productoId = Number( localStorage.getItem('tmp'));
	}


	onUpload()
	{
		let enlaceTemp: string = hostname + this.parametroServicio.url;

		if( this.productoId != 0 )
		{
			enlaceTemp += "?productoid=" + this.productoId;
		}

		const formData = new FormData();
		formData.append('file', this.archivoImagen);
		
		this.http.post<any>(
			enlaceTemp,
			formData,
			this.parametroServicio.headers
		).subscribe((RESPONSE:any) => {
			
			let temporal:any = RESPONSE;
			
			if( temporal.error ){
				alert(temporal.error);
			}

			if( temporal.id ){
				alert("imageId = " + temporal.id );
			}

		});
	
	}

	


	onFileSelected(unObjetoN: any)
	{
		this.archivoImagen = unObjetoN.target.files[0];
		
		let urlLocalToImage =  URL.createObjectURL( this.archivoImagen );
		this.enlace = urlLocalToImage;

	}





} // class 
