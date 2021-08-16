import { Component, OnInit } from '@angular/core';
import { LoanOfferService } from '../loan-offer.service';
import { OfferTable } from '../pojos/OfferTable';
import {NgxWebstorageModule, SessionStorageService} from 'ngx-webstorage';

import { StorageServiceModule} from 'angular-webstorage-service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EMICalc } from '../pojos/EMICalculator';
import { EmiCalculatorService } from '../emi-calculator.service';



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
  tenure:number;
  emi:number;
  emiCalc:EMICalc;
  validateForm: FormGroup;
  emiArray:number[]=[];

  offerTableObject:OfferTable;

  ngOnInit(): void {
    
  }
  data:any
  getAllLoanOffers(amount:number){

    console.log('Getting Loan Offers..');
    this.loanOfferService.getAllOffersService(amount).
    subscribe((data:OfferTable[])=>
    {
      this.offerTable=data;
      console.log(this.offerTable);
  
    },(err) => {
      console.log(err + 'error'+this.data);
      }
    );
    console.log('offer::'+this.offerTable);
  }
  


//   private sessionStorage:SessionStorageService;

   setValues(amount:number,rate:number,tenure:number){
//   //this.sessionStorage.set(this.offerTableObject.,'offer.offerAmount');
//     this.sessionStorage.store('amount',this.amount);
//     this.sessionStorage.store('rate',this.rate);
//     this.sessionStorage.store('tenure',this.tenure);
//     //this.sessionStorage.store('emi',this.emi);
//     console.log('amount',amount);
//     console.log('rate',rate);
//     console.log('tenure',tenure);
//     //console.log('emi',emi);
 }
//  this.validateForm=new FormGroup(
//   {
//     principal:new FormControl('',[Validators.required,Validators.minLength(5)]),
//     rate:new FormControl('',[Validators.required,Validators.maxLength(3)])
//   }
// );

    



}
