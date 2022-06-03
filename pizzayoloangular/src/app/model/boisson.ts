export class Boisson {
<<<<<<< Updated upstream
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _prix?: number
  ) {}
=======
  public constructor(private _id?: number, private _nom?: string, private _prix?: number) {}
>>>>>>> Stashed changes

  get id(): number | undefined {
    return this._id;
  }

<<<<<<< Updated upstream
  set id(value: number | undefined) {
    this._id = value;
  }

=======
>>>>>>> Stashed changes
  get nom(): string | undefined {
    return this._nom;
  }

<<<<<<< Updated upstream
  set nom(value: string | undefined) {
    this._nom = value;
  }

=======
>>>>>>> Stashed changes
  get prix(): number | undefined {
    return this._prix;
  }

<<<<<<< Updated upstream
=======
  set id(value: number | undefined) {
    this._id = value;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

>>>>>>> Stashed changes
  set prix(value: number | undefined) {
    this._prix = value;
  }
}
