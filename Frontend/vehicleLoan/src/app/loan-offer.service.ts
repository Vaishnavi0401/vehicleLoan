import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OfferTable } from './pojos/OfferTable';

@Injectable({
  providedIn: 'root'
})
export class LoanOfferService {

  baseUrl:string='http://localhost:8085/loan/';
  constructor(private myhttp: HttpClient) { }

  getAllOffersService(amount:number):Observable<any>{
    return this.myhttp.get<OfferTable[]>(this.baseUrl+"getAllLoanOffers/"+amount);
  }


}
