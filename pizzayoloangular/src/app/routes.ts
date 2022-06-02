import { ConnexionComponent } from './component/connexion/connexion.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'acceuil', component: AccueilComponent },
  { path: '', redirectTo: 'acceuil', pathMatch: 'full' },
  { path: 'connexion', component: ConnexionComponent },
];
