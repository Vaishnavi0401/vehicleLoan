import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { IdentityDetailsComponent } from './identity-details/identity-details.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    EmiCalculatorComponent,
    VehicleDetailsComponent,
    IdentityDetailsComponent,
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
