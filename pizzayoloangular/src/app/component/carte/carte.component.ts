import { Observable } from 'rxjs';
import { Recette } from './../../model/recette';
import { RecetteService } from './../../services/recette.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carte',
  templateUrl: './carte.component.html',
  styleUrls: ['./carte.component.css'],
})
export class CarteComponent implements OnInit {
  recettes: Observable<Recette[]>;
  constructor(private recetteService: RecetteService) {
    this.recettes = this.recetteService.getAll();
  }

  ngOnInit(): void {}
}
