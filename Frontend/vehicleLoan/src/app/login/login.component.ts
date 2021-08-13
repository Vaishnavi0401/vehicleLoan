import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Login } from '../pojos/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // loginForm: FormGroup;

  login: Login = new Login();

  // emailId: string;
  // password: string;

  constructor(private getService: LoginService) { }

  loginId(){
    console.log("Assign parameters");
    // this.login.emailId = this.emailId;
    // this.login.password = this.password;
    this.getService.loginService(this.login).subscribe( 
      val=> console.log(val)
    );
    

  }

  ngOnInit(): void {
    // this.loginForm = new FormGroup({
  //   email: new FormControl('',[Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9-]+\.[a-z]{2,4}$")]),
  //   pwd:new FormControl('', [Validators.required, Validators.minLength(8), Validators.pattern("(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=[^0-9]*[0-9]).{8,}")]),
 //  });
  }

  // submitLogin(form: FormGroup){
  //   console.log("Is Form Valid: ",form.valid);
  //   console.log("Email: ", form.value.email); 
  //   console.log("Password: ",form.value.pwd);
  // }
}