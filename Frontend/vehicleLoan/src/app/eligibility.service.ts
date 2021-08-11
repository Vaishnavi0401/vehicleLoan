import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EligibilityCheck } from './pojos/EligibilityCheck';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', Authorization: 'my-auth-token' }) };

@Injectable({
  providedIn: 'root'
})
export class EligibilityService {

   constructor(private myhttp: HttpClient) { }

  
  checkEligibilityService(eligibilitycheck: EligibilityCheck): Observable<any>{
    console.log("From Service");  
    console.log(eligibilitycheck.age);
    

    return this.myhttp.post<any>("http://localhost:8085/CheckEligibility", eligibilitycheck);                    
    
  }
}
