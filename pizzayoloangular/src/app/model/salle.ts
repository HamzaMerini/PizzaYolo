import { Commande } from './commande';

export class Salle extends Commande {
  public constructor(private _place?: string) {
    super();
  }

  get place(): string | undefined {
    return this._place;
  }

  set place(value: string | undefined) {
    this._place = value;
  }
}
