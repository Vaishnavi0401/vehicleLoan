import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { EmiCalculatorService } from '../emi-calculator.service';
import { EMICalc } from '../pojos/EMICalculator';


@Component({
  selector: 'app-emi-calculator',
  templateUrl: './emi-calculator.component.html',
  styleUrls: ['./emi-calculator.component.css']
})
export class EmiCalculatorComponent implements OnInit {

  emiCalc: EMICalc = new EMICalc();

  principalAmount: number;
  rate: number;
  timePeriod: number;
  emiFinal: string;

  constructor(private getService: EmiCalculatorService) { }

  calculateEMI(){
    console.log("Assign parameters");
    this.emiCalc.principal=this.principalAmount;
    this.emiCalc.rateOfInterest=this.rate;
    this.emiCalc.tenure=this.timePeriod;
    this.getService.emiCalculatorService(this.emiCalc).subscribe(
      val=>this.emiFinal=val
    );
    console.log(this.emiCalc);
    console.log(this.emiFinal);
  }

  ngOnInit(): void {
  }

}
