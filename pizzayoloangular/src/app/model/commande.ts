import { Utilisateur } from './utilisateur';
import { Boisson } from './boisson';
import { Dessert } from './dessert';
import { Pizza } from './pizza';

export class Commande {
  public constructor(
    private _numTicket?: number,

    private _boissons?: Boisson[],
    private _desserts?: Dessert[],
    private _pizzas?: Pizza[],
    private _clientTicket?: Utilisateur,
    private _prixTotal?: number,
    private _typeCommande?: String,
    private _heureSouhaite?: String,
    private _place?: String
  ) {}

  get numTicket(): number | undefined {
    return this._numTicket;
  }

  set numTicket(value: number | undefined) {
    this._numTicket = value;
  }

  get boissons(): Array<Boisson> | undefined {
    return this._boissons;
  }

  set boissons(value: Array<Boisson> | undefined) {
    this._boissons = value;
  }

  get desserts(): Array<Dessert> | undefined {
    return this._desserts;
  }

  set desserts(value: Array<Dessert> | undefined) {
    this._desserts = value;
  }

  get pizzas(): Array<Pizza> | undefined {
    return this._pizzas;
  }

  set pizzas(value: Array<Pizza> | undefined) {
    this._pizzas = value;
  }

  get clientTicket(): Utilisateur | undefined {
    return this._clientTicket;
  }

  set clientTicket(value: Utilisateur | undefined) {
    this._clientTicket = value;
  }

  get prixTotal(): number | undefined {
    return this._prixTotal;
  }

  set prixTotal(value: number | undefined) {
    this._prixTotal = value;
  }

  get heureSouhaite(): String | undefined {
    return this._heureSouhaite;
  }

  set heureSouhaite(value: String | undefined) {
    this._heureSouhaite = value;
  }

  get place(): String | undefined {
    return this._place;
  }

  set place(value: String | undefined) {
    this._place = value;
  }

  get typeCommande(): String | undefined {
    return this._typeCommande;
  }

  set typeCommande(value: String | undefined) {
    this._typeCommande = value;
  }
}
