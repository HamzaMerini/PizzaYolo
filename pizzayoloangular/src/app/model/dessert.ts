export class Dessert {
  public constructor(
    private _nom?: string,
    private _prix?: number,
    private _id?: number
  ) {}

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
  get id(): number | undefined {
    return this._prix;
  }

  set id(value: number | undefined) {
    this._prix = value;
  }
}
