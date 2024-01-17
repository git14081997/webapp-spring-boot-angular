
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { hostname } from '../../hostname';

@Component({
  selector: 'app-producto-list',
  standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
		
	],
  templateUrl: './producto-list.component.html',
  styleUrl: './producto-list.component.css'
})
export class ProductoListComponent implements OnInit {

	private parametroServicio: ParametroServicio = {
		url: "/api/producto",
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer ' + localStorage.getItem('token')
		})
	}

	private http = inject(HttpClient);
	service: PruebasService;

	parametros: any = {};
	objetoSeleccionado: any = {};
	objetos: any[] = [];
	tmp:any;

	verLista: string = 'S';
	verEditable: string = 'N';
	verAgregar: string = 'N';
	verInventario:string = 'N';
	
	crearOrActualizar: string = 'C';
	formatoDeFecha = formatoDeFecha;
	
	/* variables de paginacion */
	enlaceActual: string = this.parametroServicio.url;
	paramActual: string = "";
	opcionesCantidadPorPagina = [1,50, 100];
	pagina: number = 0;
	cantidad: number = this.opcionesCantidadPorPagina[0];
	paginasDisponibles: number = 0;
	paginasDisponiblesArray: any[] = [];
	total: number = 0;
	/* variables de paginacion */


	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina(this.enlaceActual);
	}


	verVentanaAgregar() {

		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "";

		this.verAgregar = 'S';
		this.verLista = 'N';
		this.verEditable = 'N';
		this.verInventario = 'N';

		this.crearOrActualizar = 'C';
		this.objetoSeleccionado = {};
	}


	verVentanaEditar() {

		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "";

		this.verEditable = 'S';
		this.verLista = 'N';
		this.verAgregar = 'N';
		this.verInventario = 'N';

		this.crearOrActualizar = 'A';

		this.objetoSeleccionado = {};

	}


	verListado() {

		this.verLista = 'S';
		this.verEditable = 'N';
		this.verAgregar = 'N';
		this.verInventario = 'N';

		this.objetoSeleccionado = {};
		
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "";
		this.getPorPagina(this.enlaceActual);

	}

	agregar() {
		this.service.post(this.parametroServicio,this.objetoSeleccionado).subscribe(() => {
			this.verListado(); window.location.reload();
		});
	}

	actualizar() {
		this.service.put(this.parametroServicio, this.objetoSeleccionado).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			delete this.objetoSeleccionado;
			window.location.reload();
		});
	}

	cargarImagen(objetoN:any){

		// max file size
		// (1048576 * 2) 2 MegaBytes

		this.tmp = new FormData();
		this.tmp.append("fileImagen",objetoN.target.files[0]);

		let enlaceTemp = hostname + "/api/producto" +"/"+ this.objetoSeleccionado.id;
		this.http.put<any>(enlaceTemp, this.tmp, this.parametroServicio.headers).subscribe(() => {
			this.verLista = 'S'; this.verEditable = 'N';
		});


				/* proximamente se podra traer una imagen y mostrarla
		// getImagenProducto
		this.http.get<any>(
			hostname + this.parametroServicio.url + "/pic/" + this.objetoSeleccionado.id,
			this.parametroServicio.headers
		).subscribe((imagenN:any) => {
			this.objetoSeleccionado.srcImagen = imagenN;
		});
		*/
		
	}


	actualizarSeleccionado(parametros: any) {
		this.objetoSeleccionado = parametros;
		this.crearOrActualizar = 'A';

		this.verEditable = 'S';
		this.verLista = 'N';
		this.verAgregar = 'N';
		this.verInventario = 'N';
	}


	agregarAlInventario(unObjeto:any){

		let info:any = {
			idProducto: unObjeto.id,
			entradasProducto: unObjeto.nuevasUnidades
		};

		let enlaceTemp = hostname + this.parametroServicio.url + "/add";

		this.http.post<any>(enlaceTemp, info,	this.parametroServicio.headers).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			window.location.reload();
		});

	}


	buscarEnDb(parametros: any){
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[ (this.opcionesCantidadPorPagina.length - 1) ];
		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "/buscar?nombre=" + parametros;
		this.getPorPagina(this.enlaceActual);
		this.paramActual = "";
	}


	limpiarBusqueda(){
		this.objetoSeleccionado.buscar = "";

		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.enlaceActual = this.parametroServicio.url;
		this.paramActual = "";
		this.getPorPagina(this.enlaceActual);

	}


	verVentanaInventario(){
		this.verLista = 'N';
		this.verEditable = 'N';
		this.verInventario = 'S';

		this.enlaceActual = "/api/inventario";
		this.paramActual = "/" + this.objetoSeleccionado.id;

		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina(this.enlaceActual);

	}





	/* metodos para paginacion */
	actualizarContadores(pagDisponibles: number, total: number){
		this.paginasDisponibles = pagDisponibles;
		this.total = total;
		this.paginasDisponiblesArray = [];
		for (let i = 0; i < this.paginasDisponibles; i++) {
			let newObj = { "numPagina": i };
			this.paginasDisponiblesArray.push(newObj);
		}
	}

  setCantidadPorPag() {
    this.pagina = 0;
    this.getPorPagina(this.enlaceActual);
  }

  getPorPaginaNum(numPagina: number) {
    if (numPagina >= this.paginasDisponibles) {
      numPagina = this.paginasDisponibles - 1;
    }
    if (numPagina <= 0) {
      numPagina = 0;
    }
    this.pagina = numPagina;
    this.getPorPagina(this.enlaceActual);
  }


	getPorPagina(urlAlRecurso: string) {
    let urlGetPaginado = hostname + urlAlRecurso + "/" + this.pagina + "/" + this.cantidad + this.paramActual;
    this.http.get<any>(urlGetPaginado, this.parametroServicio.headers).subscribe((RESPONSE: any) => {
      this.tmp = RESPONSE;
			this.objetos = this.tmp.content;
			this.actualizarContadores(this.tmp.totalPages, this.tmp.totalElements);
    });
  }
	/* metodos para paginacion */

}
