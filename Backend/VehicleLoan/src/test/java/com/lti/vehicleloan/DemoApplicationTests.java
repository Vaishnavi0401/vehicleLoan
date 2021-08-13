package com.lti.vehicleloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.vehicleloan.layer2.EligibilityCheck;
import com.lti.vehicleloan.layer4.EligibilityCheckService;
import com.lti.vehicleloan.layer4.EligibilityCheckServiceImpl;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	EligibilityCheckService eligibilityservice; 
	
	@Test
	void contextLoads() {
	}
	
	//Object is Created Successfully
	@Test
	void objectTest() {
		System.out.println("Creating EligibilityCheck Object");
		EligibilityCheck eligibility  = new EligibilityCheck();
		assertNotNull(eligibility);
		//assertNull(eligibility);
		System.out.println("Eligibility Check Object Created");
	}
	
	//Passing values via Object
	@Test
	void fetchTest() {
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

	//Checking the Conditions of Service
	@Test
	void eligibilityTest() {
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
	
}
