import { Component, OnInit } from '@angular/core';
import { LoanOfferService } from '../loan-offer.service';
import { OfferTable } from '../pojos/OfferTable';

@Component({
  selector: 'app-loan-offer',
  templateUrl: './loan-offer.component.html',
  styleUrls: ['./loan-offer.component.css']
})
export class LoanOfferComponent implements OnInit {

  constructor(private loanOfferService: LoanOfferService) { }

  offerTable:OfferTable[]=[];
  amount:number;
  rate:number;
  ngOnInit(): void {
  }
  
  data:any
  getAllLoanOffers(amount:number,rate:number){

    console.log('Getting Loan Offers..');
    this.loanOfferService.getAllOffersService(amount,rate).
    subscribe((data:OfferTable[])=>
    {
      this.offerTable=data;
      console.log(this.offerTable);

    },(err) => {
      console.log(err + 'error'+this.data);
      }


    );
  }




}
