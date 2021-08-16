package com.lti.vehicleloan.admindashboard.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.OfferTable;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.AdvancedUserDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.EmploymentDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.LoanDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.UserDetailNotFoundException;
import com.lti.vehicleloan.layer3.AdminDashboardRepositoryImpl;
import com.lti.vehicleloan.layer3.LoanOfferRepositoryImpl;
import com.lti.vehicleloan.layer4.AdminDashboardService;
import com.lti.vehicleloan.layer4.LoanOfferServiceImpl;

@SpringBootTest
public class AdminDashboardTests {

	@Autowired
	AdminDashboardRepositoryImpl admRepo = new AdminDashboardRepositoryImpl();
	
	@Autowired
	AdminDashboardService admServ;
	
	@Autowired
	LoanOfferRepositoryImpl loanOfferRepo=new LoanOfferRepositoryImpl();
	
	@Autowired
	LoanOfferServiceImpl loanServ;
	
	@Test                                                        //Test1
	void getAllLoanDetailsTest() {
		System.out.println("Getting all loan details...");
		List<LoanDetail> loanDetail=admRepo.selectAllLoanDetails();
		assertNotNull(loanDetail);
		System.out.println("loanDetails "+loanDetail.size());
		for(LoanDetail loan: loanDetail) {
			System.out.println("Loan Details: "+loan);
		}
		
	}
	
	@Test 														//Test2
	void deleteLoanDetailTest() //throws LoanDetailNotFoundException
	{
		System.out.println("Deleting loan details by loan id");
		try {
			admRepo.deleteLoanDetail(505);
			System.out.println("Loan Details deleted for loan id");
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test                                                        //Test3
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
	
	
	@Test 														//Test4
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
	
	@Test                                             			//Test5
	void selectAllAdvancedUserDetailTest()
	{
		System.out.println("Getting loan details by approval ");
		List<AdvancedUserDetail> advancedUserDetailList=admRepo.selectAllAdvancedUserDetail();
		assertNotNull(advancedUserDetailList);
		
	}
	
	@Test                                             			//Test6
	void getUserDetailByUserIdTest()
	{
		System.out.println("geting User Detail By UserId Test ");
		UserDetail userDetailByUserId;
		try {
			userDetailByUserId = admRepo.getUserDetailByUserId(301);
			assertNotNull(userDetailByUserId);
		} catch (UserDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test                                             			//Test7
	void selectAdvancedUserDetailByUserIdTest()
	{
		System.out.println("Selecting Advanced User Details by UserID Test");
		AdvancedUserDetail advancedUserDetail;
		try {
			advancedUserDetail = admRepo.selectAdvancedUserDetailByUserId(301);
			
			assertNotNull(advancedUserDetail);
		} catch (AdvancedUserDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test                                             			//Test8
	void selectAdvancedUserDetailByLoanId()
	{
		System.out.println("Selecting Advanced User Detail By UserId ");
		try {
			AdvancedUserDetail advancedUserDetail=admRepo.selectAdvancedUserDetailByLoanId(501);
			assertNotNull(advancedUserDetail);
		} catch (AdvancedUserDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test                                             			//Test9
	void getEmploymentDetailsByLoanIdTest()
	{
		System.out.println("Selecting Employment Details by Loan Id ");
		try {
			List<EmploymentDetail> employmentDetailsByLoanId=admRepo.getEmploymentDetailsByLoanId(502);
			assertNotNull(employmentDetailsByLoanId);
		} catch (EmploymentDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test                                             			//Test10
	void selectAllUserDetailsTest()
	{
		System.out.println("selecting All User Details Test");
		List<UserDetail> userDetails=admRepo.selectAllUserDetails();
		assertNotNull(userDetails);
	}
	
	//loan offers test
	
	
	
//=================================Not Working============================================//

	//update
	//getUserDetailsByLoanId
	
	@Test
	void updateApprovalTest()                //Test
	{
		System.out.println("Updating loan details ");
		try {
			LoanDetail foundLoanDetail=admRepo.selectLoanDetailbyloanId(501);
			foundLoanDetail.setApproval("no");
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//selectLoanDetailbyloanId.find(LoanDetail.class, 501 );
	}
	
	@Test 
	void updateApprovalTest2()
	{
		System.out.println("Updating loan details ");
		try {
			LoanDetail foundLoanDetail=admRepo.selectLoanDetailbyloanId(502);
			admRepo.updateApproval(foundLoanDetail);
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	@Test														//Test11
//	void getAllLoanOffersTest()
//	{
//		System.out.println("Getting loan offers");
//		List<OfferTable> offerTable=loanOfferRepo.getOfferTable(500000.0000000000000000000000);
//		assertNotNull(offerTable);
//	}
	
	
	
	
	
	
}
