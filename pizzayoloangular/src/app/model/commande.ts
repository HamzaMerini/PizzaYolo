import { Utilisateur } from './utilisateur';
import { Boisson } from './boisson';
import { Dessert } from './dessert';
import { Pizza } from './pizza';

export abstract class Commande {
  public constructor(
    private _numTicket?: number,
    private _boissons?: Boisson[],
    private _desserts?: Dessert[],
    private _pizzas?: Pizza[],
    private _clientTicket?: Utilisateur,
    private _dateTicket?: Date,
    private _prixTotal?: number
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

  get dateTicket(): Date | undefined {
    return this._dateTicket;
  }

  set dateTicket(value: Date | undefined) {
    this._dateTicket = value;
  }

  get prixTotal(): number | undefined {
    return this._prixTotal;
  }

  set prixTotal(value: number | undefined) {
    this._prixTotal = value;
  }
}
