package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EMICalc;

@Service
public class EmiCalculatorServiceImpl implements EmiCalculatorService {
	public double emiCalculator(EMICalc emiCalc) {
		System.out.println("Calling the function ");
		
		double P = emiCalc.getPrincipal() ;
		double R = emiCalc.getRateOfInterest();
		double n = emiCalc.getTenure();
		
		R = R/(12*100);
		
		//E= P*R[ ((1+R)^n)/ (((1+R)^n)-1)]
		double emi = P*R*(Math.pow((1+R),n)/ (Math.pow((1+R),n)-1));
							
		return emi;	
	}
}


