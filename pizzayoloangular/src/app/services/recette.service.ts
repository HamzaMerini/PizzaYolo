import { Observable } from 'rxjs';
import { Recette } from './../model/recette';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RecetteService {
  private url: string = 'http://localhost:8080/pizzayolo/api/recette';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Recette[]> {
    return this.httpClient.get<Recette[]>(this.url);
  }
}
