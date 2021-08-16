import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonalDetailsComponent } from './personal-details/personal-details.component';
import { LoanOfferComponent } from './loan-offer/loan-offer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoanDetailsComponent } from './loan-details/loan-details.component';

import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { IdentityDetailsComponent } from './identity-details/identity-details.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HttpClient, HttpClientModule } from '@angular/common/http'

import { GetEligibilityComponent } from './get-eligibility/get-eligibility.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { EmploymentDetailsComponent } from './employment-details/employment-details.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { ApplicationFormComponent } from './application-form/application-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';




@NgModule({
  declarations: [
    AppComponent,

    PersonalDetailsComponent,
    LoanOfferComponent,
    DashboardComponent,
    LoanDetailsComponent,
    EmiCalculatorComponent,
    VehicleDetailsComponent,
    IdentityDetailsComponent,
    AdminDashboardComponent,
    GetEligibilityComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    EmploymentDetailsComponent,
    HomeComponent,
    PageNotFoundComponent,
    AboutUsComponent,
    LoginComponent,
    ApplicationFormComponent,
    UserDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
