import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Observable, map } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  [x: string]: any;
  url = 'http://localhost:8080/pizzayolo/api/utilisateur';

  constructor(private http: HttpClient) {}

  public inscription(utilisateur: any): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(this.url + '/inscription', utilisateur);
  }

  public checkMail(mail: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/mail/' + mail);
  }
}
