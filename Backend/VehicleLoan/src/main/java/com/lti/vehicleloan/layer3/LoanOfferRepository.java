package com.lti.vehicleloan.layer3;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.OfferTable;

@Repository
public interface LoanOfferRepository {
	
	List<OfferTable> getOfferTable(BigDecimal amount,BigDecimal rate);
	
}
