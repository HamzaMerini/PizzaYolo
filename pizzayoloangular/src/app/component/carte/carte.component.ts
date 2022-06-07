import { Router } from '@angular/router';
import { PizzaService } from './../../services/pizza.service';
import { Pizza } from './../../model/pizza';
import { Observable } from 'rxjs';
import { Recette } from './../../model/recette';
import { RecetteService } from './../../services/recette.service';
import { Component, OnInit } from '@angular/core';
import { Boisson } from 'src/app/model/boisson';
import { Dessert } from 'src/app/model/dessert';
import { BoissonService } from 'src/app/services/boisson.service';
import { DessertService } from 'src/app/services/dessert';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-carte',
  templateUrl: './carte.component.html',
  styleUrls: ['./carte.component.css'],
})
export class CarteComponent implements OnInit {
  recettes: Observable<Recette[]>;
  desserts: Observable<Dessert[]>;
  boissons: Observable<Boisson[]>;
  showformPizza: boolean = false;
  pizza: Pizza = new Pizza();

  constructor(
    private recetteService: RecetteService,
    private boissonService: BoissonService,
    private dessertService: DessertService,
    private pizzaService: PizzaService,
    private router: Router
  ) {
    this.recettes = this.recetteService.getAll();
    this.desserts = this.dessertService.getAll();
    this.boissons = this.boissonService.getAll();
    this.pizza.pate = 'Classique';
    this.pizza.taille = 'Medium';
  }

  ngOnInit(): void {}

  public ajouterdessert(dessert: Dessert) {
    if (sessionStorage.getItem('dessertsPanier')) {
      let dessertsPanierObjet: Array<Dessert> = [];
      dessertsPanierObjet = JSON.parse(
        sessionStorage.getItem('dessertsPanier')!
      );
      dessertsPanierObjet.push(dessert);
      sessionStorage.setItem(
        'dessertsPanier',
        JSON.stringify(dessertsPanierObjet)
      );
      console.log(sessionStorage.getItem('dessertsPanier'));
    } else {
      let dessertsPanierObjet: Array<Dessert> = [];
      dessertsPanierObjet.push(dessert);
      sessionStorage.setItem(
        'dessertsPanier',
        JSON.stringify(dessertsPanierObjet)
      );
    }
  }

  public ajouterboisson(boisson: Boisson) {
    if (sessionStorage.getItem('boissonsPanier')) {
      let boissonsPanierObjet: Array<Boisson> = [];
      boissonsPanierObjet = JSON.parse(
        sessionStorage.getItem('boissonsPanier')!
      );
      boissonsPanierObjet.push(boisson);
      sessionStorage.setItem(
        'boissonsPanier',
        JSON.stringify(boissonsPanierObjet)
      );
      console.log(sessionStorage.getItem('boissonsPanier'));
    } else {
      let boissonsPanierObjet: Array<Boisson> = [];
      boissonsPanierObjet.push(boisson);
      sessionStorage.setItem(
        'boissonsPanier',
        JSON.stringify(boissonsPanierObjet)
      );
    }
  }
  //Stockage d'un objet plus compliqué
  //localStorage.setItem('monObjet', JSON.stringify(monObjet));
  //Récupération de l'objet
  //monObjet = JSON.parse(localStorage.getItem('monObjet'));

  public showFormPizza(recette: Recette) {
    this.showformPizza = true;
    this.pizza.recette = recette;
  }

  public savePizza(formPizza: any) {
    let formGroup = formPizza as FormGroup;

    console.log(this.pizza.pate);
    console.log(this.pizza.taille);

    console.log(formGroup.controls['pateCtrl']);

    if (this.pizza.taille == 'Medium') {
      this.pizza.prix = this.pizza.recette!.prixM;
    }
    if (this.pizza.taille == 'Large') {
      this.pizza.prix = this.pizza.recette!.prixL;
    }
    if (this.pizza.taille == 'XL') {
      this.pizza.prix = this.pizza.recette!.prixXL;
    }

    if (this.pizza.pate == 'Pan') {
      this.pizza.prix = this.pizza.prix! + 1.5;
    }
    if (this.pizza.pate == 'MozzaCrust') {
      this.pizza.prix = this.pizza.prix! + 2.9;
    }

    if (sessionStorage.getItem('pizzasPanier')) {
      let pizzasPanierObjet: Array<Pizza> = [];
      pizzasPanierObjet = JSON.parse(sessionStorage.getItem('pizzasPanier')!);
      pizzasPanierObjet.push(this.pizzaService.pizzaToJson(this.pizza));
      sessionStorage.setItem('pizzasPanier', JSON.stringify(pizzasPanierObjet));
      console.log(sessionStorage.getItem('pizzasPanier'));
    } else {
      let pizzasPanierObjet: Array<Pizza> = [];
      pizzasPanierObjet.push(this.pizzaService.pizzaToJson(this.pizza));
      sessionStorage.setItem('pizzasPanier', JSON.stringify(pizzasPanierObjet));
      console.log(sessionStorage.getItem('pizzasPanier'));
    }
    this.showformPizza = false;

    this.pizzaService.create(this.pizza).subscribe(() => {});
  }
}
