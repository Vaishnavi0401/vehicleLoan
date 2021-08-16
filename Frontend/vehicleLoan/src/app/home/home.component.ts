import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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
