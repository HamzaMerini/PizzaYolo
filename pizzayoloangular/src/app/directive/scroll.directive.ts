import { Directive, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appScroll]',
})
export class ScrollDirective {
  constructor() {}

  @HostBinding('class.new-nav')
  newNav!: boolean;

  @HostListener('window:scroll') onScroll() {
    // console.log(window.scrollY);
    if (window.scrollY >= 100) {
      this.newNav = true;
    } else {
      this.newNav = false;
    }

    //   if (window.width() < 992) {
    //     if(this.scrollTop() > 45) {
    //         ('.fixed-top').addClass('bg-white shadow');
    //     } else {
    //         ('.fixed-top').removeClass('bg-white shadow');
    //     }
    // } else {
    //     if (this.scrollTop() > 45) {
    //         ('.fixed-top').addClass('bg-white shadow').css('top', -5);
    //         ('.navbar .navbar-nav .nav-link').css({"color":"#26282b"});
    //     } else {
    //         ('.fixed-top').removeClass('bg-white shadow').css('top', 0);
    //         ('.navbar .navbar-nav .nav-link').css({"color":"white"});
    //     }
    // }
    //   ('.navbar .navbar-nav .nav-link:hover, .navbar .navbar-nav .nav-link.active').css({"color":"var(--monVert)"});
  }
}
