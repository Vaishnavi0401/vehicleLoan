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
  
  
  constructor(private userService : UserDashboardService) { }

  ngOnInit(): void {
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
}

    