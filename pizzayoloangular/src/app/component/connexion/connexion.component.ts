import { Utilisateur } from './../../model/utilisateur';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Observable, map } from 'rxjs';
import { InscriptionService } from 'src/app/services/inscription.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { CustomValidator } from 'src/app/validation/custom-validator';

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

  FormInscription: FormGroup;

  constructor(
    private authservice: AuthService,
    private utilisateurService: UtilisateurService,
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.FormInscription = new FormGroup({
      mail: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.checkMail()
      ),
      prenom: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
      ]),
      nom: new FormControl('', [Validators.required, Validators.minLength(2)]),

      confirmPasswordGroup: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.minLength(8),
            //Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'),
          ]),
          confirmPassword: new FormControl('', [
            Validators.required,
            Validators.minLength(8),
            // Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'),
          ]),
        },
        CustomValidator.equals
      ),
    });
  }

  ngOnInit(): void {}

  connex(form: any) {
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

  insc() {
    let utilisateur = {
      mail: this.FormInscription.get('mail')?.value,
      prenom: this.FormInscription.get('prenom')?.value,
      nom: this.FormInscription.get('nom')?.value,
      password: this.FormInscription.get('confirmPasswordGroup.password')
        ?.value,
      id: undefined,
      adresse: undefined,
      type: undefined,
      historiqueCommande: undefined,
      employe: undefined,
    };

    this.utilisateurService.create(utilisateur).subscribe((data) => {
      this.router.navigate(['/acceuil']);
    });
  }

  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionService.checkMail(control.value).pipe(
        map((bool) => {
          return bool ? { mailExist: true } : null;
        })
      );
    };
  }
}
