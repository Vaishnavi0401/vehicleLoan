import { Component, OnInit } from '@angular/core';
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
  isLoan: boolean = false;
  isCar: boolean = false;
  isUser: boolean = false;

  constructor(private userService : UserDashboardService) { }

  ngOnInit(): void {
  }

  message:any;
  
  getLoanByUserId(userId:number)
  {
    this.isLoan = !this.isLoan;
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

  getCarByUserId(userId:number)
  {
    this.isCar = !this.isCar;
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
  
  getUserByUserId(userId:number)
  {
    this.isUser = !this.isUser;
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
  
}

    