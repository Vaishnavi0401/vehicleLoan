package com.lti.vehicleloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.vehicleloan.layer2.EMICalc;
import com.lti.vehicleloan.layer2.Login;
import com.lti.vehicleloan.layer4.EmiCalculatorService;
import com.lti.vehicleloan.layer4.LoginService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	LoginService loginService;
	@Autowired
	EmiCalculatorService calculator;

	@Test
	void contextLoads() {
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
}
