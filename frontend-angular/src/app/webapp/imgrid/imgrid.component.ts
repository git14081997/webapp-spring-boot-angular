
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-imgrid',
  standalone: true,
  imports: [],
  templateUrl: './imgrid.component.html',
  styleUrl: './imgrid.component.css'
})
export class ImgridComponent {

  @Input() source: string = "";

  @Input() titulo: string = "";

}
