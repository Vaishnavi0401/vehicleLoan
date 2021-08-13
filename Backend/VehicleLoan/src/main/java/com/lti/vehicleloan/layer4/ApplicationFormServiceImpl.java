package com.lti.vehicleloan.layer4;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.AccountTypeDetail;
import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.TypeOfEmploymentDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer3.ApplicationFormRepository;
import com.lti.vehicleloan.layer3.ApplicationFormRepositoryImpl;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService{

	@Autowired
	ApplicationFormRepositoryImpl appFormRepo;
	
	//Insert a new Address in the database
	@Override
	public Integer insertAddressService(AddressDetail add) {
		System.out.println("Service insert address called");
		Integer addressId = appFormRepo.insertAddress(add);
		return addressId;
	}
	
	//Insert a new User in the database
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
	
	//Select All Users
	@Override
	public List<UserDetail> selectAllUsersService() {
		return appFormRepo.selectAllUsers();
	}
	
	//Select All Cities 
	@Override
	public List<City> selectAllCityService() {
		return appFormRepo.selectAllCities();
	}

	//Select All States
	@Override
	public List<State> selectAllStateService() {
		return appFormRepo.selectAllStates();
	}


	@Override
	public void updateAddressService(UserDetail user, Integer addressId) {
		System.out.println("update address service called");
		appFormRepo.updateAddress(user, addressId);
	}


	//Select All Cars
	@Override
	public List<CarDetail> selectAllCarsService() {
		return appFormRepo.selectAllCars();
	}

	//Insert a New Car in the database
	@Override
	public Integer insertCarService(CarDetail car) {
		System.out.println("Insert Car Service Called");
		System.out.println(car.getCarMaker().getCarMakerId());
		System.out.println(car.getCarType().getCarTypeId());
		if(car.getCarMaker().getCarMakerId() == null) {
			Integer carMakerId = 0;
			carMakerId = this.insertCarMakerService(car.getCarMaker());
			car.getCarMaker().setCarMakerId(carMakerId);
		}
		Integer carId = appFormRepo.insertCar(car);
		return carId;
	}

	//Insert a New Car Maker in the database
	@Override
	public Integer insertCarMakerService(CarMaker carMaker) {
		System.out.println("Car Maker insert Service Called");
		Integer carMakerId = appFormRepo.insertCarMaker(carMaker);
		return carMakerId;
	}

	@Override
	public List<CarMaker> selectAllCarMakerService() {
		return appFormRepo.selectAllCarMakers();
	}

	@Override
	public List<CarType> selectAllCarTypeService() {
		return appFormRepo.selectAllCarTypes();
	}

	@Override
	public List<TypeOfEmploymentDetail> selectAllTypeOfEmploymentService() {
		return appFormRepo.selectAllTypeOfEmployments();
	}

	@Override
	public List<AccountTypeDetail> selectAllAccountTypeDetailService() {
		return appFormRepo.selectAllAccountTypeDetails();
	}

	@Override
	public Integer insertEmploymentDetailService(EmploymentDetail employmentDetail) {
		System.out.println("Service insert Employment called");
		if(employmentDetail != null) {
			Integer employmentId = appFormRepo.insertEmploymentDetail(employmentDetail);
			return employmentId;
		}
		return null;
	}

	@Override
	public Integer insertLoanDetailService(LoanDetail loanDetail) {
		System.out.println("Service insert Loan called");
		if(loanDetail != null) {
			loanDetail.setApplyDate(new Date(System.currentTimeMillis()));
			Integer loanId = appFormRepo.insertLoanDetail(loanDetail);
			return loanId;
		}
		return null;
	}

	

}
