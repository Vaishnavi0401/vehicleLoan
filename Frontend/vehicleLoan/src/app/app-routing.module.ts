import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path: '', component: HomeComponent,
  children:[
    {path:'about-us', component:AboutUsComponent},
    {path: 'login', component: LoginComponent},
  ]
},
  // {path: '/about-us', component: AboutUsComponent},
  // {path: '/login', component: LoginComponent},
  // {path: '', redirectTo:'/home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }