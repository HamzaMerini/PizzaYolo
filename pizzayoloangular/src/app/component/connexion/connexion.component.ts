import { Utilisateur } from './../../model/utilisateur';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  mail = '';
  password = '';
  showError = false;
  message = '';
  constructor(private authservice: AuthService, private router: Router) {}

  ngOnInit(): void {}

  submit(form: any) {
    this.authservice.auth(this.mail, this.password).subscribe({
      next: (utilisateur: Utilisateur) => {
        this.showError = false;
        sessionStorage.setItem('token', btoa(`${this.mail}:${this.password}`));
        sessionStorage.setItem('utilisateur', JSON.stringify(utilisateur));
        this.router.navigateByUrl('/acceuil');
      },
      error: (error: any) => {
        console.log(error);
        this.message = "Erreur d'autentification";
        this.showError = true;
      },
    });
  }
}
