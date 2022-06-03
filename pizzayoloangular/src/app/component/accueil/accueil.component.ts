import { Utilisateur } from './../../model/utilisateur';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent implements OnInit {
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
    this.router.navigateByUrl('/home');
  }
}
