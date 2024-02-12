import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent implements OnInit {

  ngOnInit(): void {

    let temaActual = localStorage.getItem('theme');

    if( temaActual == undefined || temaActual == null ){
      this.temaClaro();
    }

  }

  temaClaro(){
    localStorage.setItem('theme', 'light');
    document.documentElement.setAttribute('data-bs-theme', 'light')
  }

  temaOscuro(){
    localStorage.setItem('theme', 'dark');
    document.documentElement.setAttribute('data-bs-theme', 'dark')
  }

}
