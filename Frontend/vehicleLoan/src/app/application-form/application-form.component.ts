import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AddressDetail } from '../pojos/AddressDetail';
import { CarDetail } from '../pojos/CarDetail';
import { CarMaker } from '../pojos/CarMaker';
import { CarType } from '../pojos/carType';
import { City } from '../pojos/City';
import { State } from '../pojos/State';
import { UserDetail } from '../pojos/UserDetail';
import { ApplicationFormService } from './application-form.service';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent implements OnInit {

  validateForm: FormGroup;

  //----------------------------PERSONAL DETAILS----------------------------
  allStates: State[] = [];
  allCities: City[] = [];
  allCars: CarDetail[] = [];
  allCarMakers: CarMaker[] = [];
  allCarTypes: CarType[] = [];
  selectedCities: City[] = [];

  userDetail: UserDetail;
  city: City;
  state: State;
  addressDetail: AddressDetail;
  carDetail: CarDetail;
  carMaker: CarMaker;
  carType: CarType;

  password: string = '';
  password1: string = '';
  //----------------------------PERSONAL DETAILS ENDS----------------------------


  constructor(private appFormService: ApplicationFormService) { }

  ngOnInit(): void {

    this.validateForm = new FormGroup({
      name : new FormControl('', [Validators.required,]),
      age : new FormControl('', [Validators.required,]),
      emailId: new FormControl('',[Validators.required, Validators.pattern("[a-z0-9._%+-]+@[a-z0-9-]+\.[a-z]{2,4}$")]),
      mobileNumber: new FormControl('', [Validators.required, Validators.pattern('^(\\+?\d{1,4}[\s-])?(?!0+\s+,?$)\\d{10}\s*,?$')] ),
    })

    this.getAllStates();
    this.getAllCities();
    this.getAllCarMakers();
    this.getAllCarTypes();

    this.userDetail = new UserDetail();
    this.city = new City();
    this.state = new State();
    this.addressDetail = new AddressDetail();
    this.carDetail = new CarDetail();
    this.carMaker = new CarMaker();
    this.carType = new CarType();
  }

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
        console.log(data);
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

  personalDetails() {
    this.addressDetail.city = this.getCity(this.city.cityId);
    this.userDetail.addressDetail = this.addressDetail;
    this.userDetail.role = 1;
    console.log(this.allCars);
    // console.log("printing the addresid of the user using this.userDetail.addressDetail.addressId: ",this.userDetail.addressDetail.address);
    // console.log("printing the addresid of the user using this.userDetail.addressDetail.city.cityName: ",this.userDetail.addressDetail.city.cityName);
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

  carDetails() {
    this.carDetail.carMaker = this.getCarMaker(this.carMaker.carMakerId);
    this.carDetail.carType = this.getCarType(this.carType.carTypeId);
    console.log(this.carDetail);
    // this.appFormService.addCarService(this.carDetail).subscribe(
    //   (val)=> console.log(val.status),
    //   (err)=>console.log(err)
    // )
  }

  //----------------------------CAR DETAILS ENDS----------------------------

}
