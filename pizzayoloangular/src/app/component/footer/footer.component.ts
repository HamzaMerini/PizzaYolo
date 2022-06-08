import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent implements OnInit {
  constructor() {}
  monMail = 'contact@pizzayolo.com';
  tel = '04 68 55 40 10';
  ngOnInit(): void {}
}
