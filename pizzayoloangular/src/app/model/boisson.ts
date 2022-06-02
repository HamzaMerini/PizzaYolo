export class Boisson {
  public constructor(private _id?: number, private _nom?: string, private _prix?: number) {}

  get id(): number | undefined {
    return this._id;
  }

  get nom(): string | undefined {
    return this._nom;
  }

  get prix(): number | undefined {
    return this._prix;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

  set prix(value: number | undefined) {
    this._prix = value;
  }
}
