import { Component, OnInit } from '@angular/core';
import { LoanOfferService } from '../loan-offer.service';
import { OfferTable } from '../pojos/OfferTable';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EMICalc } from '../pojos/EMICalculator';
import { EmiCalculatorService } from '../emi-calculator.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-loan-offer',
  templateUrl: './loan-offer.component.html',
  styleUrls: ['./loan-offer.component.css']
})
export class LoanOfferComponent implements OnInit {

  constructor(private loanOfferService: LoanOfferService, private router: Router) { }

  offerTable:OfferTable[]=[];
  amount:number;
  rate:number;
  tenure:number;
  emi:number;
  emiCalc:EMICalc;
  validateForm: FormGroup;
  emiArray:number[]=[];

  offerTableObject:OfferTable;
  selectedOffer: OfferTable;

  ngOnInit(): void {
    this.validateForm=new FormGroup(
      {
        principal:new FormControl('',[Validators.required,Validators.min(0)])
        
      }
    );
    
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
  

  selectOffer(offer: OfferTable){
    var result = confirm("We'd like to confirm your selection: "+"\nAmount: Rs. "+offer.offerAmount+"\nRate: "+offer.offerRate+"\nTennure: "+offer.offerTenure+"\nEMI: Rs. "+offer.offerEmi);
    if(result == true){
      sessionStorage.setItem("offer", JSON.stringify(offer));
      this.router.navigate(['/application-form']);
    }
    // console.log(offer);
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
 
    



}
