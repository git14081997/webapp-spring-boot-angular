
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';

@Component({
  selector: 'app-usuarios-list',
  standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
		ButtonModule, TableModule
	],
  templateUrl: './usuarios-list.component.html',
  styleUrl: './usuarios-list.component.css'
})
export class UsuariosListComponent implements OnInit {

	parametroServicio: ParametroServicio = {
		url: "http://localhost:8001/api/usuario",
		headers: new HttpHeaders({
			'Content-Type': 'application/json;charset=UTF-8',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	}

	service: PruebasService;
	parametros: any = {};
	objetoSeleccionado: any = {};
	objetos: any[] = [];
	pagina: number = 0;
	cantidad: number = 10;
  verLista: string = 'S';
  verEditable: string = 'N';
  crearOrActualizar: string = 'C';

  constructor() {
		this.service = new PruebasService;
	}

  ngOnInit(): void {
    this.getPorPagina();
  }

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio,this.pagina, this.cantidad).subscribe((RESPONSE: any) => {
			this.objetos = RESPONSE.content;
		});
	}

	eliminarPorID(id: number) {
		this.service.deleteById(this.parametroServicio,id).subscribe((RESPONSE) => {
			this.getPorPagina();
		});
	}

	editar(objetoSeleccionado: any) {
		this.objetoSeleccionado = objetoSeleccionado;
		console.log(this.objetoSeleccionado);
    this.verEditable = 'S';
    this.verLista = 'N';
    this.crearOrActualizar = 'A'
	}

	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
	}

  verVentanaAgregar(){
    this.verLista = 'N';
    this.verEditable = 'S';
    this.crearOrActualizar = 'C';
  }

  agregar(parametros: any){
		this.service.post(this.parametroServicio,parametros).subscribe(() => {
        this.verLista = 'S';
        this.verEditable = 'N';
        this.getPorPagina
    });
	}

	actualizar(parametros: any) {
		this.service.put(this.parametroServicio,parametros).subscribe();
	}
  
}
