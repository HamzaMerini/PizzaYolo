import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from 'src/app/model/utilisateur';
import { NavbarService } from 'src/app/services/navbar.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-edit-compte',
  templateUrl: './edit-compte.component.html',
  styleUrls: ['./edit-compte.component.css'],
})
export class EditCompteComponent implements OnInit {
  utilisateur: Utilisateur = JSON.parse(
    sessionStorage.getItem('utilisateur')!
  ) as Utilisateur;

  constructor(
    private utilisateurService: UtilisateurService,
    private navbarService: NavbarService,
    private router: Router
  ) {}

  ngOnInit(): void {}
}
