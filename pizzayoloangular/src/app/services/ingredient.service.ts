import { Observable } from 'rxjs';
import { Ingredient } from './../model/ingredient';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class IngredientService {
  private url: string = 'http://localhost:8080/pizzayolo/api/ingredient';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Ingredient[]> {
    return this.httpClient.get<Ingredient[]>(this.url);
  }

  public getById(id: number): Observable<Ingredient> {
    return this.httpClient.get<Ingredient>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(ingredient: Ingredient): Observable<Ingredient> {
    return this.httpClient.put<Ingredient>(
      `${this.url}/${ingredient.id}`,
      this.ingredientToJson(ingredient)
    );
  }

  private ingredientToJson(ingredient: Ingredient): any {
    let obj = {
      libelle: ingredient.libelle,
      prixSupM: ingredient.prixSupM,
      prixSupL: ingredient.prixSupL,
      prixSupXL: ingredient.prixSupXL,
      recettes: ingredient.recettes,
      typeIngredient: ingredient.typeIngredient,
    };

    if (ingredient.id) {
      Object.assign(obj, { id: ingredient.id });
    }
    return obj;
  }

  public create(ingredient: Ingredient): Observable<Ingredient> {
    return this.httpClient.post<Ingredient>(
      this.url,
      this.ingredientToJson(ingredient)
    );
  }
}
