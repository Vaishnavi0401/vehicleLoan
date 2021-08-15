package com.lti.vehicleloan.layer4;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.EligibilityCheck;

@Service
public interface EligibilityCheckService {

	public boolean checkingEligibility(EligibilityCheck eligibility);
}
