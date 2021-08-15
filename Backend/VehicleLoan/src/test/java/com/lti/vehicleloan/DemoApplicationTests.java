package com.lti.vehicleloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
}
