
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject } from '@angular/core';
import { ParametroServicio } from '../../webapp/pruebas/ParametroServicio';
import { hostname } from '../../hostname';

@Component({
  selector: 'app-excel-productos',
  standalone: true,
  imports: [],
  templateUrl: './excel-productos.component.html',
  styleUrl: './excel-productos.component.css'
})
export class ExcelProductosComponent implements OnInit {

  private http = inject(HttpClient);

	private parametroServicio: ParametroServicio = {
		url: "/api/producto/upload",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer ' + localStorage.getItem('token')
		})
	}

  constructor() {
  }

  ngOnInit(): void {

    localStorage.setItem("token", "fas9df79asf79as8f79as8f7d9as87f9sa");

    let tokenSesion = localStorage.getItem('token');
    console.log( tokenSesion );

    this.parametroServicio.headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer ' + tokenSesion
		});

    console.log( this.parametroServicio.headers );

  }


  upProductos(){

    let enlaceTemp: string = hostname + this.parametroServicio.url;
    let objetoN: any = {
      "archivoExcel": "productos"
    };

    this.http.post<any>(enlaceTemp, objetoN,	this.parametroServicio.headers)
    .subscribe((RESPONSE:any) => {
      
      console.log("Response inicio");
      console.log(RESPONSE);
      console.log("Response fin");

    });

    console.log("Se carga la información de productos a la base de datos !");

  }



  onFileChange(unObjetoN:any){
  }

  

}
