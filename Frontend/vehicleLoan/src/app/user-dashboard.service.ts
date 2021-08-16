import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserDashboardService {

  constructor(private myHttp1: HttpClient) { }

 
  getUsersService(userId: number): Observable<any>{
    console.log("From Service");
    return this.myHttp1.get<any>("http://localhost:8085/user/getUserbyId/"+ userId);                    

  }
  
}
