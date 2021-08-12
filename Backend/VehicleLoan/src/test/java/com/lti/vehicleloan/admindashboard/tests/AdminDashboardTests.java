package com.lti.vehicleloan.admindashboard.tests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.LoanDetailNotFoundException;
import com.lti.vehicleloan.layer3.AdminDashboardRepositoryImpl;
import com.lti.vehicleloan.layer4.AdminDashboardService;

@SpringBootTest
public class AdminDashboardTests {

	@Autowired
	AdminDashboardRepositoryImpl admRepo = new AdminDashboardRepositoryImpl();
	
	@Autowired
	AdminDashboardService admServ;
	
	@Test                                                        //Test1
	void getAllLoanDetailsTest() {
		System.out.println("Getting all loan details...");
		List<LoanDetail> loanDetail=admRepo.selectAllLoanDetails();
		System.out.println("loanDetails "+loanDetail.size());
		for(LoanDetail loan: loanDetail) {
			System.out.println("Loan Details: "+loan);
		}
		
	}
	
	@Test                                                        //Test2
	void selectLoanDetailbyloanIdTest() //throws LoanDetailNotFoundException //throws LoanDetailNotFoundException{
		{
		System.out.println("Getting loan details by loan id");
		LoanDetail loanDetail;
		try {
			loanDetail = admRepo.selectLoanDetailbyloanId(502);	
			System.out.println("Loan Details by loan Id:"+loanDetail);

		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test 														//Test3
	void selectLoanDetailbyApprovalTest() //throws LoanDetailNotFoundException
	{
		System.out.println("Getting loan Details by loan approval");
		List<LoanDetail> loanDetailList;
		try {
			loanDetailList = admRepo.selectLoanDetailbyApproval("yes");
			for(LoanDetail loan: loanDetailList) {
				System.out.println("Loan Details by approval: "+loan);
			}
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test 														//Test4
	void deleteLoanDetailTest() //throws LoanDetailNotFoundException
	{
		System.out.println("Deleting loan details by loan id");
		try {
			admRepo.deleteLoanDetail(504);
			System.out.println("Loan Details deleted for loan id");
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
