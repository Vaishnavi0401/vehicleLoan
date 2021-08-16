package com.lti.vehicleloan.layer4;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.OfferTable;
import com.lti.vehicleloan.layer3.LoanOfferRepositoryImpl;

@Service
public class LoanOfferServiceImpl implements LoanOfferService{

	@Autowired
	
	LoanOfferRepositoryImpl loanRepo;
	
	public List<OfferTable> getAllLoanOffers(BigDecimal amount) {

		
		System.out.println("Loan Offers Service Impl: Layer 4");
		return loanRepo.getOfferTable(amount);
	}

}
