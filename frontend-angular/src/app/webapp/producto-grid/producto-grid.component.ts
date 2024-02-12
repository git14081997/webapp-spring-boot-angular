
import { Component, OnInit } from '@angular/core';
import { ImgridComponent } from '../imgrid/imgrid.component';

@Component({
  selector: 'app-producto-grid',
  standalone: true,
  imports: [    
    ImgridComponent
  ],
  templateUrl: './producto-grid.component.html',
  styleUrl: './producto-grid.component.css'
})
export class ProductoGridComponent implements OnInit {

  productos: any[] = [];

  ngOnInit(): void {
    this.productos = [
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Bonage' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Jingo' },

      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Bonage' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Jingo' },

      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Bonage' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Jingo' },


    ];
  }

}
