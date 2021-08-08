import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonalDetailsComponent } from './personal-details/personal-details.component';
import { LoanOfferComponent } from './loan-offer/loan-offer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoanDetailsComponent } from './loan-details/loan-details.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonalDetailsComponent,
    LoanOfferComponent,
    DashboardComponent,
    LoanDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
