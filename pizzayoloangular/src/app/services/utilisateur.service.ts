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

  public create(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post<Utilisateur>(
      this.url,
      this.utilisateurToJson(utilisateur)
    );
  }

  public update(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(
      `${this.url}/${utilisateur.id}`,
      this.utilisateurToJson(utilisateur)
    );
  }

  public delete(id: number): Observable<void> {
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
      adresse: utilisateur.adresse,
      type: utilisateur.type,
      historiqueCommande: utilisateur.historiqueCommande,
      employe: utilisateur.employe,
    };

    if (utilisateur.id) {
      Object.assign(obj, { id: utilisateur.id });
    }
    return obj;
  }
}
