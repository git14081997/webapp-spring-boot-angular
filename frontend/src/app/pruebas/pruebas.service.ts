
import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { ParametroServicio } from './ParametroServicio';

@Injectable({
	providedIn: 'root'
})
export class PruebasService {
	
	private http = inject(HttpClient);

	getById(parametro:ParametroServicio,id: number): Observable<any> {
		return this.http.get<any>(parametro.url + "/" + id, parametro.headers);
	}

	getPaginado(parametro:ParametroServicio, pagina: number, cantidad: number): Observable<any> {
		return this.http.get<any>(parametro.url + "/" + pagina + "/" + cantidad, parametro.headers);
	}

	post(parametro:ParametroServicio, unObjeto: any): Observable<any> {
		return this.http.post(parametro.url, unObjeto, parametro.headers);
	}

	put(parametro:ParametroServicio, unObjeto: any): Observable<any> {
		return this.http.put(parametro.url, unObjeto, parametro.headers);
	}

	deleteById(parametro:ParametroServicio, id: number): Observable<any> {
		return this.http.delete(parametro.url + "/" + id,parametro.headers);
	}

	getPaginadoBuscando(
		parametro:ParametroServicio, pagina: number, cantidad: number,
		nombre: string, apellido: string): Observable<any> {
		return this.http.get<any>(
			parametro.url + "/" + pagina + "/" + cantidad +
			"/buscar" + "?nombre="+nombre + "&apellido="+apellido,
			parametro.headers);
	}

}
