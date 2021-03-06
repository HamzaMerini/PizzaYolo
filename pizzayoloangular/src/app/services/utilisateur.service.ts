import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private url: string = 'http://localhost:8080/pizzayolo/api/utilisateur';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(this.url);
  }

  public getById(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.url}/${id}`);
  }

  public getByMail(mail: string): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.url}/${mail}`);
  }

  public create(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post<Utilisateur>(
      this.url,
      this.utilisateurToJson(utilisateur)
    );
  }

  public update(utilisateur: Utilisateur): Observable<Utilisateur> {
    console.log('service', utilisateur);
    return this.httpClient.patch<Utilisateur>(
      `${this.url}/${utilisateur.id}`,
      this.utilisateurToJson(utilisateur)
    );
  }

  public delete(id: number | undefined): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getByIdWithAdresse(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.url}/${id}/adresse`);
  }

  private utilisateurToJson(utilisateur: Utilisateur): any {
    let obj = {
      mail: utilisateur.mail,
      prenom: utilisateur.prenom,
      nom: utilisateur.nom,
      password: utilisateur.password,
      adresse: {
        numVoie: utilisateur.adresse?.numVoie,
        nomVoie: utilisateur.adresse?.nomVoie,
        cp: utilisateur.adresse?.cp,
        ville: utilisateur.adresse?.ville,
      },
      type: utilisateur.type,
      historiqueCommande: undefined,
      employe: undefined,
    };

    // if (utilisateur.id) {
    //   Object.assign(obj, { id: utilisateur.id });
    // }
    return obj;
  }
}
