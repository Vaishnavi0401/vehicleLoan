package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EligibilityCheck;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

	@Override
	public boolean checkEligibility(EligibilityCheck eligibilitycheck) {

//		eligibilitycheck.setAge(30);
//		eligibilitycheck.setTypeOfEmployment("Salaried");
//		eligibilitycheck.setYearlySalary(20000000);
//		eligibilitycheck.setExistingEmi(0);
		
		
//		System.out.println(eligibilitycheck.getAge());
//		System.out.println(eligibilitycheck.getTypeOfEmployment());
//		System.out.println(eligibilitycheck.getYearlySalary());
//		System.out.println(eligibilitycheck.getExistingEmi());
		
		System.out.println("Call of the fn");
		
		if(((eligibilitycheck.getYearlySalary()/12) >= 10000 
				&& (eligibilitycheck.getTypeOfEmployment().equalsIgnoreCase("Salaried") 
						&& eligibilitycheck.getAge() >= 20 && eligibilitycheck.getAge() <= 60)) 
				|| ((eligibilitycheck.getTypeOfEmployment().equalsIgnoreCase("Self Employed") 
						&& eligibilitycheck.getAge() >= 24 && eligibilitycheck.getAge() <= 65 )))
		{
			return true;
		}
		return false;
	}

}
