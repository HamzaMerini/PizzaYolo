import { Utilisateur } from './../model/utilisateur';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public auth(mail: string, password: string): Observable<Utilisateur> {
    let monHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${mail}:${password}`),
    });
    return this.httpClient.get<Utilisateur>(
      'http://localhost:8080/pizzayolo/api/auth',
      {
        headers: monHeaders,
      }
    );
  }

  public get authenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  constructor(private httpClient: HttpClient) {}
}
