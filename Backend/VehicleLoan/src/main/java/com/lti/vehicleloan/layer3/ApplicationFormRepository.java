package com.lti.vehicleloan.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.AccountTypeDetail;
import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.TypeOfEmploymentDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.AccountTypeDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.CarMakerNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.CarNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.CarTypeNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.CityNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.StateNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.TypeOfEmploymentNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.UserNotFoundException;

@Repository
public interface ApplicationFormRepository {
	
	Integer insertAddress(AddressDetail add);
	AddressDetail selectAddress(int addressId);
	void updateAddress(UserDetail user, Integer addressId);
	
	Integer insertUser(UserDetail user);
	UserDetail selectUser(int userId);
	List<UserDetail> selectAllUsers() throws UserNotFoundException;
	
	Integer insertCarMaker(CarMaker carMaker);
	Integer insertCar(CarDetail car);
	List<CarMaker> selectAllCarMakers() throws CarMakerNotFoundException;
	List<CarType> selectAllCarTypes() throws CarTypeNotFoundException;
	List<CarDetail> selectAllCars() throws CarNotFoundException;
	
	City selectCity(String cityId);
	List<City> selectAllCities() throws CityNotFoundException; 
	
	State selectState(String stateId);
	List<State> selectAllStates() throws StateNotFoundException;
	
	List<TypeOfEmploymentDetail> selectAllTypeOfEmployments() throws TypeOfEmploymentNotFoundException;
	List<AccountTypeDetail> selectAllAccountTypeDetails() throws AccountTypeDetailNotFoundException;
	Integer insertEmploymentDetail(EmploymentDetail employmentDetail);
	List<EmploymentDetail> selectEmploymentDetails();
	
	Integer insertLoanDetail(LoanDetail loanDetail);
	
	Integer insertAdvancedUserDetail(AdvancedUserDetail advancedUserDetail);

}
