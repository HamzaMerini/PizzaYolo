export class Commandedessert {
  public constructor(private _quantité?: number) {}
  get quantité(): number | undefined {
    return this._quantité;
  }
  set nom(value: number | undefined) {
    this._quantité = value;
  }
}
