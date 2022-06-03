import { Adresse } from './adresse';
import { Employe } from './employe';
import { Commande } from './commande';

export class Utilisateur {
  public constructor(
    private _id?: number,
    private _mail?: string,
    private _prenom?: string,
    private _nom?: string,
    private _password?: string,
    private _adresse?: Adresse,
    private _type?: string,
    private _historiqueCommande?: Commande,
    private _employe?: Employe
  ) {}

  get id(): number | undefined {
    return this._id;
  }

  set id(value: number | undefined) {
    this._id = value;
  }
  get mail(): string | undefined {
    return this._mail;
  }

  set password(value: string | undefined) {
    this._password = value;
  }
  get password(): string | undefined {
    return this._password;
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

  get adresse(): Adresse | undefined {
    return this._adresse;
  }

  set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  get type(): string | undefined {
    return this._type;
  }

  set type(value: string | undefined) {
    this._type = value;
  }

  get historiqueCommande(): Commande | undefined {
    return this._historiqueCommande;
  }

  set historiqueCommande(value: Commande | undefined) {
    this._historiqueCommande = value;
  }

  get employe(): Employe | undefined {
    return this._employe;
  }

  set employe(value: Employe | undefined) {
    this._employe = value;
  }
}
