package com.lti.vehicleloan.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;

@Repository
public interface ApplicationFormRepository {
	
	Integer insertAddress(AddressDetail add);
	AddressDetail selectAddress(int userId);
	void updateAddress(UserDetail user, Integer addressId);
	
	Integer insertUser(UserDetail user);
	List<UserDetail> selectAllUsers();
	
	Integer insertCarMaker(CarMaker carMaker);
	
	Integer insertCar(CarDetail car);
	List<CarDetail> selectAllCars();
	
	City selectCity(String cityId);
	List<City> selectAllCities();
	State selectState(String stateId);
	List<State> selectAllStates();
}
