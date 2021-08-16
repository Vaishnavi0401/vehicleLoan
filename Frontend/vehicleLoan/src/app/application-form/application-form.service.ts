import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountTypeDetail } from '../pojos/AccountTypeDetail';
import { ApplicationFormDTO } from '../pojos/ApplicationFormDTO';
import { CarDetail } from '../pojos/CarDetail';
import { CarMaker } from '../pojos/CarMaker';
import { CarType } from '../pojos/CarType';
import { City } from '../pojos/City';
import { State } from '../pojos/State';
import { TypeOfEmploymentDetail } from '../pojos/TypeOfEmploymentDetail';
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

  //----------------------------EMPLOYMENT DETAILS----------------------------

  getAllTypeOfEmploymentDetailService():Observable<TypeOfEmploymentDetail[]>{
    return this.myhttp.get<TypeOfEmploymentDetail[]>(this.baseURL+"getAllTypeOfEmploymentDetails")
  }

  getAllAccountTypeDetailService():Observable<AccountTypeDetail[]>{
    return this.myhttp.get<AccountTypeDetail[]>(this.baseURL+"getAllAccountTypeDetails")
  }


  //----------------------------EMPLOYMENT DETAILS ENDS----------------------------

  //----------------------------APPLICATION FORM DETAILS STARTS---------------------------

  addApplicationForm(applicationForm: ApplicationFormDTO):Observable<any>{
    return this.myhttp.post<any>(this.baseURL+"addApplicationForm", applicationForm);
  }

  //----------------------------APPLICATION FORM DETAILS ENDS---------------------------

//----------------------------FILE UPLOAD DETAILS ENDS----------------------------
  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.baseURL}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.myhttp.request(req);
  }
//----------------------------FILE UPLOAD DETAILS ENDS----------------------------
}
