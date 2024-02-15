
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ParametroServicio } from '../ParametroServicio';
import { PruebasService } from '../pruebas/pruebas.service';
import { formatoDeFecha } from '../libproyecto';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { hostname } from '../hostname';
import { FacturaListComponent } from '../factura-list/factura-list.component';
import { ClienteabonaListComponent } from '../clienteabona-list/clienteabona-list.component';
import { buscarToken, cantidadPorPagina } from '../libproyecto';

@Component({
	selector: 'app-usuarios-list',
	standalone: true,
	imports: [
		CommonModule, FormsModule, HttpClientModule,
		FacturaListComponent, ClienteabonaListComponent
	],
	templateUrl: './usuarios-list.component.html',
	styleUrl: './usuarios-list.component.css'
})
export class UsuariosListComponent implements OnInit {

	parametroServicio: any = {};
	http = inject(HttpClient);

	service: PruebasService;
	parametros: any = {};

	objetoSeleccionado: any = {};
	objetos: any[] = [];

	verLista: string = 'S';
	verAgregar: string = 'N';

	verEditable: string = 'N';
	verEditarcomentario: string = 'N';

	verAgregarAbono: boolean = false;
	verTablaCargosAbonos: boolean = false;

	verTablaFacturas: boolean = false;
	esRebajaOrDescuento: boolean = false;

	crearOrActualizar: string = 'C';
	tmp: any;

	/* variables de paginacion */
	enlaceActual: string = "";
	paramActual: string = "";

	opcionesCantidadPorPagina = cantidadPorPagina;
	pagina: number = 0;

	cantidad: number = this.opcionesCantidadPorPagina[0];
	paginasDisponibles: number = 0;

	paginasDisponiblesArray: any[] = [];
	total: number = 0;
	/* variables de paginacion */



	getToken = buscarToken;

	constructor() {
		this.service = new PruebasService;
		this.objetoSeleccionado = {};
		this.objetoSeleccionado.buscar = "";
	}


	ngOnInit(): void {

		this.opcionesCantidadPorPagina = cantidadPorPagina;
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
	

		this.parametroServicio.url = "/api/usuario";
		this.parametroServicio.headers = new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': this.getToken()
		});


		this.getPorPagina();
	}


	setCantidadPorPag() {
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

			for (let objetoN of this.objetos) {
				objetoN.cumpleanoss = formatoDeFecha(objetoN.cumpleanos);
			}

			this.paginasDisponiblesArray = [];
			for (let i = 0; i < this.paginasDisponibles; i++) {
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}

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
		this.getPorPagina();
	}


	setPaginaCantidad(pagina: number, cantidad: number) {
		this.pagina = pagina;
		this.cantidad = cantidad;
	}


	verVentanaAgregar() {
		this.objetoSeleccionado = {};
		this.verLista = 'N';
		this.verAgregar = 'S';
		this.verEditable = 'N';
		this.crearOrActualizar = 'C';
	}


	verVentanaEditar() {
		this.objetoSeleccionado = {};

		this.verLista = 'N';
		this.verAgregar = 'N';
		this.verEditable = 'S';
		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = false;
		this.verTablaFacturas = false;

		this.crearOrActualizar = 'A';
	}


	verListado() {

		this.verLista = 'S';
		this.verEditable = 'N';
		this.verAgregar = 'N';
		this.verEditarcomentario = 'N';

		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = false;
		this.verTablaFacturas = false;

		this.objetoSeleccionado = {};
	}


	agregar(parametros: any) {
		this.service.post(this.parametroServicio, parametros).subscribe(() => {
			this.verListado();
			this.getPorPagina();
		});
	}


	actualizar(parametros: any) {
		this.service.put(this.parametroServicio, parametros).subscribe(() => {
			this.objetoSeleccionado = {};
			window.location.reload();
		});
	}


	actualizarSeleccionado(parametros: any) {
		this.objetoSeleccionado = parametros;
		this.crearOrActualizar = 'A';

		this.verLista = 'N';
		this.verEditable = 'S';
		this.verAgregar = 'N';
		this.verEditarcomentario = 'N';
		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = false;
		this.verTablaFacturas = false;

	}


	buscarEnDb(parametros: any) {

		let arrayRes = parametros.split(" ");

		let nombre = arrayRes[0];
		let apellido = "";
		if (arrayRes.length > 1) {
			apellido = arrayRes[1];
		}

		this.getPaginadoBuscando(this.parametroServicio, 0, 20, nombre).subscribe((RESPONSE) => {

			this.tmp = RESPONSE;

			this.objetos = this.tmp.content;
			this.paginasDisponibles = this.tmp.totalPages;
			this.total = this.tmp.totalElements;

			for (let objetoN of this.objetos) {
				objetoN.cumpleanoss = formatoDeFecha(objetoN.cumpleanos);
			}

			this.paginasDisponiblesArray = [];
			for (let i = 0; i < this.paginasDisponibles; i++) {
				let newObj = { "numPagina": i };
				this.paginasDisponiblesArray.push(newObj);
			}

		});
	}


	limpiarBusqueda() {
		this.objetoSeleccionado.buscar = "";
		this.pagina = 0;
		this.cantidad = this.opcionesCantidadPorPagina[0];
		this.getPorPagina();
	}


	getPaginadoBuscando(
		parametro: ParametroServicio,
		pagina: number,
		cantidad: number,
		nombre: string): Observable<any> {

		return this.http.get<any>(
			hostname + parametro.url + "/" + pagina + "/" + cantidad +
			"/buscar" + "?nombre=" + nombre, parametro.headers
		);
	}




	mostrarCargosAbonos() {
		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = true;
		this.verTablaFacturas = false;

		this.verEditable = 'S';
		this.verEditarcomentario = 'N';
		this.verAgregar = 'N';
		this.verLista = 'N';

	}

	mostrarAgregarAbono() {
		this.verAgregarAbono = true;
		this.verTablaCargosAbonos = false;
		this.verTablaFacturas = false;

		this.verEditable = 'S';
		this.verEditarcomentario = 'N';
		this.verAgregar = 'N';
		this.verLista = 'N';

	}

	mostrarFacturas() {
		this.verEditable = 'S';
		this.verTablaFacturas = true;
		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = false;
		this.verEditarcomentario = 'N';
		this.verAgregar = 'N';
		this.verLista = 'N';
	}


	agregarAbono(): number {

		let logCargosAbonos: any = {
			cargos: 0,
			abonos: this.objetoSeleccionado.abono,
			cliente: {
				id: this.objetoSeleccionado.id
			}
		};

		let enlace = hostname + "/api/clienteabona";

		if (this.esRebajaOrDescuento && this.objetoSeleccionado.info != "" && this.objetoSeleccionado.info != undefined) {
			enlace += "?descuento=1&info=" + this.objetoSeleccionado.info;
			this.enviarAbono(enlace, logCargosAbonos);
			return 0;
		}

		if (this.esRebajaOrDescuento) {
			enlace += "?descuento=1";
			this.enviarAbono(enlace, logCargosAbonos);
			return 0;
		}

		if (this.objetoSeleccionado.info != "" && this.objetoSeleccionado.info != undefined) {
			enlace += "?info=" + this.objetoSeleccionado.info;
			this.enviarAbono(enlace, logCargosAbonos);
			return 0;
		}

		this.enviarAbono(enlace, logCargosAbonos);
		return 0;

	}


	esRebaja() {
		this.esRebajaOrDescuento = !this.esRebajaOrDescuento;
	}

	formatoBool(varBoolean: boolean): string {
		if (varBoolean) {
			return "Sí";
		}
		else {
			return "No";
		}
	}

	enviarAbono(enlace: string, logCargosAbonos: any) {
		this.http.post<any>(enlace, logCargosAbonos, this.parametroServicio.headers).subscribe(() => {

			this.verEditarcomentario = 'N';
			this.verEditable = 'N';
			this.verAgregar = 'N';
			this.verLista = 'S';
			this.verAgregarAbono = false;
			this.verTablaCargosAbonos = false;
			this.verTablaFacturas = false;

			this.objetoSeleccionado = {};
			window.location.reload();
		});
	}


	mostrarEditarComentario() {
		this.verEditarcomentario = 'S';
		this.verEditable = 'S';
		this.verAgregar = 'N';
		this.verLista = 'N';
		this.verAgregarAbono = false;
		this.verTablaCargosAbonos = false;
		this.verTablaFacturas = false;

	}


	updateComentario() {
		this.service.put(this.parametroServicio, this.objetoSeleccionado).subscribe(() => {
			window.location.reload();
		});
	}

	editarNombreUsuario()
	{
		this.verLista = 'N';
		this.verAgregar = 'S';
		this.verEditable = 'N';
		this.crearOrActualizar = 'A';
	}



}
