package com.lti.vehicleloan.layer4;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer3.ApplicationFormRepository;
import com.lti.vehicleloan.layer3.ApplicationFormRepositoryImpl;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService{

	@Autowired
	ApplicationFormRepositoryImpl appFormRepo;
	
	@Override
	public Integer insertAddressService(AddressDetail add) {
		System.out.println("Service insert address called");
		Integer addressId = appFormRepo.insertAddress(add);
		return addressId;
	}
	
	
	@Override
	public Integer insertUserService(UserDetail user) {
		System.out.println("Service insert User called");	
		AddressDetail userAddress = user.getAddressDetail();
		Integer userAddressId = this.insertAddressService(userAddress);
		userAddress.setAddressId(userAddressId);
		user.setAddressDetail(userAddress);
		Integer userId = appFormRepo.insertUser(user);
		return userId;
	}
	
	@Override
	public List<UserDetail> selectAllUsersService() {
		return appFormRepo.selectAllUsers();
	}
	
	@Override
	public List<City> selectAllCityService() {
		return appFormRepo.selectAllCities();
	}

	@Override
	public List<State> selectAllStateService() {
		return appFormRepo.selectAllStates();
	}


	@Override
	public void updateAddressService(UserDetail user, Integer addressId) {
		System.out.println("update address service called");
		appFormRepo.updateAddress(user, addressId);
	}


	@Override
	public List<CarDetail> selectAllCarsService() {
		return appFormRepo.selectAllCars();
	}


	@Override
	public Integer insertCarService(CarDetail car) {
		System.out.println("Insert Car Service Called");
		System.out.println(car.getCarMaker().getCarMakerId());
		System.out.println(car.getCarType().getCarTypeId());
		if(car.getCarMaker().getCarMakerId() == null) {
			
		}
		Integer carId = appFormRepo.insertCar(car);
		return carId;
	}

	

}
