
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class PruebasService {

	URL_ARTISTA: string = "http://localhost:8001/api/artista";
	
	http = inject(HttpClient);

	httpOptions = {
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json',
			'Authorization': 'Bearer '
		})
	};

	getById(objetoId: any): Observable<any> {
		return this.http.get<any>(
			this.URL_ARTISTA + "/" + objetoId,
			this.httpOptions
		);
	}

	post(unObjeto: any): Observable<any> {
		return this.http.post(this.URL_ARTISTA, unObjeto, this.httpOptions);
	}

	put(unObjeto: any): Observable<any> {
		return this.http.put(this.URL_ARTISTA, unObjeto, this.httpOptions);
	}

	deleteById(objetoId: any): Observable<any> {
		return this.http.delete(
			this.URL_ARTISTA + "/" + objetoId,
			this.httpOptions
		);
	}

}
