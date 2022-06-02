export class Utilisateur {
  public constructor(
    private _mail?: string,
    private _prenom?: string,
    private _nom?: string,
    private _type?: string
  ) {}

  get mail(): string | undefined {
    return this._mail;
  }

  set mail(value: string | undefined) {
    this._mail = value;
  }

  get prenom(): string | undefined {
    return this._prenom;
  }

  set prenom(value: string | undefined) {
    this._prenom = value;
  }

  get nom(): string | undefined {
    return this._nom;
  }

  set nom(value: string | undefined) {
    this._nom = value;
  }

  get type(): string | undefined {
    return this._type;
  }

  set type(value: string | undefined) {
    this._type = value;
  }
}
