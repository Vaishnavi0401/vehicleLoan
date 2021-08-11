import { Component, OnInit } from '@angular/core';
import { EligibilityService } from '../eligibility.service';
import { EligibilityCheck } from '../pojos/EligibilityCheck';

@Component({
  selector: 'app-get-eligibility',
  templateUrl: './get-eligibility.component.html',
  styleUrls: ['./get-eligibility.component.css']
})
export class GetEligibilityComponent implements OnInit {


  eligible: EligibilityCheck = new EligibilityCheck();

  age: number;
  typeOfEmployment: string;
  salary: number;
  existingEMI: number;



  constructor(private getService: EligibilityService) { }

  checkEligibility(){
    console.log("Assign Parameters");
    this.eligible.age = this.age;
    this.eligible.typeOfEmployment = this.typeOfEmployment;
    this.eligible.yearlySalary = this.salary;
    this.existingEMI = this.existingEMI;
    this.getService.checkEligibilityService(this.eligible)
    .subscribe(val => alert(val.status));

  }

  ngOnInit(): void {
   
  }

}
