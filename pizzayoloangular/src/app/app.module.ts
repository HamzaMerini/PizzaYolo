import { HttpClientModule } from '@angular/common/http';
import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { CarteComponent } from './component/carte/carte.component';
import { NousComponent } from './component/nous/nous.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { PanierComponent } from './component/panier/panier.component';
import { CompteComponent } from './component/compte/compte.component';
import { PlanningComponent } from './component/planning/planning.component';
import { GestionPlanningComponent } from './component/gestion-planning/gestion-planning.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { CommandeComponent } from './component/commande/commande.component';

import { NgwWowModule } from 'ngx-wow';
import { ScrollDirective } from './directive/scroll.directive';
import { FooterComponent } from './component/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    CarteComponent,
    NousComponent,
    ConnexionComponent,
    PanierComponent,
    CompteComponent,
    PlanningComponent,
    GestionPlanningComponent,
    InscriptionComponent,
    CommandeComponent,
    ScrollDirective,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    NgwWowModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
