import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagEmpComponent } from './pag-emp/pag-emp.component';
import { IndexComponent } from './index/index.component';
import { MostrarEmpleadosComponent } from './mostrar-empleados/mostrar-empleados.component';
import { EmpleadoDeleteComponent } from './empleado-delete/empleado-delete.component';
import { PerfilEmpleadoComponent } from './perfil-empleado/perfil-empleado.component';
import { VacLicComponent } from './vac-lic/vac-lic.component';
import { EvaluacionComponent } from './evaluacion/evaluacion.component';
import { TurnoComponent } from './turno/turno.component';
import { PagoComponent } from './pago/pago.component';

export const routes: Routes = [
    { path: 'index', component: IndexComponent },
    { path: 'pagEmp', component: PagEmpComponent },
    { path: 'mostrarEmp', component: MostrarEmpleadosComponent},
    { path: '',redirectTo:'/index',pathMatch:'full' },
    { path: 'empleadoDelete', component: EmpleadoDeleteComponent},
    { path: 'empleadoPerfil', component: PerfilEmpleadoComponent},
    { path: 'pagVac_lic', component: VacLicComponent},
    { path: 'turnos', component: TurnoComponent},
    { path: 'pagos', component: PagoComponent},
    { path: 'evaluacion', component: EvaluacionComponent}

    
];
