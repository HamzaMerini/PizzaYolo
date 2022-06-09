import { Utilisateur } from 'src/app/model/utilisateur';
import { CommandeService } from './../../services/commande.service';
import { Commande } from 'src/app/model/commande';
import { Pizza } from './../../model/pizza';
import { Boisson } from './../../model/boisson';
import { Dessert } from './../../model/dessert';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css'],
})
export class CommandeComponent implements OnInit {
  utilisateur: Utilisateur = JSON.parse(
    sessionStorage.getItem('utilisateur')!
  ) as Utilisateur;
  typeCommande: String = '';
  desserts: Array<Dessert> = [];
  boissons: Array<Boisson> = [];
  pizzas: Array<Pizza> = [];
  showMessageDessert: boolean = false;
  showMessageBoisson: boolean = false;
  showMessagePizza: boolean = false;
  prixtotalpanier: number = 0;
  prixLivraison: number = 0;
  reductionEmploye: number = 0;
  prixTotal: number = 0;
  heureSouhaite: string = '';
  place: string = '';

  constructor(
    private router: Router,
    private commandeService: CommandeService
  ) {}
  public afficherDessertsPanier() {
    if (sessionStorage.getItem('dessertsPanier')) {
      this.desserts = JSON.parse(sessionStorage.getItem('dessertsPanier')!);
      this.showMessageDessert = false;
    } else {
      this.showMessageDessert = true;
    }
  }

  public afficherBoissonsPanier() {
    if (sessionStorage.getItem('boissonsPanier')) {
      this.boissons = JSON.parse(sessionStorage.getItem('boissonsPanier')!);
      this.showMessageBoisson = false;
    } else {
      this.showMessageBoisson = true;
    }
  }

  public afficherPizzasPanier() {
    if (sessionStorage.getItem('pizzasPanier')) {
      this.pizzas = JSON.parse(sessionStorage.getItem('pizzasPanier')!);
      this.showMessagePizza = false;
    } else {
      this.showMessagePizza = true;
    }
  }

  public calculTotalPrixCommande() {
    this.prixtotalpanier = 0;
    this.pizzas.forEach((pizza) => {
      this.prixtotalpanier = this.prixtotalpanier + pizza.prix!;
    });
    this.boissons.forEach((boisson) => {
      this.prixtotalpanier =
        this.prixtotalpanier + boisson.prix! * boisson.quantite!;
    });
    this.desserts.forEach((dessert) => {
      this.prixtotalpanier =
        this.prixtotalpanier + dessert.prix! * dessert.quantite!;
    });
    this.prixtotalpanier = Math.round(this.prixtotalpanier * 100) / 100;
  }

  public calculePrixLivraison() {
    if (this.typeCommande == 'Livraison') {
      console.log(this.pizzas.length, 'pizza.lenth');
      this.prixLivraison = this.pizzas.length * 2;
      this.prixLivraison = Math.round(this.prixLivraison * 100) / 100;
    } else {
      this.prixLivraison = 0;
    }
  }

  public calculReducEmploye() {
    if (this.utilisateur.employe) {
      this.reductionEmploye = this.prixtotalpanier * 0.3;
      this.reductionEmploye = Math.round(this.reductionEmploye * 100) / 100;
    }
  }

  public calculPrixTotal() {
    this.prixTotal =
      this.prixtotalpanier + this.prixLivraison - this.reductionEmploye;
    this.prixTotal = Math.round(this.prixTotal * 100) / 100;
  }

  public lancementDesCalculs() {
    this.calculTotalPrixCommande();
    this.calculePrixLivraison();
    this.calculReducEmploye();
    this.calculPrixTotal();
  }

  ngOnInit(): void {
    console.log(this.utilisateur);
    this.afficherDessertsPanier();
    this.afficherBoissonsPanier();
    this.afficherPizzasPanier();
    this.lancementDesCalculs();
  }

  public submit() {
    let commandeAngular: Commande = new Commande();
    commandeAngular.clientTicket = this.utilisateur;
    commandeAngular.boissons = this.boissons;
    commandeAngular.pizzas = this.pizzas;
    commandeAngular.desserts = this.desserts;
    commandeAngular.typeCommande = this.typeCommande;
    commandeAngular.prixTotal = this.prixTotal;
    commandeAngular.heureSouhaite = this.heureSouhaite;
    if (this.typeCommande == 'Salle') {
      commandeAngular.place = 'Emporter';
    }

    console.log(commandeAngular, 'commandeAngular click submit');

    this.commandeService.create(commandeAngular).subscribe(() => {
      this.router.navigateByUrl('/commandevalidee');
    });
  }

  public retourCompte() {
    this.router.navigateByUrl('/compte');
  }
}
