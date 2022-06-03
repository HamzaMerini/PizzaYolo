import { Observable } from 'rxjs';
import { Pizza } from './../model/pizza';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PizzaService {
  private url: string = 'http://localhost:8080/pizzayolo/api/pizza';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Pizza[]> {
    return this.httpClient.get<Pizza[]>(this.url);
  }
  public getById(id: number): Observable<Pizza> {
    return this.httpClient.get<Pizza>(`${this.url}/${id}`);
  }

  // public delete(id: number): Observable<void> {   // pas de fonction supremier dans le rest controler de pizza
  //   return this.httpClient.delete<void>(`${this.url}/${id}`);
  // }

  public update(pizza: Pizza): Observable<Pizza> {
    return this.httpClient.put<Pizza>(
      `${this.url}/${pizza.id}`,
      this.pizzaToJson(pizza)
    );
  }

  private pizzaToJson(pizza: Pizza): any {
    let obj = {
      recette: pizza.recette,
      commandePizza: pizza.commandePizza,
      prix: pizza.prix,
      taille: pizza.taille,
      pate: pizza.pate,
    };

    if (pizza.id) {
      Object.assign(obj, { id: pizza.id });
    }
    return obj;
  }

  public create(pizza: Pizza): Observable<Pizza> {
    return this.httpClient.post<Pizza>(this.url, this.pizzaToJson(pizza));
  }
}
