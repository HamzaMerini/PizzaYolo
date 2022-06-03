import { Commande } from './commande';
import { Recette } from './recette';

export class Pizza {
  public constructor(
    private _id?: number,
    private _recette?: Recette,
    private _commandePizza?: Commande,
    private _prix?: number,
    private _taille?: string,
    private _pate?: string
  ) {}
  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }
  get recette(): Recette | undefined {
    return this._recette;
  }

  set recette(value: Recette | undefined) {
    this._recette = value;
  }

  get commandePizza(): Commande | undefined {
    return this._commandePizza;
  }

  set commandePizza(value: Commande | undefined) {
    this._commandePizza = value;
  }

  get prix(): number | undefined {
    return this._prix;
  }

  set prix(value: number | undefined) {
    this._prix = value;
  }
  get taille(): string | undefined {
    return this._taille;
  }

  set taille(value: string | undefined) {
    this._taille = value;
  }
  get pate(): string | undefined {
    return this._pate;
  }

  set pate(value: string | undefined) {
    this._pate = value;
  }
}
