import { Time } from '@angular/common';
import { Employe } from './employe';

export class Creneau {
  public constructor(
    private _date?: string,
    private _debut?: Time,
    private _fin?: Time,
    private _listeEmploye?: Employe[],
    private _employe?: string
  ) {}

  get date(): string | undefined {
    return this._date;
  }

  set date(value: string | undefined) {
    this._date = value;
  }

  get debut(): Time | undefined {
    return this._debut;
  }

  set debut(value: Time | undefined) {
    this._debut = value;
  }

  get fin(): Time | undefined {
    return this._fin;
  }

  set fin(value: Time | undefined) {
    this._fin = value;
  }

  get listeEmploye(): Array<Employe> | undefined {
    return this._listeEmploye;
  }

  set listeEmploye(value: Array<Employe> | undefined) {
    this._listeEmploye = value;
  }

  get employe(): string | undefined {
    return this._employe;
  }

  set employe(value: string | undefined) {
    this._employe = value;
  }
}
