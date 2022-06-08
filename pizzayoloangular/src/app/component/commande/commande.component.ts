import { Router } from '@angular/router';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Utilisateur } from './../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { Commande } from 'src/app/model/commande';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css'],
})
export class CommandeComponent implements OnInit {
  monForm: FormGroup;
  utilisateur: Utilisateur = JSON.parse(
    sessionStorage.getItem('utilisateur')!
  ) as Utilisateur;
  typeCommande: String = '';

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {
    this.monForm = new FormGroup({
      adresse: new FormControl('', Validators.compose([Validators.required])),
    });
  }

  ngOnInit(): void {}
  public submit() {
    let utilisateur = {
      prenom: this.utilisateur.prenom,
      nom: this.utilisateur.nom,
      password: this.utilisateur.password,
      mail: this.utilisateur?.mail,
      id: this.utilisateur?.id,
      adresse: this.monForm.get('adresse')?.value,
      type: this.utilisateur.type,
      historiqueCommande: this.utilisateur.historiqueCommande,
      employe: this.utilisateur.employe,
    };

    this.utilisateurService.update(utilisateur).subscribe((data) => {});
    this.typeCommande = this.monForm.get('TypeCommande')?.value;
    console.log(this.typeCommande);
  }
}
