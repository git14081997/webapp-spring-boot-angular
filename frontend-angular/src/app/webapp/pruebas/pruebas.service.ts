
import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { ParametroServicio } from '../ParametroServicio';
import { hostname } from '../hostname';

@Injectable({
	providedIn: 'root'
})
export class PruebasService {
	
	private http = inject(HttpClient);

	getById(parametro:ParametroServicio,id: number): Observable<any> {
		return this.http.get<any>( hostname + parametro.url + "/" + id, parametro.headers);
	}

	getAll(parametro:ParametroServicio): Observable<any> {
		return this.http.get<any>( hostname + parametro.url, parametro.headers);
	}

	getPaginado(parametro:ParametroServicio, pagina: number, cantidad: number): Observable<any> {
		return this.http.get<any>( hostname + parametro.url + "/" + pagina + "/" + cantidad, parametro.headers);
	}

	post(parametro:ParametroServicio, unObjeto: any): Observable<any> {
		return this.http.post( hostname + parametro.url, unObjeto, parametro.headers);
	}

	put(parametro:ParametroServicio, unObjeto: any): Observable<any> {
		return this.http.put( hostname + parametro.url, unObjeto, parametro.headers);
	}

	deleteById(parametro:ParametroServicio, id: number): Observable<any> {
		return this.http.delete( hostname + parametro.url + "/" + id,parametro.headers);
	}

}
