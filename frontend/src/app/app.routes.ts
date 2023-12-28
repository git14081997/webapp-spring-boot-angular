
import { Routes } from '@angular/router';

import { PruebasComponent } from './pruebas/pruebas.component';

import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { CategoriaListComponent } from './categoria-list/categoria-list.component';
import { ClienteabonaListComponent } from './clienteabona-list/clienteabona-list.component';
import { FacturaListComponent } from './factura-list/factura-list.component';
import { FacturadetalleListComponent } from './facturadetalle-list/facturadetalle-list.component';
import { ProductoListComponent } from './producto-list/producto-list.component';
import { TipopagoListComponent } from './tipopago-list/tipopago-list.component';

export const routes: Routes = [
{ path: '', component: UsuariosListComponent, title: 'Usuarios',},
{ path: '', component: CategoriaListComponent, title: 'Categorias',},
{ path: '', component: ClienteabonaListComponent, title: 'Cliente Abona',},
{ path: '', component: FacturaListComponent, title: 'Facturas',},
{ path: '', component: FacturadetalleListComponent, title: 'Detalles de facturas',},
{ path: '', component: ProductoListComponent, title: 'Productos',},
{ path: '', component: TipopagoListComponent, title: 'Tipos de pago',},
];
