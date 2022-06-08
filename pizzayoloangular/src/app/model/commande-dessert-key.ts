import { Commande } from 'src/app/model/commande';
import { Dessert } from './dessert';
export class CommandeDessertKey {
  public constructor(
    private _dessert?: Dessert,
    private _commandeDessert?: Commande
  ) {}

  get dessert(): Dessert | undefined {
    return this._dessert;
  }

  set dessert(value: Dessert | undefined) {
    this._dessert = value;
  }

  get commandeDessert(): Commande | undefined {
    return this._commandeDessert;
  }

  set commandeDessert(value: Commande | undefined) {
    this._commandeDessert = value;
  }
}
