import { Observable } from 'rxjs';
import { Boisson } from './../model/boisson';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BoissonService {
  private url: string = 'http://localhost:8080/pizzayolo/api/boisson';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Boisson[]> {
    return this.httpClient.get<Boisson[]>(this.url);
  }

  public getById(id: number): Observable<Boisson> {
    return this.httpClient.get<Boisson>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(boisson: Boisson): Observable<Boisson> {
    return this.httpClient.put<Boisson>(
      `${this.url}/${boisson.id}`,
      this.boissonToJson(boisson)
    );
  }

  private boissonToJson(boisson: Boisson): any {
    let obj = {
      nom: boisson.nom,
      prix: boisson.prix,
    };

    if (boisson.id) {
      Object.assign(obj, { id: boisson.id });
    }
    return obj;
  }

  public create(boisson: Boisson): Observable<Boisson> {
    return this.httpClient.post<Boisson>(this.url, this.boissonToJson(boisson));
  }
}
