
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TopbarComponent } from './webapp/topbar/topbar.component';
import { SidebarComponent } from './webapp/sidebar/sidebar.component';

@Component({
	selector: 'app-root',
	standalone: true,
	imports: [
		CommonModule, RouterOutlet,
		TopbarComponent, SidebarComponent
	],
	templateUrl: './app.component.html',
	styleUrl: './app.component.css'
})
export class AppComponent implements OnInit
{

	author:string = "Franklin Enrique Rodriguez Revolorio"

	private optionName: string = 'menu';
	menuActual:string = '0';

	ngOnInit()
	{
		// throw new Error('Method not implemented.');
		this.seleccionarMenu();
	}


	seleccionarMenu()
	{
		let opcionSeleccionada = localStorage.getItem( this.optionName );

		if( opcionSeleccionada )
		{
			this.menuActual = opcionSeleccionada;
		}
		else
		{
			localStorage.setItem( this.optionName , '0' );
		}

	}


	cambiarMenu(){
		localStorage.setItem( this.optionName, '1' );
	}


}
