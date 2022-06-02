export class Dessert {
  public constructor(private _nom?: string, private _prix?: number) {}

  get nom(): string | undefined {
    return this._nom;
  }

  get prix(): number | undefined {
    return this._prix;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

  set prix(value: number | undefined) {
    this._prix = value;
  }
}
