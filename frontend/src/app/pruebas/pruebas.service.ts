
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class PruebasService {

	url: string = "http://localhost:8001/api/artista";

	/*
	http: HttpClient;

	httpOptions = {
		headers: new HttpHeaders({
			'Content-Type': 'application/json',
			'Accept': 'application/json'
		})
	};

	constructor() {
		this.http = new HttpClient();
	}

	getById(objetoId: any): Observable<any> {
		return this.http.get<any>(this.endpoint);
	}

	post(unObjeto: any): Observable<any> {
		return this.http.post(this.endpoint, unObjeto, this.httpOptions)
			.pipe(
				catchError(this.handleError<any>('updateHero'))
			);
	}

	put(unObjeto: any): Observable<any> {
		return this.http.put(this.endpoint, unObjeto, this.httpOptions);
	}

	delete(objetoId: any): void {
		this.http.put(this.endpoint, objetoId, this.httpOptions);
	}

	private handleError<T>(operation = 'operation', result?: T) {
		return (error: any): Observable<T> => {
			console.error(error);
			return of(result as T);
		};
	}
	*/

	async getArtistaById(id: number): Promise<any | undefined> {
    const data = await fetch(this.url + "/" + id);
    return (await data.json()) ?? {};
  }

}
