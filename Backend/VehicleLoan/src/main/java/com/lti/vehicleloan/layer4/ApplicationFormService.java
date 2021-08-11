package com.lti.vehicleloan.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;

@Service
public interface ApplicationFormService {

	Integer insertAddressService(AddressDetail add);
	void updateAddressService(UserDetail user, Integer addressId);
	
	Integer insertUserService(UserDetail user);
	List<UserDetail> selectAllUsersService();
	
	Integer insertCarService(CarDetail car);
	Integer insertCarMakerService(CarMaker carMaker);
	List<CarDetail> selectAllCarsService();
	
	List<City> selectAllCityService();
	List<State> selectAllStateService();
	
}
