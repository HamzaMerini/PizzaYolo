export class Adresse {
  public constructor(
    private _numVoie?: string,
    private _nomVoie?: string,
    private _cp?: string,
    private _ville?: string
  ) {}

  get numVoie(): string | undefined {
    return this._numVoie;
  }

  set numVoie(value: string | undefined) {
    this._numVoie = value;
  }

  get nomVoie(): string | undefined {
    return this._nomVoie;
  }

  set nomVoie(value: string | undefined) {
    this._nomVoie = value;
  }

  get cp(): string | undefined {
    return this._cp;
  }

  set cp(value: string | undefined) {
    this._cp = value;
  }

  get ville(): string | undefined {
    return this._ville;
  }

  set ville(value: string | undefined) {
    this._ville = value;
  }
}
