
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { PruebasComponent } from './pruebas/pruebas.component';
import {RouterModule} from '@angular/router';
import {Routes} from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ CommonModule, RouterOutlet,
PruebasComponent
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}

