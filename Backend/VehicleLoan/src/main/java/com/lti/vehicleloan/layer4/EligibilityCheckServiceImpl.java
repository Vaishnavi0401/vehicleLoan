package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EligibilityCheck;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

	@Override
	public boolean checkingEligibility(EligibilityCheck eligibility) {

//		eligibilitycheck.setAge(30);
//		eligibilitycheck.setTypeOfEmployment("Salaried");
//		eligibilitycheck.setYearlySalary(20000000);
//		eligibilitycheck.setExistingEmi(0);
		
		
//		System.out.println(eligibilitycheck.getAge());
//		System.out.println(eligibilitycheck.getTypeOfEmployment());
//		System.out.println(eligibilitycheck.getYearlySalary());
//		System.out.println(eligibilitycheck.getExistingEmi());
		
		System.out.println("Call of the function");
		
		//Condition 1: If the User is Salaried and the Age is lesser than or equal to 21 then User is not eligible
		//Condition 2: If the User is Salaried and the Age is greater than 21 then User is eligible
		//Condition 3: If the User is Salaried and the Age is greater than 60 then User is not eligible
		//Condition 4: If the User is Salaried and the Age is lesser or equal to than 60 then User is eligible
		//Condition 5: If the User is Salaried and the Age is within the limit and User's Annual Salary is lesser than 240000 then User is not eligible
		//Condition 6: If the User is Salaried and the Age is within the limit and User's Annual Salary is greater than 240000 then User is eligible
		
		//Condition 7: If the User is Self Employed and the Age is lesser than or equal to 18 then User is not eligible
		//Condition 8: If the User is Self Employed and the Age is greater than 18 then User is eligible
		//Condition 9: If the User is Self Employed and the Age is greater than 65 then User is not eligible
		//Condition 10: If the User is Self Employed and the Age is lesser or equal to than 65 then User is eligible		
		//Condition 11: If the User is Self Employed and the Age is within the limit and User's Annual Salary is lesser than 180000 then User is not eligible
		//Condition 12: If the User is Self Employed and the Age is within the limit and User's Annual Salary is greater than 180000 then User is eligible
				
		
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
