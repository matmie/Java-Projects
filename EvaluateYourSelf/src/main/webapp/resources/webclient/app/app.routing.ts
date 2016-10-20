import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//COMPONENTS FOR ROUTING
import { AppComponent } from './app.component';
import { LoginComponent } from './login-angular/login.component';
import { RegisterComponent } from './register-angular/register.component';
import { UsersComponent } from './users/users.component';

const appRoutes: Routes = [
  {
      path: 'home' ,
      
      component: UsersComponent
  },
  {
  	  path: 'login',
  	  component: LoginComponent
  },
  {
  	  path: '',
  	  redirectTo: '/home',
  	  pathMatch: 'full'
  },
  {
      path: 'register',
      component: RegisterComponent
  }
]; 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);