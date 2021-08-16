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

  details: LoanDetail[];
  userId: number;

  isLoan: boolean = false;
  isCar: boolean = false;
  isUser: boolean = false;
  message:any;
  sessionUser: UserDetail;
  
  isUserLoggedIn: string;
  
  constructor(private userService : UserDashboardService, private router: Router) { }

  ngOnInit(): void {
    this.isUserLoggedIn = sessionStorage.getItem("isUserLoggedIn");
    this.sessionUser = JSON.parse(sessionStorage.getItem("user_obj"));
    this.userId = this.sessionUser.userId;
    this.getUserDetails(this.userId);
  }
  
  getUserDetails(userId: number){
    console.log('user id chosen is'+this.userId);
    this.userService.getUsersService(userId)
    .subscribe((data:LoanDetail[])=>
     {
      this.details = data;
      console.log(data[0]);
    }
    ,(err) => {
      console.log(err + 'error'+this.message);
      }
    );
  }

  
  getLoanByUserId(userId:number)
  {
    this.isLoan = !this.isLoan;
  }

  getCarByUserId(userId:number)
  {
    this.isCar = !this.isCar;
  }
  
  getUserByUserId(userId:number)
  {
    this.isUser = !this.isUser;
  }


  logout(){
    sessionStorage.clear();
    alert('You have successfully logged out!');
    this.router.navigate(['/']);
  }

}

    