
import { Routes } from '@angular/router';

import { PruebasComponent } from './pruebas/pruebas.component';

import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { ClienteabonaListComponent } from './clienteabona-list/clienteabona-list.component';
import { FacturaListComponent } from './factura-list/factura-list.component';
import { FacturadetalleListComponent } from './facturadetalle-list/facturadetalle-list.component';
import { ProductoListComponent } from './producto-list/producto-list.component';
import { CrearPedidoComponent } from './crear-pedido/crear-pedido.component';

import { InicioComponent } from './inicio/inicio.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

export const routes: Routes = [

{ path: '', component: InicioComponent, title: 'Inicio',},

{ path: 'usuarios', component: UsuariosListComponent, title: 'Usuarios',},
{ path: 'abonosdelcliente', component: ClienteabonaListComponent, title: 'Abonos del cliente',},
{ path: 'facturas', component: FacturaListComponent, title: 'Facturas',},
{ path: 'detalledefacturas', component: FacturadetalleListComponent, title: 'Detalles de facturas',},
{ path: 'productos', component: ProductoListComponent, title: 'Productos',},
{ path: 'registrar-venta', component: CrearPedidoComponent, title: 'Registrar venta',},

{ path: '**', component: PagenotfoundComponent, title: 'Error 404',},
];
