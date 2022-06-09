import { Commande } from 'src/app/model/commande';
import { Boisson } from './boisson';
export class CommandeBoissonKey {
  public constructor(
    private _boisson?: Boisson,
    private _commandeBoisson?: Commande
  ) {}

  get boisson(): Boisson | undefined {
    return this._boisson;
  }

  set boisson(value: Boisson | undefined) {
    this._boisson = value;
  }

  get commandeBoisson(): Commande | undefined {
    return this._commandeBoisson;
  }

  set commandeBoisson(value: Commande | undefined) {
    this._commandeBoisson = value;
  }
}
