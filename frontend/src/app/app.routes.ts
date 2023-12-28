
import { Routes } from '@angular/router';

import { PruebasComponent } from './pruebas/pruebas.component';

import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { CategoriaListComponent } from './categoria-list/categoria-list.component';
import { ClienteabonaListComponent } from './clienteabona-list/clienteabona-list.component';
import { FacturaListComponent } from './factura-list/factura-list.component';
import { FacturadetalleListComponent } from './facturadetalle-list/facturadetalle-list.component';
import { ProductoListComponent } from './producto-list/producto-list.component';
import { TipopagoListComponent } from './tipopago-list/tipopago-list.component';

import { InicioComponent } from './inicio/inicio.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

export const routes: Routes = [

{ path: 'inicio', component: InicioComponent, title: 'Inicio',},
{ path: '', component: PagenotfoundComponent, title: 'Error 404',},
{ path: 'usuarios', component: UsuariosListComponent, title: 'Usuarios',},
{ path: 'categorias', component: CategoriaListComponent, title: 'Categorias',},
{ path: 'cliabo', component: ClienteabonaListComponent, title: 'Cliente Abona',},
{ path: 'facturas', component: FacturaListComponent, title: 'Facturas',},
{ path: 'detalledefacturas', component: FacturadetalleListComponent, title: 'Detalles de facturas',},
{ path: 'productos', component: ProductoListComponent, title: 'Productos',},
{ path: 'tiposdepago', component: TipopagoListComponent, title: 'Tipos de pago',},
{ path: 'pruebas', component: PruebasComponent, title: 'Pruebas',},

];
