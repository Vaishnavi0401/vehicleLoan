import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email:new FormControl('', [Validators.required]),
      pwd:new FormControl('', [Validators.required,  Validators.pattern("/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/") ])
     
    });
  }

  submitLogin(form: FormGroup){
    console.log("Is Form Valid: ",form.valid);
    console.log("Email: ", form.value.email); 
    console.log("Password: ",form.value.pwd);
  }
}