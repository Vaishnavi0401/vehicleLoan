import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './pojos/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private myhttp: HttpClient) { }

  loginService(login: Login): Observable<any>{
    console.log("Get service");
    console.log(login.password);
    console.log(login.emailId);

    return this.myhttp.post<any>("http://localhost:8085/login", login)

  }
}
