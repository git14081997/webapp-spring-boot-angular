
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

      { 'src': 'assets/1.jpg', 'inf': 'Tenis' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/2.jpg', 'inf': 'Blusa' },

      { 'src': 'assets/3.jpg', 'inf': 'Poncho' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/2.jpg', 'inf': 'Blusa' },

      { 'src': 'assets/1.jpg', 'inf': 'Tenis' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },
      { 'src': 'assets/2.jpg', 'inf': 'Blusa' },

      { 'src': 'assets/1.jpg', 'inf': 'Tenis' },
      { 'src': 'assets/0.jpg', 'inf': 'Pantalon Acme' },


    ];
  }

}
