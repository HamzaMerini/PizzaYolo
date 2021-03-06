export class Boisson {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _prix?: number,
    private _quantite?: number
  ) {}

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  get nom(): string | undefined {
    return this._nom;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

  get prix(): number | undefined {
    return this._prix;
  }

  set prix(value: number | undefined) {
    this._prix = value;
  }
  get quantite(): number | undefined {
    return this._quantite;
  }

  set quantite(value: number | undefined) {
    this._quantite = value;
  }
}
