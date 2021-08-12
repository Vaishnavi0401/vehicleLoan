import { Component, OnInit } from '@angular/core';
import { AdminDashboardService } from '../admin-dashboard.service';
import { AdminDashboardLoanDetail } from '../pojos/AdminDashboardLoanDetail';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  allLoanDetails: AdminDashboardLoanDetail[]=[];
  tempLoanDetails:AdminDashboardLoanDetail[]=[];


  constructor(private adminDashboardService: AdminDashboardService) { }

  ngOnInit(): void {
  this.adminDashboardService.getAllLoanDetailsService().subscribe(
    (data:AdminDashboardLoanDetail[])=>
    {
      this.allLoanDetails=data;
      this.tempLoanDetails=data;
    },
    (err)=>{
      console.log(err);
    }

  );
  }
  xdata:any;
  deleted:boolean;
  deleteLoanDetail(deleteLoanId:number)
  {
    console.log('loan detail to be deleted'+deleteLoanId);
    this.adminDashboardService.deleteLoanDetailsService(deleteLoanId).
    subscribe((data:any)=>
    {
      this.xdata=data;
      console.log('log is '+ data);
      if(data==null)
      {
        this.deleted=true;
        this.tempLoanDetails=this.allLoanDetails.filter(l=>(l.loanId!=deleteLoanId));
        console.log('from deleteLoan().. method'+data);
        console.log(this.tempLoanDetails);
        this.allLoanDetails=this.tempLoanDetails;
        console.log('Loan Details deleted '+ deleteLoanId);
      }
    },(err)=>{
      console.log(err+'error'+this.xdata);
    }



    );

  }// end of delete loan detail 

  //approveLoan: AdminDashboardLoanDetail=new AdminDashboardLoanDetail(); 

  ydata:any;
  approved:boolean;
  approveLoanDetail(approveLoanDetail: AdminDashboardLoanDetail)
  {
    console.log('Loan Id to be approved: '+approveLoanDetail.loanId);     //only for displaying 
    approveLoanDetail.approval="yes";
    this.adminDashboardService.approveLoanDetailService(approveLoanDetail).
    subscribe((data:any)=>
      {
        this.ydata=data;
        console.log('log is '+data);
        if(data==null){
        this.approved=true;
        this.tempLoanDetails=this.allLoanDetails.filter(l=>approveLoanDetail.approval="yes");
        console.log('from modifyApproval() method..'+data);
        this.allLoanDetails=this.tempLoanDetails;
        console.log('Loan Details updated '+ approveLoanDetail.loanId +'set to '+approveLoanDetail.approval);
        }
      },
      (err)=>{
        console.log(err+'error'+this.ydata);
      }
    );
  }//end of approve


  zdata:any;
  rejected:boolean;
  rejectLoanDetail(rejectLoanDetail: AdminDashboardLoanDetail)
  {
    console.log('Loan Id to be approved: '+rejectLoanDetail.loanId); //only for displaying 
    rejectLoanDetail.approval="no";
    this.adminDashboardService.rejectLoanDetailService(rejectLoanDetail).
    subscribe((data:any)=>
    {
      this.zdata=data;
      console.log('log '+data);
      if(data==null){
        this.rejected=true;
        this.tempLoanDetails=this.allLoanDetails.filter(l=>rejectLoanDetail.approval="no");
        console.log('from modifyApproval() method..'+data);
        this.allLoanDetails=this.tempLoanDetails;
        console.log('Loan Details updated '+ rejectLoanDetail.loanId +'set to '+rejectLoanDetail.approval);
      }
    },
    (err)=>{
      console.log(err+'error'+this.zdata);
    }

    );

  }







}
