import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employe } from '../model/employe';

@Injectable({
  providedIn: 'root',
})
export class EmployeService {
  private url: string = 'http://localhost:8080/pizzayolo/api/employe';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Employe[]> {
    return this.httpClient.get<Employe[]>(this.url);
  }

  public getById(id: number): Observable<Employe> {
    return this.httpClient.get<Employe>(`${this.url}/${id}`);
  }

  public create(employe: Employe): Observable<Employe> {
    return this.httpClient.post<Employe>(this.url, this.employeToJson(employe));
  }

  public update(employe: Employe): Observable<Employe> {
    return this.httpClient.put<Employe>(
      `${this.url}/${employe.id}`,
      this.employeToJson(employe)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  private employeToJson(employe: Employe): any {
    let obj = {
      id: employe.id,
      nom: employe.nom,
      prenom: employe.prenom,
      adresse: employe.adresse,
      dateEmbauche: employe.dateEmbauche,
      job: employe.job,
    };

    if (employe.id) {
      Object.assign(obj, { id: employe.id });
    }
    return obj;
  }
}
