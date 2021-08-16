import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Debtor } from '../debtor';
import { UserIncomeDetails1 } from '../userincomedetails1';
import { UserIncomeDetails3 } from '../userincomedetails3';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

  title = 'incomedetails1';
  userModel = new UserIncomeDetails3();
  topicHasError = true;
  submitted = false;
  errorMsg = '';
  userModeler = new Debtor();
  validateTopic(value: string) {
    if (value === 'default') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }
  onSubmit() {
    this.userModeler.PROPERTIESS=this.userModel;
    var x=JSON.stringify(this.userModel)
    console.log('hi there form 1'+x);
    localStorage.setItem('property',x);
    this.submitted = true;
    alert("Form 1 Submitted Sucessfully");
    this.router.navigate(['application/incomeDetails']);
  }
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

}
