import { Utilisateur } from './../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
})
export class CompteComponent implements OnInit {
  user: Observable<Utilisateur>;
  constructor(private utilisateurService: UtilisateurService) {
    this.user = this.utilisateurService.getByMail('u1@u1'); // A MODIFIER
  }

  ngOnInit(): void {}
}
