import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { EmploymentDetailsComponent } from './employment-details/employment-details.component';
import { GetEligibilityComponent } from './get-eligibility/get-eligibility.component';
import { HomeComponent } from './home/home.component';
import { IdentityDetailsComponent } from './identity-details/identity-details.component';
import { LoanDetailsComponent } from './loan-details/loan-details.component';
import { LoanOfferComponent } from './loan-offer/loan-offer.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PersonalDetailsComponent } from './personal-details/personal-details.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';

const routes: Routes = [
  {path: '', component: HomeComponent,
  children:[
    {path:'about-us', component:AboutUsComponent},
    {path: 'login', component: LoginComponent},
    {path: 'emi-calculator', component: EmiCalculatorComponent},
    {path: 'check-eligibility', component: GetEligibilityComponent},
    {path: 'loan-offers', component: LoanOfferComponent},
    {path: 'personal-details', component: PersonalDetailsComponent},
    {path: 'employment-details', component: EmploymentDetailsComponent},
    {path: 'vehicle-details', component: VehicleDetailsComponent},
    {path: 'loan-details', component: LoanDetailsComponent},
    {path: 'identity-details', component: IdentityDetailsComponent},
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