import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, MinLengthValidator } from '@angular/forms';
import { LoginService } from '../login.service';
import { Login } from '../pojos/Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  login: Login = new Login();

  constructor(private getService: LoginService) { }

  loginId(){
    console.log("Assign parameters");
    this.getService.loginService(this.login).subscribe(    
      val=> alert(this.login.emailId+" "+ val.status)
    );
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
    emailId: new FormControl('',[Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9-]+\.[a-z]{2,4}$")]),
    password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.pattern("(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=[^0-9]*[0-9]).{8,}")])
  });
}

  submitLogin(form: FormGroup){
    console.log("Is Form Valid: ",form.valid);
    console.log("Email: ", form.value.email); 
    console.log("Password: ",form.value.password);
  }
}