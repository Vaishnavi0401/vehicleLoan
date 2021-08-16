import { Component, OnInit, Pipe } from '@angular/core';
import { Router } from '@angular/router';
import { LoanDetail } from '../pojos/LoanDetail';
import { State } from '../pojos/State';
import { UserDetail } from '../pojos/UserDetail';
import { UserDashboardService } from '../user-dashboard.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  details: LoanDetail[];
  userId: number = 0;

  isLoan: boolean = false;
  isCar: boolean = false;
  isUser: boolean = false;
  message:any;


  constructor(private userService : UserDashboardService) { }

  isUserLoggedIn: string;
  
  constructor(private userService : UserDashboardService, private router: Router) { }

  ngOnInit(): void {
    this.isUserLoggedIn = sessionStorage.getItem("isUserLoggedIn");
    console.log(this.isUserLoggedIn);
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

    