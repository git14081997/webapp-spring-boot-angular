
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../pruebas/ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { hostname } from '../hostname';
import { IVA } from '../impuestos';

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
			'Authorization': 'Bearer ' + localStorage.getItem("personal-token")
		})
	}

	private http = inject(HttpClient);
	service: PruebasService;
	parametros: any = {};
	objetoSeleccionado: any = {};
	objetos: any[] = [];
	verLista: string = 'S';
	verEditable: string = 'N';
	verAgregar: string = 'N';
	verInventario:string = 'N';
	crearOrActualizar: string = 'C';

	pagina: number = 0;
	cantidad: number = 10;
	total: number = 1;
	opcionesCantidadPorPagina = [10, 25, 50, 100];
	paginasDisponibles :number = 1;
	paginasDisponiblesArray: any[] = [];

	tmp:any;
  categoriasDisponibles:any[] = [];
	formatoDeFecha = formatoDeFecha;

	regInventario: any[] = [];

	constructor() {
		this.service = new PruebasService;
	}

	ngOnInit(): void {
		this.getPorPagina();
    this.getCategorias();
	}

  getCategorias(){
    this.getPaginadoCategorias(this.parametroServicio)
      .subscribe((RESPONSE) => {
        this.tmp = RESPONSE;
        this.categoriasDisponibles = this.tmp.content;
      });
  }

	setCantidadPorPag(){
		this.pagina = 0;
		this.getPorPagina();
	}

	getPorPagina() {
		this.service.getPaginado(this.parametroServicio, this.pagina, this.cantidad
			).subscribe((RESPONSE: any) => {

				this.tmp = RESPONSE;

				this.objetos = this.tmp.content;
				this.paginasDisponibles = this.tmp.totalPages;
				this.total = this.tmp.totalElements;

				for( let objetoN of this.objetos ){
					objetoN.fechaAdquisicionn = formatoDeFecha( objetoN.fechaAdquisicion );
				}

				this.paginasDisponiblesArray = [];
				for(let i = 0; i < this.paginasDisponibles; i++){
					let newObj = { "numPagina": i };
					this.paginasDisponiblesArray.push(newObj);
				}

			});
	}

	getPorPaginaNum(numPagina:number) {
		if(numPagina >= this.paginasDisponibles ){
			numPagina = this.paginasDisponibles - 1;
		}
		if(numPagina <= 0){
			numPagina = 0;
		}
		this.pagina = numPagina;
		this.getPorPagina();
	}

	eliminarPorID(id: number) {
		this.service.deleteById(
			this.parametroServicio, id
		).subscribe((RESPONSE) => {
			this.getPorPagina();
		});
	}

	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
	}

	verVentanaAgregar() {
		this.objetoSeleccionado = {};
		this.verLista = 'N';
		this.verEditable = 'N';
		this.verAgregar = 'S';
		this.crearOrActualizar = 'C';
	}

	verVentanaEditar() {
		this.objetoSeleccionado = {};
		this.verLista = 'N';
		this.verEditable = 'S';
		this.verAgregar = 'N';
		this.crearOrActualizar = 'A';
		this.verInventario = 'N';

	}

	verListado() {
		this.verLista = 'S';
		this.verEditable = 'N';
		this.verAgregar = 'N';
		this.verInventario = 'N';
		this.objetoSeleccionado = {};
	}

	agregar(parametros: any) {
		this.service.post(this.parametroServicio,parametros).subscribe(() => {
			this.verListado();
			this.getPorPagina();
		});
		
	}

	actualizar(parametros: any) {

		let tmpCategoria:any = {};
    tmpCategoria.id = parametros.categoriaId;
    parametros.categoria = tmpCategoria;

		this.service.put(
			this.parametroServicio,
			parametros
		).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			this.objetoSeleccionado = {};
			window.location.reload();
		});
	}





	buscarEnDb(parametros: any){

		let descripcion = parametros;

		this.getPaginadoBuscando(
			this.parametroServicio, 0, 20, descripcion
		).subscribe((RESPONSE) => {

			this.tmp = RESPONSE;

			this.objetos = this.tmp.content;
			this.paginasDisponibles = this.tmp.totalPages;
			this.total = this.tmp.totalElements;

			this.paginasDisponiblesArray = [];
			for(let i = 0; i < this.paginasDisponibles; i++){
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}
		});
	}

	limpiarBusqueda(){
		this.objetoSeleccionado.buscar = "";
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina();
	}

	getPaginadoBuscando(parametro:ParametroServicio, 
		pagina: number, cantidad: number,nombre: string): Observable<any> {

		return this.http.get<any>(
			hostname + parametro.url + "/" + pagina + "/" + cantidad +
			"/buscar" + "?nombre="+nombre,
			parametro.headers);
	}

	getPaginadoCategorias(parametro:ParametroServicio): Observable<any> {
		return this.http.get<any>(
      hostname + "/api/categoria" + "/" + 0 + "/" + 10,
			parametro.headers);
	}







	cargarImagen(objetoN:any){

		// max file size
		// (1048576 * 2) 2 MegaBytes

		this.tmp = new FormData();
		this.tmp.append("fileImagen",objetoN.target.files[0]);

		this.http.put<any>(
			hostname + "/api/producto/" + this.objetoSeleccionado.id, 
			this.tmp, 
			this.parametroServicio.headers
		).subscribe(() => {

			this.verLista = 'S';
			this.verEditable = 'N';

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
		this.verLista = 'N';
		this.verEditable = 'S';
	}


	


	agregarAlInventario(unObjeto:any){

		let info:any = {
			idProducto: unObjeto.id,
			entradasProducto: unObjeto.nuevasUnidades
		};

		this.http.post<any>(
			hostname + "/api/producto/add", info,	this.parametroServicio.headers
		).subscribe(() => {
			this.verLista = 'S';
			this.verEditable = 'N';
			window.location.reload();
		});

	}


	verVentanaInventario(){

		let paginaInventario = "0";
		let cantidadInventario = "50";

		console.log( this.objetoSeleccionado.id );

		this.http.get<any>(
			hostname + "/api/inventario/" +	paginaInventario + "/" + cantidadInventario +
			"/" + this.objetoSeleccionado.id,
			this.parametroServicio.headers
		).subscribe(( RESPONSE ) => {
			this.tmp = RESPONSE;
			this.regInventario = this.tmp.content;
		});


		this.verLista = 'N';
		this.verEditable = 'N';
		this.verInventario = 'S';		

	}


}
