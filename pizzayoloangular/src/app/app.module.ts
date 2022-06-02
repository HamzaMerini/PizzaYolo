import { HttpClientModule } from '@angular/common/http';
import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { CarteComponent } from './component/carte/carte.component';
import { NousComponent } from './component/nous/nous.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ConnexionComponent } from './component/connexion/connexion.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    CarteComponent,
    NousComponent,
    ConnexionComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
