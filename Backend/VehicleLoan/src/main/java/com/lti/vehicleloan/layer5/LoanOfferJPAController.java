package com.lti.vehicleloan.layer5;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.OfferTable;
import com.lti.vehicleloan.layer4.LoanOfferServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/loan")

public class LoanOfferJPAController {
	@Autowired
	LoanOfferServiceImpl loanService;
	public LoanOfferJPAController()
	{
		System.out.println("LoanOfferJPAController() constructed");
	}

	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllLoanOffers/{amount}")
	public List<OfferTable> getAllLoanOffers(@PathVariable BigDecimal amount){
		return loanService.getAllLoanOffers(amount);
	}
}









