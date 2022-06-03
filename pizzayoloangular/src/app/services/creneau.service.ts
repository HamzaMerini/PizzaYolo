import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Creneau } from '../model/creneau';

@Injectable({
  providedIn: 'root',
})
export class CreneauService {
  private url: string = 'http://localhost:8080/pizzayolo/api/creneau';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Creneau[]> {
    return this.httpClient.get<Creneau[]>(this.url);
  }

  public getById(id: number): Observable<Creneau> {
    return this.httpClient.get<Creneau>(`${this.url}/${id}`);
  }

  public create(creneau: Creneau): Observable<Creneau> {
    return this.httpClient.post<Creneau>(this.url, this.creneauToJson(creneau));
  }

  public update(creneau: Creneau): Observable<Creneau> {
    return this.httpClient.put<Creneau>(
      `${this.url}/${creneau.id}`,
      this.creneauToJson(creneau)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  private creneauToJson(creneau: Creneau): any {
    let obj = {
      date: creneau.date,
      debut: creneau.debut,
      fin: creneau.fin,
      listeEmploye: creneau.listeEmploye,
      employe: creneau.employe,
    };

    if (creneau.id) {
      Object.assign(obj, { id: creneau.id });
    }
    return obj;
  }
}
