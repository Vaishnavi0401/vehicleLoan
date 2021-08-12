package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EligibilityCheck;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

	@Override
	public boolean checkEligibility(EligibilityCheck eligibility) {

//		eligibilitycheck.setAge(30);
//		eligibilitycheck.setTypeOfEmployment("Salaried");
//		eligibilitycheck.setYearlySalary(20000000);
//		eligibilitycheck.setExistingEmi(0);
		
		
//		System.out.println(eligibilitycheck.getAge());
//		System.out.println(eligibilitycheck.getTypeOfEmployment());
//		System.out.println(eligibilitycheck.getYearlySalary());
//		System.out.println(eligibilitycheck.getExistingEmi());
		
		System.out.println("Call of the fn");
		
		if(eligibility.getAge() >= 21 && eligibility.getAge() <= 60 
				&& (eligibility.getTypeOfEmployment().equalsIgnoreCase("Salaried") && eligibility.getYearlySalary() >= 240000)
				|| (eligibility.getAge() >= 18 && eligibility.getAge() <= 65 
				&& (eligibility.getTypeOfEmployment().equalsIgnoreCase("Self Employed") && eligibility.getYearlySalary() >= 180000)))
		{
			return true;
		}
		return false;
	}

}
