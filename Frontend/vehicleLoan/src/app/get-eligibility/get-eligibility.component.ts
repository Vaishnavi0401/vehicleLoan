import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators , MinLengthValidator} from '@angular/forms';
import { EligibilityService } from '../eligibility.service';
import { EligibilityCheck } from '../pojos/EligibilityCheck';

@Component({
  selector: 'app-get-eligibility',
  templateUrl: './get-eligibility.component.html',
  styleUrls: ['./get-eligibility.component.css']
})
export class GetEligibilityComponent implements OnInit {


  eligibility: EligibilityCheck = new EligibilityCheck();

  validateForm: FormGroup;

  age: number;
  typeOfEmployment: string;
  salary: number;
  existingEMI: number;
  Name: string;


  constructor(private getService: EligibilityService) { }

  testEligibility(){
    console.log("Assign Parameters");
    this.eligibility.age = this.age;
    this.eligibility.typeOfEmployment = this.typeOfEmployment;
    this.eligibility.yearlySalary = this.salary;
    this.existingEMI = this.existingEMI;
    this.getService.checkEligibilityService(this.eligibility)
    .subscribe(val => alert(this.Name + " " +val.status));

  }

  ngOnInit(): void {  
    this.validateForm = new FormGroup({
      Name : new FormControl('', [Validators.required, Validators.minLength(3)]),
      emailId: new FormControl('',[Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9-]+\.[a-z]{2,4}$")]),
      mobileNo: new FormControl('', [Validators.required, Validators.pattern('^(\\+?\d{1,4}[\s-])?(?!0+\s+,?$)\\d{10}\s*,?$')] ),
      onRoadPrice: new FormControl('', [Validators.required, Validators.min(0)]),
      exShowRoomPrice: new FormControl('', [Validators.required, Validators.min(0)]),
      carModel: new FormControl('', [Validators.required, Validators.minLength(3)]),
      carMaker: new FormControl('', [Validators.required, Validators.minLength(3)])
    });
  }

  submitForm(form:FormGroup){
    console.log("Is Form Valid", form.valid);
    console.log("Name ", form.value.Name);
    console.log("Email ",form.value.emailId);
    console.log("Mobile No ", form.value.mobileNo);
  }

}
