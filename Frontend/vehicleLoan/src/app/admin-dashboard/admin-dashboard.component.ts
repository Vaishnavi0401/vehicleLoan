import { Component, OnInit } from '@angular/core';
import { AdminDashboardService } from '../admin-dashboard.service';
import { AdminDashboardLoanDetail } from '../pojos/AdminDashboardLoanDetail';
import { AdvancedUserDetail } from '../pojos/AdvancedUserDetail';
import { EmploymentDetail } from '../pojos/EmploymentDetail';
import { UserDetail } from '../pojos/UserDetail';
import {Location} from '@angular/common';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  allLoanDetails: AdminDashboardLoanDetail[]=[];
  tempLoanDetails:AdminDashboardLoanDetail[]=[];
  getLoanDetailArray:AdminDashboardLoanDetail[]=[];
  getLoanbyLoanId: number=0;
  l1: number=0;
  getLoanDetail:AdminDashboardLoanDetail;
  approval:string;
  allUserDetails: UserDetail[]=[];


  divAllLoan:boolean=true;
  divViewMore:boolean=true;
  divOneLoan:boolean=true;
  divAprrovalLoan:boolean=true;
  divUserDetail:boolean;

  constructor(private adminDashboardService: AdminDashboardService) { }

  private location: Location;

  // backClicked() {
  //   this.location.back();
  // }



  ngOnInit(): void {
  // this.adminDashboardService.getAllLoanDetailsService().subscribe(
  //   (data:AdminDashboardLoanDetail[])=>
  //   {
  //     this.allLoanDetails=data;
  //     this.tempLoanDetails=data;
  //   },
  //   (err)=>{
  //     console.log(err);
  //   }

  // );
  this.getAllLoanDetails();
  }

  getAllLoanDetails(){
    
    this.divAllLoan=true;
    this.divViewMore=false;
    this.divOneLoan=false;
    this.divAprrovalLoan=false;
    this.divUserDetail=false;

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
  getAllUserDetails(){
    this.divUserDetail=true;
    this.divAllLoan=false;
    this.divViewMore=false;
    this.divOneLoan=false;
    this.divAprrovalLoan=false;

    this.adminDashboardService.getAllUserDetailsService()
    .subscribe((data:UserDetail[])=>
    {
      this.allUserDetails=data;
    },(err)=>{
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
  } //end of reject


  // selectLoanDetailByLoanId(){
  //   if(this.getLoanbyLoanId==0){
  //     console.log('loan id chosen is zero'+this.getLoanbyLoanId);
  //     this.tempLoanDetails=this.allLoanDetails;
  //   }
  //   else
  //   {
  //     console.log('loan Id chosen is: '+this.getLoanbyLoanId);
  //     this.tempLoanDetails=this.allLoanDetails.filter(l=>{l.loanId==this.getLoanbyLoanId});
  //     //this.allLoanDetails=this.tempLoanDetails;
  //     console.log('length of tempLoanDetails: '+this.tempLoanDetails.length);
  //     
  //   }
  // }
  adata:any;
  searched:boolean;
  selectLoanDetailByLoanId(getLoanbyLoanId:number)
  {
    this.divAllLoan=false;
    this.divViewMore=false;
    this.divOneLoan=true;
    this.divAprrovalLoan=false;
    this.divUserDetail=false;

    console.log('loan id chosen is'+this.getLoanbyLoanId);
    this.adminDashboardService.getLoanDetailsbyloanIdService(getLoanbyLoanId).
    subscribe((data:AdminDashboardLoanDetail)=>
    {
      this.getLoanDetail=data;
      console.log(this.getLoanDetail);
      //this.tempLoanDetails=this.allLoanDetails.filter(l=>(l.loanId==this.getLoanbyLoanId));
      //this.getLoanDetailArray=this.allLoanDetails.filter(l=>(l.loanId==this.getLoanbyLoanId));
      console.log('length of getLoanDetailArray'+ this.getLoanDetailArray.length);
      console.log('length of tempLoanDetails: '+this.tempLoanDetails.length);
      console.log('length of allLoanDetails: '+this.allLoanDetails.length);      
    },(err) => {
      console.log(err + 'error'+this.adata);
      }
    );
  } //end of search

  viewAdvancedUserDetailByLoanId:AdvancedUserDetail;
  //viewAdvancedUserDetailByLoanIdArray:AdvancedUserDetail[]=[];
  viewEmploymentDetailByLoanId:EmploymentDetail[]=[];


  bdata:any;
  viewed:boolean;
  viewLoanDetails(viewAllDetailByLoanId:number)
  {
    this.selectLoanDetailByLoanId(viewAllDetailByLoanId);
    this.divAllLoan=false;
    this.divViewMore=true;
    this.divOneLoan=true;
    this.divAprrovalLoan=false;
    this.divUserDetail=false;

    console.log('loan id chosen is'+this.getLoanbyLoanId);
    this.adminDashboardService.viewAdvancedUserDetailbyLoanIdService(viewAllDetailByLoanId).
    subscribe((data:AdvancedUserDetail)=>
    {
      this.viewAdvancedUserDetailByLoanId=data;
      
      console.log(this.viewAdvancedUserDetailByLoanId);
      //this.viewAdvancedUserDetailByLoanIdArray=this.viewAdvancedUserDetailByLoanIdArray.filter(v=>())


    },(err) => {
      console.log(err + 'error'+this.adata);
      }
    );
    console.log('viewEmploymentDetailsbyLoanId Service from ts');
    this.adminDashboardService.viewEmploymentDetailsbyLoanIdService(viewAllDetailByLoanId).
    subscribe((data:EmploymentDetail[])=>
    {
      this.viewEmploymentDetailByLoanId=data;
      console.log(this.viewEmploymentDetailByLoanId);
    },(err) => {
      console.log(err + 'error'+this.adata);
      }
    
    );
  }
  approvalLoanDetailArray:AdminDashboardLoanDetail[]=[];
  cdata:any;
  getLoanDetailsbyApproval(approval:string)
  {    
    this.divAprrovalLoan=true;
    this.divAllLoan=false;
    this.divOneLoan=false;
    this.divViewMore=false;
    this.divUserDetail=false;

    console.log('approval chosen is: '+approval);
    this.adminDashboardService.viewLoanDetailsbyApprovalService(approval).
    subscribe((data:AdminDashboardLoanDetail[])=>
    {
      this.approvalLoanDetailArray=data;
      console.log(this.approvalLoanDetailArray);
      console.log('length of approvalLoanDetailArray'+this.approvalLoanDetailArray.length);
      console.log('length of getLoanDetailArray'+ this.getLoanDetailArray.length);
      console.log('length of allLoanDetails: '+this.allLoanDetails.length);      
    
    },(err) => {
      console.log(err + 'error'+this.adata);
      }
    );
    
    
  
  }





  viewEmploymentDetailByLoanIdArray:EmploymentDetail[]=[];






 //this.allLoanDetails=this.tempLoanDetails;
        //   console.log('from searchLoan() '+data);
      //   console.log(this.tempLoanDetails);
         
      //   console.log('Employee Searched'+getLoanbyLoanId);
      
      // this.adata=data;
      // console.log('log is'+ data);
      // if(data==null)
      // {
      //   this.searched=true;
      
      // }

}