package com.lti.vehicleloan.layer4;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.OfferTable;

@Service
public interface LoanOfferService {

	List<OfferTable> getAllLoanOffers(BigDecimal amount);
	
	
}
