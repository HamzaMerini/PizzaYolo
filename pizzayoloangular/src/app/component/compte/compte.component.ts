import { Utilisateur } from './../../model/utilisateur';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { Router } from '@angular/router';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  AsyncValidatorFn,
  ValidationErrors,
} from '@angular/forms';
import { CustomValidator } from 'src/app/validation/custom-validator';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
})
export class CompteComponent implements OnInit {
  monForm: FormGroup;

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {
    this.monForm = new FormGroup({
      prenom: new FormControl(
        '',
        Validators.compose([Validators.required, Validators.minLength(2)])
      ),
      nom: new FormControl(
        '',
        Validators.compose([Validators.required, Validators.minLength(2)])
      ),
      adresse: new FormControl('', Validators.compose([Validators.required])),

      confirmPasswordGroup: new FormGroup(
        {
          password: new FormControl(
            '',
            Validators.compose([
              Validators.required,
              Validators.minLength(8),
              //Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'),
            ])
          ),
          confirmPassword: new FormControl(
            '',
            Validators.compose([
              Validators.required,
              Validators.minLength(8),
              // Validators.pattern('^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$'),
            ])
          ),
        },
        CustomValidator.equals
      ),
    });
  }

  ngOnInit(): void {}

  get utilisateur(): Utilisateur | null {
    if (sessionStorage.getItem('utilisateur')) {
      return JSON.parse(sessionStorage.getItem('utilisateur')!) as Utilisateur;
    }
    return null;
  }

  submit() {
    let utilisateur = {
      prenom: this.monForm.get('prenom')?.value,
      nom: this.monForm.get('nom')?.value,
      password: this.monForm.get('confirmPasswordGroup.password')?.value,
      mail: this.utilisateur?.mail,
      id: this.utilisateur?.id,
      adresse: this.monForm.get('adresse')?.value,
      type: undefined,
      historiqueCommande: undefined,
      employe: undefined,
    };

    this.utilisateurService.update(utilisateur).subscribe((data) => {
      this.router.navigate(['/acceuil']);
    });
  }
}
