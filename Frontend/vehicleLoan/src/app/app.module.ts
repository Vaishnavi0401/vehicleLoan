import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoanOfferComponent } from './loan-offer/loan-offer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { GetEligibilityComponent } from './get-eligibility/get-eligibility.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { ApplicationFormComponent } from './application-form/application-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { BaseComponent } from './base/base.component';
// import { Ng5SliderModule } from 'ng5-slider';

@NgModule({
  declarations: [
    AppComponent,    
    LoanOfferComponent,
    DashboardComponent,
    EmiCalculatorComponent,
    AdminDashboardComponent,
    GetEligibilityComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    HomeComponent,
    PageNotFoundComponent,
    AboutUsComponent,
    LoginComponent,
    ApplicationFormComponent,
    UserDashboardComponent,
    BaseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    // Ng5SliderModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
