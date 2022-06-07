import { Utilisateur } from './../../model/utilisateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css'],
})
export class CommandeComponent implements OnInit {
  utilisateur: Utilisateur = JSON.parse(
    sessionStorage.getItem('utilisateur')!
  ) as Utilisateur;

  constructor() {}

  ngOnInit(): void {}
}
