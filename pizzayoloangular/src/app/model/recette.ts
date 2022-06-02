import { Ingredient } from './ingredient';
import { Pizza } from './pizza';

export class Recette {
  public constructor(
    private _nom?: string,
    private _litesIngre?: Ingredient[],
    private _pizzas?: Pizza[],
    private _prixM?: number,
    private _prixL?: number,
    private _prixXL?: number
  ) {}

  get nom(): string | undefined {
    return this._nom;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

  get litesIngre(): Array<Ingredient> | undefined {
    return this._litesIngre;
  }

  set litesIngre(value: Array<Ingredient> | undefined) {
    this._litesIngre = value;
  }

  get pizzas(): Array<Pizza> | undefined {
    return this._pizzas;
  }

  set pizzas(value: Array<Pizza> | undefined) {
    this._pizzas = value;
  }

  get prixM(): number | undefined {
    return this._prixM;
  }

  set prixM(value: number | undefined) {
    this._prixM = value;
  }

  get prixL(): number | undefined {
    return this._prixL;
  }

  set prixL(value: number | undefined) {
    this._prixL = value;
  }

  get prixXL(): number | undefined {
    return this._prixXL;
  }

  set prixXL(value: number | undefined) {
    this._prixXL = value;
  }
}
