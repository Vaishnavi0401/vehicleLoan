package com.lti.vehicleloan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer3.ApplicationFormRepositoryImpl;
import com.lti.vehicleloan.layer4.ApplicationFormServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationFormServiceImpl appFormService;
	
	@Autowired
	ApplicationFormRepositoryImpl appFormRepo;
	
	
	@Test
	void contextLoads() {
	}
	
//	@Test 
//	void insertState() {
//		System.out.println("Creating a state");
//		State state = new State();
//		state.setStateId("1400");
//		state.setStateName("myState");
//		assertNotNull(state);
//		System.out.println("Successfuly created state");
//	}
//	
//	@Test
//	void insertCity(){
//		System.out.println("Creating a state");
//		State state = new State();
//		state.setStateId("1400");
//		state.setStateName("myState");
//		assertNotNull(state);
//		System.out.println("Creating a city");
//		City city = new City();
//		city.setCityId("1120");
//		city.setCityName("myCity");
//		city.setState(state);
//		assertNotNull(city);
//		System.out.println("Successfuly created city");
//	}
	
	@Test
	void insertAddress() {
		City foundCity = appFormRepo.selectCity("102"); //Existing City
		assertNotNull(foundCity);
		System.out.println(foundCity.getCityName());
		System.out.println("Creating an address");
		AddressDetail address = new AddressDetail();
		address.setAddress("new xyz address");
		address.setPincode((long) 400090);
		address.setCity(foundCity);
		assertNotNull(address);
		appFormRepo.insertAddress(address);
		System.out.println("Successfuly created address");
	}
	
	@Test
	void insertUser() {
		System.out.println("Creating an address");
		AddressDetail foundAddress = appFormRepo.selectAddress(190);
		assertNotNull(foundAddress);
		System.out.println("Successfuly created address");
		System.out.println("Creating a user");
		UserDetail user = new UserDetail();
		user.setName("Jatin Acharya");
		user.setEmail("test@gmail.com");
		user.setPassword("1234");
		user.setMobileNumber(BigInteger.valueOf(98989898));
		user.setGender("M");
		user.setAge(20);
		user.setAddressDetail(foundAddress);
		user.setRole(1);
		assertNotNull(user);
		System.out.println("Successfuly created user");
		assertNotNull(appFormRepo.insertUser(user));
		System.out.println("Successfuly added the user");
	}
	
	void insertLoanDetail() {}
	
	@Test
	void insertAdvancedUserDetail() {
		UserDetail foundUser = appFormRepo.selectUser(301); 
		AdvancedUserDetail advancedUserDetail = new AdvancedUserDetail();
		advancedUserDetail.setAadhaarCard("aadhar path");
		advancedUserDetail.setPanCard("pan path");
		advancedUserDetail.setPhoto("set photo");
		advancedUserDetail.setSalarySlip("salaray slip path ");
		advancedUserDetail.setUserDetail(foundUser);
//		System.out.println("ad");
		appFormRepo.insertAdvancedUserDetail(advancedUserDetail);
	}
}
