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
  fakeArray = new Array(27);
  recettes: Observable<Recette[]>;
  desserts: Observable<Dessert[]>;
  boissons: Observable<Boisson[]>;
  showformPizza: boolean = false;
  pizza: Pizza = new Pizza();
  dessertsPanierObjet: Array<Dessert> = [];
  boissonsPanierObjet: Array<Boisson> = [];

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

  public trouverRecette(id: number): Observable<Recette[]> {
    return this.recetteService.getById(id);
  }

  public trouverIndiceDessertPannier(dessert: Dessert): number {
    let indice: number = 0;
    while (
      indice < this.dessertsPanierObjet.length &&
      this.dessertsPanierObjet[indice].nom != dessert.nom
    ) {
      indice++;
    }
    if (indice < this.dessertsPanierObjet.length) {
      return indice;
    } else {
      return -1;
    }
  }

  public ajouterdessert(dessert: Dessert) {
    // si j'ai des desserts dans le panier :
    if (sessionStorage.getItem('dessertsPanier')) {
      this.dessertsPanierObjet = JSON.parse(
        sessionStorage.getItem('dessertsPanier')!
      );
      //si le dessert est présent dans le panier on prend la quté plus+1

      if (this.trouverIndiceDessertPannier(dessert) != -1) {
        this.dessertsPanierObjet[this.trouverIndiceDessertPannier(dessert)]
          .quantite!++;
      }

      //si le desset n'est pas dans le panier on prend le dessert on lui met 1 en quantité et on push dans le panier
      else {
        dessert.quantite = 1;
        this.dessertsPanierObjet.push(dessert);
      }

      sessionStorage.setItem(
        'dessertsPanier',
        JSON.stringify(this.dessertsPanierObjet)
      );
      console.log(sessionStorage.getItem('dessertsPanier'));
    }

    // si j'ai aucun dessert dans le panier
    else {
      dessert.quantite = 1;
      this.dessertsPanierObjet.push(dessert);
      sessionStorage.setItem(
        'dessertsPanier',
        JSON.stringify(this.dessertsPanierObjet)
      );

      console.log(sessionStorage.getItem('dessertsPanier'));
    }
  }
  public trouverIndiceBoissonPannier(boisson: Boisson): number {
    let indice: number = 0;
    while (
      indice < this.boissonsPanierObjet.length &&
      this.boissonsPanierObjet[indice].nom != boisson.nom
    ) {
      indice++;
    }
    if (indice < this.boissonsPanierObjet.length) {
      return indice;
    } else {
      return -1;
    }
  }
  public ajouterboisson(boisson: Boisson) {
    // si j'ai des boissons dans le panier :
    if (sessionStorage.getItem('boissonsPanier')) {
      this.boissonsPanierObjet = JSON.parse(
        sessionStorage.getItem('boissonsPanier')!
      );
      //si la boisson est présent dans le panier on prend la quté plus+1

      if (this.trouverIndiceBoissonPannier(boisson) != -1) {
        this.boissonsPanierObjet[this.trouverIndiceBoissonPannier(boisson)]
          .quantite!++;
      }

      //si le desset n'est pas dans le panier on prend le dessert on lui met 1 en quantité et on push dans le panier
      else {
        boisson.quantite = 1;
        this.boissonsPanierObjet.push(boisson);
      }

      sessionStorage.setItem(
        'boissonsPanier',
        JSON.stringify(this.boissonsPanierObjet)
      );
      console.log(sessionStorage.getItem('boissonsPanier'));
    }

    // si j'ai aucun dessert dans le panier
    else {
      boisson.quantite = 1;
      this.boissonsPanierObjet.push(boisson);
      sessionStorage.setItem(
        'boissonsPanier',
        JSON.stringify(this.boissonsPanierObjet)
      );

      console.log(sessionStorage.getItem('boissonsPanier'));
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
