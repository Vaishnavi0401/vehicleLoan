import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarDetail } from '../pojos/CarDetail';
import { CarMaker } from '../pojos/CarMaker';
import { CarType } from '../pojos/carType';
import { City } from '../pojos/City';
import { State } from '../pojos/State';
import { UserDetail } from '../pojos/UserDetail';


@Injectable({
  providedIn: 'root'
})
export class ApplicationFormService {

  baseURL: string = 'http://localhost:8085/appForm/'

  constructor(private myhttp: HttpClient) { }

  // -----------------------PERSONAL DETAILS-------------------------
  getAllStatesService(): Observable<State[]>{
    return this.myhttp.get<State[]>(this.baseURL+"getAllStates");
  }

  getAllCitiesService(): Observable<City[]>{
    return this.myhttp.get<City[]>(this.baseURL+"getAllCities");
  }

  addUserService(user: UserDetail): Observable<any>{
    return this.myhttp.post<any>(this.baseURL+"addUser", user);
  }

  // -----------------------PERSONAL DETAILS ENDS-------------------------

  //----------------------------CAR DETAILS----------------------------
  
  getAllCarsService():Observable<CarDetail[]>{
    return this.myhttp.get<CarDetail[]>(this.baseURL+"getAllCars")
  }

  getAllCarMakerService():Observable<CarMaker[]>{
    return this.myhttp.get<CarMaker[]>(this.baseURL+"getAllCarMakers")
  }

  getAllCarTypeService():Observable<CarType[]>{
    return this.myhttp.get<CarType[]>(this.baseURL+"getAllCarTypes")
  }

  addCarService(car: CarDetail): Observable<any>{
    return this.myhttp.post<any>(this.baseURL+"addCar", car);
  }

  //----------------------------CAR DETAILS ENDS----------------------------

}
