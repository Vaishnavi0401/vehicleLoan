import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoanDetail } from '../pojos/LoanDetail';
import { UserDetail } from '../pojos/UserDetail';
import { UserDashboardService } from '../user-dashboard.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  
  users: LoanDetail[];
  userId: number = 0;
  isUserLoggedIn: string;
  
  constructor(private userService : UserDashboardService, private router: Router) { }

  ngOnInit(): void {
    this.isUserLoggedIn = sessionStorage.getItem("isUserLoggedIn");
    console.log(this.isUserLoggedIn);
  }

  message:any;
  getUserDetailsByUserId(userId:number)
  {
    console.log('user id chosen is'+this.userId);
    this.userService.getUsersService(userId).
    subscribe((data:LoanDetail[])=>
     {
      this.users = data;
      console.log(data[0]);
    }
    ,(err) => {
      console.log(err + 'error'+this.message);
      }
    );
  }

  logout(){
    sessionStorage.clear();
    alert('You have successfully logged out!');
    this.router.navigate(['/']);
  }

}

    