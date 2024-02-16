
import { Routes } from '@angular/router';
import { UsuariosListComponent } from './webapp/usuarios-list/usuarios-list.component';
import { ClienteabonaListComponent } from './webapp/clienteabona-list/clienteabona-list.component';
import { FacturaListComponent } from './webapp/factura-list/factura-list.component';
import { ProductoListComponent } from './webapp/producto-list/producto-list.component';
import { CrearPedidoComponent } from './webapp/crear-pedido/crear-pedido.component';
import { InicioComponent } from './basic/inicio/inicio.component';
import { PagenotfoundComponent } from './basic/pagenotfound/pagenotfound.component';
import { IngresosEgresosListComponent } from './webapp/ingresos-egresos-list/ingresos-egresos-list.component';
import { ExcelProductosComponent } from './webapp/excel-productos/excel-productos.component';
import { ProductoGridComponent } from './webapp/producto-grid/producto-grid.component';
import { UploadImageComponent } from './webapp/upload-image/upload-image.component';

export const routes: Routes = [
{ path: '', component: InicioComponent, title: 'Inicio',},
{ path: 'usuarios', component: UsuariosListComponent, title: 'Usuarios',},
{ path: 'abonosdelcliente', component: ClienteabonaListComponent, title: 'Abonos del cliente',},
{ path: 'facturas', component: FacturaListComponent, title: 'Facturas',},
{ path: 'productos', component: ProductoListComponent, title: 'Productos',},
{ path: 'mercaderia', component: ProductoGridComponent, title: 'Catalogo de productos',},
{ path: 'registrar-venta', component: CrearPedidoComponent, title: 'Registrar venta',},
{ path: 'ie', component: IngresosEgresosListComponent, title: 'Balance',},
{ path: 'upload', component: ExcelProductosComponent, title: 'Guardar desde excel',},
{ path: 'upload-image', component: UploadImageComponent, title: 'Guardar imagen',},
{ path: '**', component: PagenotfoundComponent, title: 'Error 404',},
];
