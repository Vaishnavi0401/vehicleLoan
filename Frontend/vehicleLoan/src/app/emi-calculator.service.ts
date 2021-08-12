import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EMICalc } from './pojos/EMICalculator';


@Injectable({
  providedIn: 'root'
})

export class EmiCalculatorService {

  constructor(private myhttp: HttpClient) { }

  emiCalculatorService(emiCal: EMICalc): Observable<any>{

    console.log("From Service");  
    console.log(emiCal.principal);
    return this.myhttp.post<any>("http://localhost:8085/calculateEmi", emiCal)
   
  }
}
