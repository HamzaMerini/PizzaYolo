import { AuthenticatedGuardService } from './services/authenticated-guard.service';
import { CarteComponent } from './component/carte/carte.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { PanierComponent } from './component/panier/panier.component';
import { NousComponent } from './component/nous/nous.component';
import { Routes } from '@angular/router';
import { CompteComponent } from './component/compte/compte.component';
import { PlanningComponent } from './component/planning/planning.component';
import { CommandeComponent } from './component/commande/commande.component';
import { GestionPlanningComponent } from './component/gestion-planning/gestion-planning.component';
import { InscriptionComponent } from './component/inscription/inscription.component';

export const routes: Routes = [
  { path: '', redirectTo: 'acceuil', pathMatch: 'full' },
  { path: 'acceuil', component: AccueilComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'carte', component: CarteComponent },
  { path: 'nous', component: NousComponent },
  { path: 'panier', component: PanierComponent },
  { path: 'compte', component: CompteComponent },
  { path: 'planning', component: PlanningComponent },
  { path: 'gestionP', component: GestionPlanningComponent },
  { path: 'inscription', component: InscriptionComponent },
  {
    path: 'commande',
    component: CommandeComponent,
    canActivate: [AuthenticatedGuardService],
  },
];
