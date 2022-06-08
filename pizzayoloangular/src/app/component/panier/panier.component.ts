import { Router } from '@angular/router';
import { Pizza } from './../../model/pizza';
import { Boisson } from './../../model/boisson';
import { Dessert } from './../../model/dessert';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
})
export class PanierComponent implements OnInit {
  desserts: Array<Dessert> = [];
  boissons: Array<Boisson> = [];
  pizzas: Array<Pizza> = [];
  showMessageDessert: boolean = false;
  showMessageBoisson: boolean = false;
  showMessagePizza: boolean = false;
  prixtotalpanier: number = 0;
  showBontonCommande: boolean = false;

  constructor(private router: Router) {}

  public afficherDessertsPanier() {
    if (sessionStorage.getItem('dessertsPanier')) {
      this.desserts = JSON.parse(sessionStorage.getItem('dessertsPanier')!);
      this.showMessageDessert = false;
    } else {
      this.showMessageDessert = true;
    }
    this.calculTotalPrixCommande();
    if (sessionStorage.getItem('dessertsPanier')) {
      this.showBontonCommande = true;
    }
  }

  public afficherBoissonsPanier() {
    if (sessionStorage.getItem('boissonsPanier')) {
      this.boissons = JSON.parse(sessionStorage.getItem('boissonsPanier')!);
      this.showMessageBoisson = false;
    } else {
      this.showMessageBoisson = true;
    }
    this.calculTotalPrixCommande();
    if (sessionStorage.getItem('boissonsPanier')) {
      this.showBontonCommande = true;
    }
  }

  public afficherPizzasPanier() {
    if (sessionStorage.getItem('pizzasPanier')) {
      this.pizzas = JSON.parse(sessionStorage.getItem('pizzasPanier')!);
      this.showMessagePizza = false;
    } else {
      this.showMessagePizza = true;
    }
    this.calculTotalPrixCommande();

    if (sessionStorage.getItem('pizzasPanier')) {
      this.showBontonCommande = true;
    }
  }

  ngOnInit(): void {
    this.showBontonCommande = false;
    this.afficherDessertsPanier();
    this.afficherBoissonsPanier();
    this.afficherPizzasPanier();
  }
  public supprimerDessert(dessert: Dessert) {
    this.desserts.splice(this.desserts.indexOf(dessert), 1);
    sessionStorage.setItem('dessertsPanier', JSON.stringify(this.desserts));
    this.afficherDessertsPanier();
  }
  public supprimerBoisson(boisson: Boisson) {
    this.boissons.splice(this.boissons.indexOf(boisson), 1);
    sessionStorage.setItem('boissonsPanier', JSON.stringify(this.boissons));
    this.afficherBoissonsPanier();
  }

  public supprimerUnDessert(dessert: Dessert) {
    this.desserts[this.trouverIndiceDessertPannier(dessert)].quantite!--;
    if (
      this.desserts[this.trouverIndiceDessertPannier(dessert)].quantite == 0
    ) {
      this.desserts.splice(this.trouverIndiceDessertPannier(dessert), 1);
    }
    sessionStorage.setItem('dessertsPanier', JSON.stringify(this.desserts));
    this.afficherDessertsPanier();
  }
  public supprimerUneBoisson(boisson: Boisson) {
    this.boissons[this.trouverIndiceBoissonPannier(boisson)].quantite!--;
    if (
      this.boissons[this.trouverIndiceBoissonPannier(boisson)].quantite == 0
    ) {
      this.boissons.splice(this.trouverIndiceBoissonPannier(boisson), 1);
    }

    sessionStorage.setItem('boissonsPanier', JSON.stringify(this.boissons));
    this.afficherBoissonsPanier();
  }

  public trouverIndiceDessertPannier(dessert: Dessert): number {
    let indice: number = 0;
    while (
      indice < this.desserts.length &&
      this.desserts[indice].nom != dessert.nom
    ) {
      indice++;
    }
    if (indice < this.desserts.length) {
      return indice;
    } else {
      return -1;
    }
  }

  public trouverIndiceBoissonPannier(boisson: Boisson): number {
    let indice: number = 0;
    while (
      indice < this.boissons.length &&
      this.boissons[indice].nom != boisson.nom
    ) {
      indice++;
    }
    if (indice < this.boissons.length) {
      return indice;
    } else {
      return -1;
    }
  }

  public supprimerPizza(pizza: Pizza) {
    this.pizzas.splice(this.pizzas.indexOf(pizza), 1);
    sessionStorage.setItem('pizzasPanier', JSON.stringify(this.pizzas));
    this.afficherPizzasPanier();
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

  public Pagecommander() {
    this.router.navigateByUrl('/commande');
  }

  public totalLigne(article: any): number {
    let prixLigne: number = article.prix! * article.quantite!;
    return prixLigne;
  }
}
