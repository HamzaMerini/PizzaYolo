import { Observable } from 'rxjs';
import { Recette } from './../../model/recette';
import { RecetteService } from './../../services/recette.service';
import { Component, OnInit } from '@angular/core';
import { Boisson } from 'src/app/model/boisson';
import { Dessert } from 'src/app/model/dessert';
import { BoissonService } from 'src/app/services/boisson.service';
import { DessertService } from 'src/app/services/dessert';

@Component({
  selector: 'app-carte',
  templateUrl: './carte.component.html',
  styleUrls: ['./carte.component.css'],
})
export class CarteComponent implements OnInit {
  recettes: Observable<Recette[]>;
  desserts: Observable<Dessert[]>;
  boissons: Observable<Boisson[]>;
  constructor(
    private recetteService: RecetteService,
    private boissonService: BoissonService,
    private dessertService: DessertService
  ) {
    this.recettes = this.recetteService.getAll();
    this.desserts = this.dessertService.getAll();
    this.boissons = this.boissonService.getAll();
  }

  ngOnInit(): void {}
}
