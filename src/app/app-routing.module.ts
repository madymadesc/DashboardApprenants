import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterComponent } from './ajouter/ajouter.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ListeComponent } from './liste/liste.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: 'ajouter', component: AjouterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'liste', component: ListeComponent },
  { path: 'users', component: UsersComponent },
  { path: '', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
