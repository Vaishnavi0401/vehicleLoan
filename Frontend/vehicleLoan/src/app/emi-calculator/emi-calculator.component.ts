import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EmiCalculatorService } from '../emi-calculator.service';
import { EMICalc } from '../pojos/EMICalculator';


@Component({
  selector: 'app-emi-calculator',
  templateUrl: './emi-calculator.component.html',
  styleUrls: ['./emi-calculator.component.css']
})
export class EmiCalculatorComponent implements OnInit {
  emiForm: FormGroup;
  emiCalc: EMICalc = new EMICalc();

  principalAmount: number;
  rate: number;
  timePeriod: number;
  emiFinal: number;

  constructor(private getService: EmiCalculatorService) { }

  calculateEMI(){
    console.log("Assign parameters");
    this.emiCalc.principal=this.principalAmount;
    this.emiCalc.rateOfInterest=this.rate;
    this.emiCalc.tenure=this.timePeriod;
    this.getService.emiCalculatorService(this.emiCalc).subscribe(
      (data: number)=> {this.emiFinal=data;console.log(this.emiFinal);},
      (err)=> {console.log(err);}
    );
    console.log(this.emiCalc);
    console.log(this.emiFinal);
  }

  ngOnInit(): void {

    this.emiForm = new FormGroup({
    principal: new FormControl('', [Validators.required, Validators.min(200000)]),
    rate: new FormControl('', [Validators.required, Validators.min(3)]),
    tenure: new FormControl('', [Validators.required, Validators.min(2)])
    })
  }

}
