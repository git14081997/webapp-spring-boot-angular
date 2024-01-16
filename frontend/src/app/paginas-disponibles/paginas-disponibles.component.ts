
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, inject } from '@angular/core';
import { hostname } from '../hostname';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-paginas-disponibles',
  standalone: true,
  imports: [
    CommonModule, FormsModule, HttpClientModule,
  ],
  templateUrl: './paginas-disponibles.component.html',
  styleUrl: './paginas-disponibles.component.css'
})
export class PaginasDisponiblesComponent {

  @Input() urlGetPaginado!: string;

  param: ParametroServicio = {
    url: this.urlGetPaginado,
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    })
  };

  private http = inject(HttpClient);
  opcionesCantidadPorPagina = [1, 2, 25, 50, 100];
  pagina: number = 0;
  cantidad: number = this.opcionesCantidadPorPagina[0];
  paginasDisponibles: number = 0;
  paginasDisponiblesArray: any[] = [];
  total: number = 0;
  tmp: any;

  setCantidadPorPag() {
    this.pagina = 0;
    this.getPorPagina(this.pagina, this.cantidad);
  }

  getPorPagina(pagina: number, cantidad: number) {

    let urlTempGetPaginado = hostname + this.param.url + "/" + pagina + "/" + cantidad;

    this.http.get<any>(
      urlTempGetPaginado,
      this.param.headers
    ).subscribe((RESPONSE: any) => {

      this.tmp = RESPONSE;

      this.paginasDisponibles = this.tmp.totalPages;
      this.total = this.tmp.totalElements;

      this.paginasDisponiblesArray = [];

      for (let i = 0; i < this.paginasDisponibles; i++) {
        let newObj = { "numPagina": i };
        this.paginasDisponiblesArray.push(newObj);
      }

      delete this.tmp;
      this.tmp = {};

    });
  }



  getPorPaginaNum(numPagina: number) {
    if (numPagina >= this.paginasDisponibles) {
      numPagina = this.paginasDisponibles - 1;
    }
    if (numPagina <= 0) {
      numPagina = 0;
    }
    this.pagina = numPagina;
    this.getPorPagina(this.pagina, this.cantidad);
  }


}
