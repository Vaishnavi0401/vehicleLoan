import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminDashboardFilesComponent } from './admin-dashboard-files/admin-dashboard-files.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ApplicationFormComponent } from './application-form/application-form.component';
import { BaseComponent } from './base/base.component';
import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { GetEligibilityComponent } from './get-eligibility/get-eligibility.component';
import { HomeComponent } from './home/home.component';
import { LoanOfferComponent } from './loan-offer/loan-offer.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';


const routes: Routes = [
  { path: '', redirectTo:'/home', pathMatch: 'full'},
  {
    path: '', component: BaseComponent,
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'about-us', component: AboutUsComponent },
      { path: 'login', component: LoginComponent },
      { path: 'emi-calculator', component: EmiCalculatorComponent },
      { path: 'check-eligibility', component: GetEligibilityComponent },
      { path: 'loan-offers', component: LoanOfferComponent },
      { path: 'application-form', component: ApplicationFormComponent },
    ],
  },
 
  { path: 'user-dashboard', component: UserDashboardComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent},
  { path: 'view-files', component: AdminDashboardFilesComponent },
  // {path: '/about-us', component: AboutUsComponent},
  // {path: '/login', component: LoginComponent},
  // {path: '', redirectTo:'/home', pathMatch: 'full'},
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }