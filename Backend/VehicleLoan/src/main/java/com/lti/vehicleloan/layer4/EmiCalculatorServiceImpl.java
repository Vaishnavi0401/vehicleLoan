package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EMICalc;

@Service
public class EmiCalculatorServiceImpl implements EmiCalculatorService {
	public double emiCalculator(EMICalc emiCalc) {
		System.out.println("Calling the function ");
//		emiCalc.setPrincipal(500000);
//		emiCalc.setRateOfInterest(5);
//		emiCalc.setTenure(24);
		
		double emi = ((emiCalc.getPrincipal()*(emiCalc.getRateOfInterest())/100) * (Math.pow((1 + (emiCalc.getRateOfInterest())/100), (emiCalc.getTenure()/12)))/(Math.pow((1+(emiCalc.getRateOfInterest())/100), ((emiCalc.getTenure()/12)-1))));
		return emi;
		
	}
}

//E= P*R[ ((1+R)^n)/ (((1+R)^n)-1)]

