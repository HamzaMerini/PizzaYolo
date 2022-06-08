import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  AsyncValidatorFn,
  ValidationErrors,
} from '@angular/forms';
import { Observable, map } from 'rxjs';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { InscriptionService } from 'src/app/services/inscription.service';
import { CustomValidator } from 'src/app/validation/custom-validator';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  monForm: FormGroup;

  constructor(
    private utilisateurService: UtilisateurService,
    private inscriptionService: InscriptionService,
    private router: Router
  ) {
    this.monForm = new FormGroup({
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
            Validators.pattern(
              '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{7,}'
            ),
          ]),
          confirmPassword: new FormControl('', [
            Validators.required,
            Validators.pattern(
              '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{7,}'
            ),
          ]),
        },
        CustomValidator.equals
      ),
    });
  }

  ngOnInit(): void {}

  submit() {
    let utilisateur = {
      mail: this.monForm.get('mail')?.value,
      prenom: this.monForm.get('prenom')?.value,
      nom: this.monForm.get('nom')?.value,
      password: this.monForm.get('confirmPasswordGroup.password')?.value,
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
