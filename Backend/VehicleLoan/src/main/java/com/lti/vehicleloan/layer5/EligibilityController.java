package com.lti.vehicleloan.layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.EligibilityCheck;
import com.lti.vehicleloan.layer4.EligibilityCheckService;


@RestController
@CrossOrigin
public class EligibilityController{

	@Autowired
	EligibilityCheckService isEligible;
	
	@PostMapping
	@RequestMapping(path="/CheckEligibility")
	public boolean check(@RequestBody EligibilityCheck eligibility) {
		boolean checking = isEligible.checkingEligibility(eligibility);
		
		System.out.println("Controller of CheckEligibility");
		
		return(checking);
//		if (checking) {
//            return "{\"status\" : \"You are eligible!\"}";
//        }
//        return "{\"status\" : \"You are not eligible \"}";


	}
	
	
}
