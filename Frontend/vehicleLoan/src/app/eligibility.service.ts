import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EligibilityCheck } from './pojos/EligibilityCheck';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', Authorization: 'my-auth-token' }) };

@Injectable({
  providedIn: 'root'
})
export class EligibilityService {

   constructor(private myHttp: HttpClient) { }

  
  checkEligibilityService(check: EligibilityCheck): Observable<any>{
    console.log("From Service");  
    console.log(check.age);
    

    return this.myHttp.post<any>("http://localhost:8085/CheckEligibility", check);                    
    
  }
}
