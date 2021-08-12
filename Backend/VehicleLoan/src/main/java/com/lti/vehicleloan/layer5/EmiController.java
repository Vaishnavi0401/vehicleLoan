package com.lti.vehicleloan.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.EMICalc;
import com.lti.vehicleloan.layer4.EmiCalculatorService;

@RestController
@CrossOrigin
public class EmiController {
	
	@Autowired
	EmiCalculatorService emiCalculatorService;
	
	@RequestMapping(path="/calculateEmi")
	public double emiCalculator(@RequestBody EMICalc emiCalc) {
		double emi = emiCalculatorService.emiCalculator(emiCalc);
		System.out.println("Hello");
		return emi;
	}
}
