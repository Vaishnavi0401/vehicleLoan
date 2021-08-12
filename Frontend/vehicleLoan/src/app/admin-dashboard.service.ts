
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminDashboardLoanDetail } from './pojos/AdminDashboardLoanDetail';

@Injectable({
  providedIn: 'root'
})
export class AdminDashboardService {

  baseUrl:string='http://localhost:8090/admin/'
  constructor(private myhttp: HttpClient) { }

  getAllLoanDetailsService(): Observable<any>{
    
    return this.myhttp.get<AdminDashboardLoanDetail[]>(this.baseUrl+"getAllLoanDetails");
    console.log("From Service");
    //console.log(adminDashboardLoanDetail.loanId);
  }

  deleteLoanDetailsService(loanId:number):Observable<String>
  {
    return this.myhttp.delete<string>(this.baseUrl+"deleteLoan/"+loanId);
  }
  approveLoanDetailService(adminDashboardLoanDetail:AdminDashboardLoanDetail):Observable<AdminDashboardLoanDetail>
  {
    console.log("From service");
    console.log(adminDashboardLoanDetail.loanId);
    console.log(adminDashboardLoanDetail.approval);
    return this.myhttp.post<AdminDashboardLoanDetail>(this.baseUrl+"modifyApproval/",adminDashboardLoanDetail);
  }

  rejectLoanDetailService(adminDashboardLoanDetail:AdminDashboardLoanDetail):Observable<AdminDashboardLoanDetail>
  {
    console.log("From service");
    console.log(adminDashboardLoanDetail.loanId);
    console.log(adminDashboardLoanDetail.approval);
    return this.myhttp.post<AdminDashboardLoanDetail>(this.baseUrl+"modifyApproval/",adminDashboardLoanDetail);
  }

  //return this.myhttp.post<any>("http://localhost:8090/admin/getAllLoanDetails",adminDashboardLoanDetail);
  getLoanDetailsbyloanIdService(loanId: number):Observable<any>
  {
    console.log("From Service");
    return this.myhttp.get<AdminDashboardLoanDetail>(this.baseUrl+"getLoanDetailbyLoanId/"+loanId);
  }



}
