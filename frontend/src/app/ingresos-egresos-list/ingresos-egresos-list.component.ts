
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../hostname';

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

  ngOnInit(): void {
    let fechaActual = new Date();

    this.param.mes = fechaActual.getMonth() + 1 ;
    this.param.anio = fechaActual.getFullYear() ;

    this.consultarIE();

  }

	private http = inject(HttpClient);

  private parametroServicio: ParametroServicio = {
		url: "/api/ie",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	}

  registrosIngresosEgresos: any[] = [];
  sumaIngresos:number = 0;
  sumaEgresos:number = 0;
  param: any = {};
  formatoDeFecha = formatoDeFecha;
  verAgregarGasto:string = 'N';

  consultarIE(){
    this.http.get<any>(
			hostname + "/api/ie/" + this.param.anio + "/" + this.param.mes,
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
			hostname + "/api/ie",
      logEgresoDetalle,
			this.parametroServicio.headers
		).subscribe((RESPONSE) => {
      this.verAgregarGasto = 'N';
      this.param = {};
      this.consultarIE();
    });

  }


  verVentanaAgregarGasto(){
    if(this.verAgregarGasto == 'S'){
      this.verAgregarGasto = 'N';
    }
    else {
      this.verAgregarGasto = 'S';
    }
  }


}
