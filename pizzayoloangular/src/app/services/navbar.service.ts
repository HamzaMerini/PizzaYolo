import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class NavbarService {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get logged() {
    return sessionStorage.getItem('token');
  }

  get utilisateur(): Utilisateur | null {
    if (sessionStorage.getItem('utilisateur')) {
      return JSON.parse(sessionStorage.getItem('utilisateur')!) as Utilisateur;
    }
    return null;
  }

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/acceuil');
  }
}
