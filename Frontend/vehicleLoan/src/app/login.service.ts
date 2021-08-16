import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './pojos/Login';
import { UserDetail } from './pojos/UserDetail';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private myhttp: HttpClient) { }

  loginService(login: Login): Observable<UserDetail>{
    console.log("Get service");
    console.log(login.password);
    console.log(login.emailId);

    return this.myhttp.post<UserDetail>("http://localhost:8085/login", login)

  }
}
