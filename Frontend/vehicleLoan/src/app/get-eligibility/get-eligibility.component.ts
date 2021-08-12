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

  ValidateForm: FormGroup;

  age: number;
  typeOfEmployment: string;
  salary: number;
  existingEMI: number;



  constructor(private getService: EligibilityService) { }

  TestEligibility(){
    console.log("Assign Parameters");
    this.eligibility.age = this.age;
    this.eligibility.typeOfEmployment = this.typeOfEmployment;
    this.eligibility.yearlySalary = this.salary;
    this.existingEMI = this.existingEMI;
    this.getService.checkEligibilityService(this.eligibility)
    .subscribe(val => alert(val.status));

  }

  ngOnInit(): void {
    this.ValidateForm = new FormGroup({
      Name : new FormControl('', [Validators.required, Validators.minLength(4)]),
      EmailId: new FormControl('',[Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9-]+\.[a-z]{2,4}$")]),
      MobileNo: new FormControl('', [Validators.required, Validators.pattern('^(\\+?\d{1,4}[\s-])?(?!0+\s+,?$)\\d{10}\s*,?$')] ),
    });
  }

  submitLogin(form:FormGroup){
    console.log("Is Form Valid", form.valid);
    console.log("Email ", form.value.EmailId);
    console.log("Name ",form.value.Name);
  }

}
