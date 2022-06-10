import { CommandeService } from './../../services/commande.service';
import { Adresse } from './../../model/adresse';
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
import { NavbarService } from 'src/app/services/navbar.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
})
export class CompteComponent implements OnInit {
  monForm: FormGroup;

  utilisateur: Utilisateur = JSON.parse(
    sessionStorage.getItem('utilisateur')!
  ) as Utilisateur;

  constructor(
    private utilisateurService: UtilisateurService,
    private navbarService: NavbarService,
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
              Validators.pattern(
                '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{7,}'
              ),
            ])
          ),
          confirmPassword: new FormControl(
            '',
            Validators.compose([
              Validators.required,
              Validators.pattern(
                '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{7,}'
              ),
            ])
          ),
        },
        CustomValidator.equals
      ),
    });
  }

  ngOnInit(): void {
    console.log('user', this.utilisateur);
  }

  submit() {
    let utilisateur = {
      prenom: this.monForm.get('prenom')?.value,
      nom: this.monForm.get('nom')?.value,
      password: this.utilisateur!.password, //this.monForm.get('confirmPasswordGroup.password')?.value,
      mail: this.utilisateur?.mail,
      id: this.utilisateur?.id,
      adresse: {
        ville: this.monForm.get('ville')?.value,
        numVoie: this.monForm.get('numVoie')?.value,
        nomVoie: this.monForm.get('nomVoie')?.value,
        cp: this.monForm.get('cp')?.value,
      },
      type: undefined,
      historiqueCommande: undefined,
      employe: undefined,
    };

    this.utilisateurService.update(utilisateur).subscribe((data) => {
      this.router.navigate(['/acceuil']);
    });
  }

  save() {
    console.log('update', this.utilisateur?.id);
    this.utilisateurService.update(this.utilisateur!).subscribe(() => {
      this.navbarService.logout();
      this.router.navigate(['/acceuil']);
    });
  }

  delete(id: number) {
    console.log('delete', id);

    this.utilisateurService.delete(id).subscribe(() => {
      this.navbarService.logout();
      this.router.navigate(['/acceuil']);
    });
  }
}
