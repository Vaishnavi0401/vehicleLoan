package com.lti.vehicleloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.lti.vehicleloan.layer2.AddressDetail;
import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.CarDetail;
import com.lti.vehicleloan.layer2.CarMaker;
import com.lti.vehicleloan.layer2.CarType;
import com.lti.vehicleloan.layer2.City;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.State;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer3.ApplicationFormRepositoryImpl;
import com.lti.vehicleloan.layer4.ApplicationFormServiceImpl;

import java.math.BigInteger;
import com.lti.vehicleloan.layer2.EMICalc;
import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer4.EmiCalculatorService;
import com.lti.vehicleloan.layer4.LoginService;
import com.lti.vehicleloan.layer2.EligibilityCheck;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.UserNotFoundException;
import com.lti.vehicleloan.layer3.UserDashboardRepository;
import com.lti.vehicleloan.layer4.EligibilityCheckService;



@SpringBootTest
class DemoApplicationTests {


	@Autowired
	ApplicationFormServiceImpl appFormService;
	@Autowired
	ApplicationFormRepositoryImpl appFormRepo;


	@Autowired
	LoginService loginService;
	@Autowired
	EmiCalculatorService calculator;


	@Autowired
	EligibilityCheckService eligibilityservice; 
	@Autowired
	private UserDashboardRepository userRepo;

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
	//Object is Created Successfully
	@Test
	void eligibilityObjectTest() {
		System.out.println("Creating Eligibility Check Object");
		EligibilityCheck eligibility  = new EligibilityCheck();
		assertNotNull(eligibility);
		//assertNull(eligibility);
		System.out.println("Eligibility Check Object Created");
	}
	
	//Passing values via Object
	@Test
	void eligibilityFetchTest() {
		System.out.println("Fetching Values");
		EligibilityCheck eligibility  = new EligibilityCheck();
		eligibility.setAge(22);
		eligibility.setTypeOfEmployment("Salaried");
		eligibility.setYearlySalary(30000);
		eligibility.setExistingEmi(10);
		assertNotNull(eligibilityservice.checkingEligibility(eligibility));
		//assertNull(eligibilityservice.checkEligibility(eligibility));
		System.out.println("Values Fetched");
	}

	@Test
	void testEMI() {
		// Object Creation
		EMICalc emiCalc = new EMICalc();
		emiCalc.setPrincipal(500000);
		emiCalc.setRateOfInterest(5);
		emiCalc.setTenure(24);
		assertEquals(26250.0, calculator.emiCalculator(emiCalc));
	}

	@Test
	void testEmiObject() {
		// Object Creation
		EMICalc emiCalc = new EMICalc();
		assertNotNull(emiCalc);
	}

	@Test
	void testLoginObject() {
		Login login = new Login();
		assertNotNull(loginService.validateUser(login));
	}

	@Test
	void testLogin() {
		Login login = new Login();
		login.setEmailId("jatin@gmail.com");
		login.setPassword("test1234");
		assertEquals("Login successfully!", loginService.validateUser(login));
	}

	//Checking the Conditions of Service
	@Test
	void eligibilityServiceTest() {
		System.out.println("Checking Whether User Eligible or Not");
		EligibilityCheck eligibility  = new EligibilityCheck();
		eligibility.setAge(22);
		eligibility.setTypeOfEmployment("Salaried");
		eligibility.setYearlySalary(300000);
		eligibility.setExistingEmi(10);
		assertEquals(true, eligibilityservice.checkingEligibility(eligibility));
		System.out.println("User is Eligible");
		//assertEquals(false, eligibilityservice.checkEligibility(eligibility));
		//System.out.println("User is not Eligible");
	}
	
	@BeforeEach
	void loadDB() {
		System.out.println("Connecting to the Database");
	}
	
	@AfterEach
	void closeDB() {
		System.out.println("Disconecting from the Database");
	}
	
	@Test
	void userDetailObjectTest() {
		System.out.println("Creating User Detail Object");
		UserDetail user = new UserDetail();
		assertNotNull(user);
		//assertNull(user);
		System.out.println("User Detail Object Created");

	}
		
	
	@Test
	void loanDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	@Test
	void userDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	@Test
	void carDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			CarDetail c = l.getCarDetail();
			System.out.println("Car Model is " + c.getModel());
			System.out.println("Car's on Road Price is " + c.getOnroadPrice());
			System.out.println("Car's Showroom Price is " + c.getShowroomPrice());
			System.out.println("Vehicle Domain is " + c.getVehicleDomain());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@Test
	void carMakerDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			CarDetail c = l.getCarDetail();
			System.out.println("Car Model is " + c.getModel());
			System.out.println("Car's on Road Price is " + c.getOnroadPrice());
			System.out.println("Car's Showroom Price is " + c.getShowroomPrice());
			System.out.println("Vehicle Domain is " + c.getVehicleDomain());
			CarMaker cm = c.getCarMaker();
			System.out.println("Car Maker is " + cm.getCarMaker());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@Test
	void carTypeDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			CarDetail c = l.getCarDetail();
			System.out.println("Car Model is " + c.getModel());
			System.out.println("Car's on Road Price is " + c.getOnroadPrice());
			System.out.println("Car's Showroom Price is " + c.getShowroomPrice());
			System.out.println("Vehicle Domain is " + c.getVehicleDomain());
			CarType ct = c.getCarType();
			System.out.println("Car Type is " + ct.getCarType());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}


	@Test
	void AddressDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			AddressDetail a = u.getAddressDetail();
			System.out.println("Address is " + a.getAddress());
			System.out.println("Pin Code is "+ a.getPincode());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Test
	void cityDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			AddressDetail a = u.getAddressDetail();
			System.out.println("Address is " + a.getAddress());
			System.out.println("Pin Code is "+ a.getPincode());
			City c = a.getCity();
			System.out.println("City Name is " + c.getCityName());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	@Test
	void stateDetailsTest() {
		List<LoanDetail> loan = new ArrayList<LoanDetail>();
		try {
			loan = userRepo.selectUserById(301);
			for(LoanDetail l: loan) {
			System.out.println("Loan Id is "+l.getLoanId());
			System.out.println("Loan Applied on " + l.getApplyDate());
			System.out.println("Loan Approval Status " + l.getApproval());
			System.out.println("EMI is " + l.getEmi());
			System.out.println("Existing EMI is " + l.getExistingEmi());
			System.out.println("Principal Amount is " + l.getPrincipalAmount());
			System.out.println("Rate of Interest is " + l.getRateOfInterest());
			System.out.println("Tenure is " + l.getTenure());
			UserDetail u = l.getUserDetail();
			System.out.println("User Id is " + u.getUserId());
			System.out.println("User Name is " + u.getName());
			System.out.println("User's Age is " + u.getAge());
			System.out.println("User's Gender is " + u.getGender());
			System.out.println("User's Email id is " + u.getEmail());
			System.out.println("User's Mobile No. is " + u.getMobileNumber());
			System.out.println("===================================");
			AddressDetail a = u.getAddressDetail();
			System.out.println("Address is " + a.getAddress());
			System.out.println("Pin Code is "+ a.getPincode());
			City c = a.getCity();
			System.out.println("City Name is " + c.getCityName());
			State s = c.getState();
			System.out.println("State Name is " + s.getStateName());
			}
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
