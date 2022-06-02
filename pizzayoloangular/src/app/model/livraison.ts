import { Commande } from './commande';

export class Livraison extends Commande {
  public constructor(private _heureSouhaite?: string) {
    super();
  }
  get heureSouhaite(): string | undefined {
    return this._heureSouhaite;
  }

  set heureSouhaite(value: string | undefined) {
    this._heureSouhaite = value;
  }
}
