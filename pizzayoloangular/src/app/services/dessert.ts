import { Observable } from 'rxjs';
import { Dessert } from './../model/dessert';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DessertService {
  private url: string = 'http://localhost:8080/pizzayolo/api/dessert';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Dessert[]> {
    return this.httpClient.get<Dessert[]>(this.url);
  }
  public getById(id: number): Observable<Dessert> {
    return this.httpClient.get<Dessert>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(dessert: Dessert): Observable<Dessert> {
    return this.httpClient.put<Dessert>(
      `${this.url}/${dessert.id}`,
      this.dessertToJson(dessert)
    );
  }

  private dessertToJson(dessert: Dessert): any {
    let obj = {
      nom: dessert.nom,
      prix: dessert.prix,
    };

    if (dessert.id) {
      Object.assign(obj, { id: dessert.id });
    }
    return obj;
  }

  public create(dessert: Dessert): Observable<Dessert> {
    return this.httpClient.post<Dessert>(this.url, this.dessertToJson(dessert));
  }
}
