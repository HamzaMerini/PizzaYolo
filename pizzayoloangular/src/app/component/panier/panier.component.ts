import { Pizza } from './../../model/pizza';
import { Router } from '@angular/router';
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

  constructor(private router: Router) {}

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

  ngOnInit(): void {
    this.afficherDessertsPanier();
    this.afficherBoissonsPanier();
    this.afficherPizzasPanier();
  }
  public supprimerDessert(dessert: Dessert) {
    this.desserts.splice(this.desserts.indexOf(dessert), 1);
    sessionStorage.setItem('dessertsPanier', JSON.stringify(this.desserts));
    this.afficherDessertsPanier();
    this.router.navigate(['/panier']);
  }
  public supprimerBoisson(boisson: Boisson) {
    this.boissons.splice(this.boissons.indexOf(boisson), 1);
    sessionStorage.setItem('boissonsPanier', JSON.stringify(this.boissons));
    this.afficherBoissonsPanier();
    this.router.navigate(['/panier']);
  }

  public supprimerPizza(pizza: Pizza) {
    this.pizzas.splice(this.pizzas.indexOf(pizza), 1);
    sessionStorage.setItem('pizzasPanier', JSON.stringify(this.pizzas));
    this.afficherPizzasPanier();
    this.router.navigate(['/panier']);
  }
}
