import { Component, HostBinding, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from 'src/app/model/utilisateur';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  get logged() {
    return sessionStorage.getItem('token');
  }

  get utilisateur(): Utilisateur | null {
    if (sessionStorage.getItem('utilisateur')) {
      return JSON.parse(sessionStorage.getItem('utilisateur')!) as Utilisateur;
    }
    return null;
  }

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('/acceuil');
  }

  color: string = '#fff';

  @HostListener('window:scroll') onScroll() {
    // console.log('NAVBAR', window.scrollY);
    // console.log('NAVBAR', this.color);
    if (window.scrollY >= 100) {
      this.color = '#26282b';
    } else {
      this.color = '#fff';
    }
  }
}
