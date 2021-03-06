import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Commande } from '../model/commande';

@Injectable({
  providedIn: 'root',
})
export class CommandeService {
  private url: string = 'http://localhost:8080/pizzayolo/api/commande';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Commande[]> {
    return this.httpClient.get<Commande[]>(this.url + '/all');
  }
  public getById(id: number): Observable<Commande> {
    return this.httpClient.get<Commande>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(commande: Commande): Observable<Commande> {
    return this.httpClient.put<Commande>(
      `${this.url}/${commande.numTicket}`,
      this.commandeToJson(commande)
    );
  }

  private commandeToJson(commande: Commande): any {
    let obj = {
      //On risque d'avoir besoin du typeCommande attention !
      boissons: commande.boissons,
      desserts: commande.desserts,
      pizzas: commande.pizzas,
      typeCommande: commande.typeCommande,
      prixTotal: commande.prixTotal,
      heureSouhaite: commande.heureSouhaite,
      place: commande.place,
      clientTicket: commande.clientTicket,
    };

    if (commande.numTicket) {
      Object.assign(obj, { id: commande.numTicket });
    }
    return obj;
  }

  public create(commande: Commande): Observable<Commande> {
    console.log(this.commandeToJson(commande), 'commande to json');
    return this.httpClient.post<Commande>(
      `${this.url}/create`,
      this.commandeToJson(commande)
    );
  }
}
