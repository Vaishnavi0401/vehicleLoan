import { HttpEventType, HttpResponse } from '@angular/common/http';
import { escapeRegExp } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { toUnicode } from 'punycode';
import { Observable } from 'rxjs';
import { AccountTypeDetail } from '../pojos/AccountTypeDetail';
import { AddressDetail } from '../pojos/AddressDetail';
import { AdvancedUserDetail } from '../pojos/AdvancedUserDetail';
import { ApplicationFormDTO } from '../pojos/ApplicationFormDTO';
import { CarDetail } from '../pojos/CarDetail';
import { CarMaker } from '../pojos/CarMaker';
import { CarType } from '../pojos/CarType';
import { City } from '../pojos/City';
import { EmploymentDetail } from '../pojos/EmploymentDetail';
import { LoanDetail } from '../pojos/LoanDetail';
import { State } from '../pojos/State';
import { TypeOfEmploymentDetail } from '../pojos/TypeOfEmploymentDetail';
import { UserDetail } from '../pojos/UserDetail';
import { ApplicationFormService } from './application-form.service';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent implements OnInit {

 

  constructor(private appFormService: ApplicationFormService, private router: Router) { }

  ngOnInit(): void {

    this.getAllStates();
    this.getAllCities();
    this.getAllCarMakers();
    this.getAllCarTypes();
    this.getAllTypeOfEmploymentDetails()
    this.getAllAccountTypeDetails();

    this.userDetail = new UserDetail();
    this.city = new City();
    this.state = new State();
    this.addressDetail = new AddressDetail();
    this.carDetail = new CarDetail();
    this.carMaker = new CarMaker();
    this.carType = new CarType();
    this.typeOfEmploymentDetail = new TypeOfEmploymentDetail();
    this.accountTypeDetail = new AccountTypeDetail();
    this.employmentDetail = new EmploymentDetail();
    this.loanDetail = new LoanDetail();
    this.applicationFormDTO = new ApplicationFormDTO();
    this.advancedUserDetail = new AdvancedUserDetail();
  }

  

  // personalDetailSubmitted = false;
  step: any = 1;
  ageErrorMsg = '';
  ageHasError = false;
  passwordErrorMsg = '';
  passwordHasError = false;
  mobileNumberErrorMsg = '';
  mobileNumberHasError = false;
  personalDetailHasError = this.ageHasError || this.passwordHasError || this.mobileNumberHasError;
  annualSalaryErrorMsg = '';
  annualSalaryError = false;

  validateAge(value: number) {
    if (value < 18) {
      this.ageErrorMsg="Age should be greater than 18";
      this.ageHasError = true;
    } 
    else if(value > 65){
      this.ageErrorMsg="Age should be less than 60";
      this.ageHasError = true;
    }
    else{
      this.ageErrorMsg = '';
      this.ageHasError = false;
    }
  }

  validateMobileNumber(mobileNumber: string){
    if(mobileNumber.length != 10){
      this.mobileNumberErrorMsg = "Mobile number must be of 10 digits";
      this.mobileNumberHasError = true;
    }
    else{
      this.mobileNumberErrorMsg = '';
      this.mobileNumberHasError = false;
    }
    sessionStorage.setItem('loanAmount', '500000');
  }

  validatePassword(){
    if(this.password1 != this.password){
      this.passwordErrorMsg = "Passwords don't match"
      this.passwordHasError = true;
    }
    else{
      this.passwordErrorMsg = ''
      this.passwordHasError = false;
    }
  }
  
  validateAnnualSalary(annualSalary: number){
    console.log(annualSalary);
    if(annualSalary<300000){
      this.annualSalaryErrorMsg = 'Annual Salary Cannot be less than 300000';
      this.annualSalaryError = true;
    }
    else{
      this.annualSalaryErrorMsg = '';
      this.annualSalaryError = false;
    } 
  }

  next(){
    this.step = this.step + 1;
  }

  previous(){
    this.step = this.step - 1;
  }

  //----------------------------PERSONAL DETAILS----------------------------
  allStates: State[] = [];
  allCities: City[] = [];
  allCars: CarDetail[] = [];
  allCarMakers: CarMaker[] = [];
  allCarTypes: CarType[] = [];
  allTypeOfEmploymentDeatils: TypeOfEmploymentDetail[] = [];
  allAccountTypeDetails: AccountTypeDetail[] = [];
  selectedCities: City[] = [];


  userDetail: UserDetail;
  city: City;
  state: State;
  addressDetail: AddressDetail;
  carDetail: CarDetail;
  carMaker: CarMaker;
  carType: CarType;
  employmentDetail: EmploymentDetail;
  typeOfEmploymentDetail: TypeOfEmploymentDetail;
  accountTypeDetail: AccountTypeDetail;
  loanDetail: LoanDetail;
  advancedUserDetail: AdvancedUserDetail;
  applicationFormDTO: ApplicationFormDTO;

  password: string = '';
  password1: string = '';

  aadharCardSelectedFiles: FileList;
  aadharCardCurrentFile: File;
  aadharCardProgress = 0;
  aadharCardMessage = '';
  aadharCardSelected: boolean = false;

  panCardSelectedFiles: FileList;
  panCardCurrentFile: File;
  panCardProgress = 0;
  panCardMessage = '';
  panCardSelected: boolean = false;

  photoSelectedFiles: FileList;
  photoCurrentFile: File;
  photoProgress = 0;
  photoMessage = '';
  photoSelected: boolean = false;

  salarySlipSelectedFiles: FileList;
  salarySlipCurrentFile: File;
  salarySlipProgress = 0;
  salarySlipMessage = '';
  salarySlipSelected: boolean = false;

  identityDetailHasError:boolean = !this.aadharCardSelected || !this.panCardSelected || !this.photoSelected || !this.salarySlipSelected;


  //----------------------------PERSONAL DETAILS ENDS----------------------------


  //----------------------------PERSONAL DETAILS----------------------------
  getAllStates() {
    this.appFormService.getAllStatesService().subscribe(
      (data: State[]) => {
        this.allStates = data;
        
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getAllCities() {
    this.appFormService.getAllCitiesService().subscribe(
      (data: City[]) => {
        this.allCities = data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  //State Selected by the user based on which cities are filtered
  stateSelected() {
    console.log(this.state.stateId);
    this.selectedCities = this.allCities.filter(
      c => (c.state.stateId == this.state.stateId)
    )
  }

  getState(stateId: string): State {
    return this.allStates.filter(
      state => (state.stateId == stateId)
    )[0];
  }

  getCity(cityId: string): City {
    return this.allCities.filter(
      city => (city.cityId == cityId)
    )[0];

  }

  onPersonalDetailSubmit() {
    console.log("Submitted");
    this.addressDetail.city = this.getCity(this.city.cityId);
    this.userDetail.addressDetail = this.addressDetail;
    this.userDetail.role = 1;
    this.userDetail.password = this.password;
    console.log(this.userDetail);
    this.next();
    // this.appFormService.addUserService(this.userDetail).subscribe(
    //   (val)=> console.log(val.status),
    //   (err)=>console.log(err)
    // )
  }

  //----------------------------PERSONAL DETAILS ENDS----------------------------

  //----------------------------CAR DETAILS----------------------------

  getAllCars() {
    this.appFormService.getAllCarsService().subscribe(
      (data: CarDetail[]) => {
        this.allCars = data;
        
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getAllCarMakers() {
    this.appFormService.getAllCarMakerService().subscribe(
      (data: CarMaker[]) => {
        this.allCarMakers = data;
        
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getAllCarTypes() {
    this.appFormService.getAllCarTypeService().subscribe(
      (data: CarType[]) => {
        this.allCarTypes = data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getCarMaker(carMakerId: number): CarMaker {
    return this.allCarMakers.filter(
      carMaker => (carMaker.carMakerId == carMakerId)
    )[0];
  }

  getCarType(carTypeId: number): CarType {
    return this.allCarTypes.filter(
      carType => (carType.carTypeId == carTypeId)
    )[0];
  }

  onCarDetailSubmit() {
    this.carDetail.carMaker = this.getCarMaker(this.carMaker.carMakerId);
    this.carDetail.carType = this.getCarType(this.carType.carTypeId);
    console.log(this.carDetail);
    this.next();
    // this.appFormService.addCarService(this.carDetail).subscribe(
    //   (val)=> console.log(val.status),
    //   (err)=>console.log(err)
    // )
  }

  //----------------------------CAR DETAILS ENDS----------------------------

  //----------------------------EMPLOYMENT DETAILS----------------------------

  getAllTypeOfEmploymentDetails() {
    this.appFormService.getAllTypeOfEmploymentDetailService().subscribe(
      (data: TypeOfEmploymentDetail[]) => {
        this.allTypeOfEmploymentDeatils = data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getAllAccountTypeDetails() {
    this.appFormService.getAllAccountTypeDetailService().subscribe(
      (data: AccountTypeDetail[]) => {
        this.allAccountTypeDetails = data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  onEmploymentDetailSubmit(){
    this.employmentDetail.typeOfEmploymentDetail = this.typeOfEmploymentDetail;
    this.employmentDetail.accountTypeDetail = this.accountTypeDetail;
    console.log(this.employmentDetail);
    this.next();
  }
  //----------------------------EMPLOYMENT DETAILS ENDS----------------------------

//----------------------------LOAN DETAILS STARTS----------------------------
  onLoanDetailSubmit(){
    console.log(this.loanDetail);
    this.loanDetail.approval = "pending";
    this.next();
  }
  //----------------------------LOAN DETAILS ENDS----------------------------

//----------------------------IDENTITY DETAILS STARTS----------------------------


aadharCardSelectFile(event) {
  // console.log(this.aadharCardSelectedFiles)
  this.aadharCardSelectedFiles = event.target.files;
  this.aadharCardSelected = this.aadharCardSelectedFiles.length>0;
  
}

aadharCardUpload() {
  this.aadharCardProgress = 0;

  this.aadharCardCurrentFile = this.aadharCardSelectedFiles.item(0);
  this.aadharCardSelectedFiles = null;
  this.appFormService.upload(this.aadharCardCurrentFile).subscribe(
    event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.aadharCardProgress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.aadharCardMessage = event.body.message;
        // this.fileInfos = this.uploadService.getFiles();
      }
    },
    err => {
      this.aadharCardProgress = 0;
      this.aadharCardMessage = 'Could not upload the file!';
      this.aadharCardCurrentFile = undefined;
    });

  this.aadharCardSelectedFiles = undefined;
  this.identityDetailHasError = !this.aadharCardSelected || !this.panCardSelected || !this.photoSelected || !this.salarySlipSelected;
}

panCardSelectFile(event) {
  // console.log(this.aadharCardSelectedFiles)
  this.panCardSelectedFiles = event.target.files;
  this.panCardSelected = this.panCardSelectedFiles.length>0;
}

panCardUpload() {
  this.panCardProgress = 0;

  this.panCardCurrentFile = this.panCardSelectedFiles.item(0);
  this.panCardSelectedFiles = null;
  this.appFormService.upload(this.panCardCurrentFile).subscribe(
    event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.panCardProgress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.panCardMessage = event.body.message;
        // this.fileInfos = this.uploadService.getFiles();
      }
    },
    err => {
      this.panCardProgress = 0;
      this.panCardMessage = 'Could not upload the file!';
      this.panCardCurrentFile = undefined;
    });

  this.panCardSelectedFiles = undefined;
  this.identityDetailHasError = !this.aadharCardSelected || !this.panCardSelected || !this.photoSelected || !this.salarySlipSelected;
}

photoSelectFile(event) {
  // console.log(this.aadharCardSelectedFiles)
  this.photoSelectedFiles = event.target.files;
  this.photoSelected = this.photoSelectedFiles.length>0;
  
}

photoUpload() {
  this.photoProgress = 0;

  this.photoCurrentFile = this.photoSelectedFiles.item(0);
  this.photoSelectedFiles = null;
  this.appFormService.upload(this.photoCurrentFile).subscribe(
    event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.photoProgress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.photoMessage = event.body.message;
        // this.fileInfos = this.uploadService.getFiles();
      }
    },
    err => {
      this.photoProgress = 0;
      this.photoMessage = 'Could not upload the file!';
      this.photoCurrentFile = undefined;
    });

  this.photoSelectedFiles = undefined;
  this.identityDetailHasError = !this.aadharCardSelected || !this.panCardSelected || !this.photoSelected || !this.salarySlipSelected;
}

salarySlipSelectFile(event) {
  // console.log(this.aadharCardSelectedFiles)
  this.salarySlipSelectedFiles = event.target.files;
  this.salarySlipSelected = this.salarySlipSelectedFiles.length>0;
  
  
}

salarySlipUpload() {
  this.salarySlipProgress = 0;

  this.salarySlipCurrentFile = this.salarySlipSelectedFiles.item(0);
  this.salarySlipSelectedFiles = null;
  this.appFormService.upload(this.salarySlipCurrentFile).subscribe(
    event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.salarySlipProgress = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.salarySlipMessage = event.body.message;
        // this.fileInfos = this.uploadService.getFiles();
      }
    },
    err => {
      this.salarySlipProgress = 0;
      this.salarySlipMessage = 'Could not upload the file!';
      this.salarySlipCurrentFile = undefined;
    });

  this.salarySlipSelectedFiles = undefined;
  this.identityDetailHasError = !this.aadharCardSelected || !this.panCardSelected || !this.photoSelected || !this.salarySlipSelected;
}

onIdentityDetailSubmit(){
  this.advancedUserDetail.userDetail = this.userDetail;
  this.advancedUserDetail.aadhaarCard = "*";
  this.advancedUserDetail.panCard = "*";
  this.advancedUserDetail.photo = "*";
  this.advancedUserDetail.salarySlip = "*";
  this.applicationFormDTO.userDetail = this.userDetail;
  this.applicationFormDTO.carDetail = this.carDetail;
  this.applicationFormDTO.employmentDetail = this.employmentDetail;
  this.applicationFormDTO.loanDetail = this.loanDetail;
  this.applicationFormDTO.advancedUserDetail = this.advancedUserDetail;

  console.log(this.applicationFormDTO);

  this.appFormService.addApplicationForm(this.applicationFormDTO).subscribe(
    (data: any) => {
      console.log(data);
    }
  );
  // alert("Your Details have been successfully submitted!");
  // this.router.navigate(['/']);
}
//----------------------------IDENTITY DETAILS ENDS----------------------------


}


