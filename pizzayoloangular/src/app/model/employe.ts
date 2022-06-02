import { Creneau } from './creneau';
import { Utilisateur } from './utilisateur';
import { Adresse } from './adresse';

export class Employe {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _prenom?: string,
    private _adresse?: Adresse,
    private _dateEmbauche?: Date,
    private _salaire?: number,
    private _job?: string,
    private _utilisateur?: Utilisateur,
    private _creneau?: Creneau
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

  get prenom(): string | undefined {
    return this._prenom;
  }

  set prenom(value: string | undefined) {
    this._prenom = value;
  }

  get adresse(): Adresse | undefined {
    return this._adresse;
  }

  set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  get dateEmbauche(): Date | undefined {
    return this._dateEmbauche;
  }

  set dateEmbauche(value: Date | undefined) {
    this._dateEmbauche = value;
  }

  get salaire(): number | undefined {
    return this._salaire;
  }

  set salaire(value: number | undefined) {
    this._salaire = value;
  }

  get job(): string | undefined {
    return this._job;
  }

  set job(value: string | undefined) {
    this._job = value;
  }

  get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }

  set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }

  get creneau(): Creneau | undefined {
    return this._creneau;
  }

  set creneau(value: Creneau | undefined) {
    this._creneau = value;
  }
}
