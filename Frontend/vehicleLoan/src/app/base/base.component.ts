import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.css']
})
export class BaseComponent implements OnInit {

  isUserLoggedIn: string;
  isAdminLoggedIn: string;  

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.isUserLoggedIn = sessionStorage.getItem("isUserLoggedIn");
    this.isAdminLoggedIn = sessionStorage.getItem("isAdminLoggedIn");
  }

  
  goToDashboard(){
    if(this.isUserLoggedIn == 'true'){
      this.router.navigate(['/user-dashboard'])
    }
    if(this.isAdminLoggedIn == 'true'){
      this.router.navigate(['/admin-dashboard'])
    }
  }

}
