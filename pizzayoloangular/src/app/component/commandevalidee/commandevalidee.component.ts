import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commandevalidee',
  templateUrl: './commandevalidee.component.html',
  styleUrls: ['./commandevalidee.component.css'],
})
export class CommandevalideeComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
  public retour() {
    this.router.navigateByUrl('/acceuil');
  }
}
