import { Commande } from 'src/app/model/commande';
import { Dessert } from 'src/app/model/dessert';
export class Commandedessert {
  public constructor(
    private _quantité?: number,
    private _dessert?: Dessert,
    private _commande?: Commande
  ) {}

  get quantité(): number | undefined {
    return this._quantité;
  }
  set quantité(value: number | undefined) {
    this._quantité = value;
  }

  get dessert(): Dessert | undefined {
    return this._dessert;
  }

  set dessert(value: Dessert | undefined) {
    this._dessert = value;
  }

  get commande(): Commande | undefined {
    return this._commande;
  }

  set commande(value: Commande | undefined) {
    this._commande = value;
  }
}
