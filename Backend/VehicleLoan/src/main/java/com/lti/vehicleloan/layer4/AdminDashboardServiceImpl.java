package com.lti.vehicleloan.layer4;

import java.util.List;

import javax.persistence.FetchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer2.exceptions.AdvancedUserDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.EmploymentDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.LoanDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.UserDetailNotFoundException;
import com.lti.vehicleloan.layer3.AdminDashboardRepositoryImpl;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {

	@Autowired
	
	AdminDashboardRepositoryImpl adminRepo;
	
	public List<LoanDetail> selectAllLoanDetailsService() {

		//business logic here 
		System.out.println("Loan Details Service Impl: Layer 4");
		return adminRepo.selectAllLoanDetails();
	
	}

	
	public void updateApprovalService(LoanDetail loanDetail) {

		System.out.println("update Approval Service.. method");
		String message="Loan Detail not found";
		boolean updated=false;
		
		try {
			adminRepo.updateApproval(loanDetail);
			updated=true;
			message="Loan Updated";
			System.out.println("update Approval Service deleted");
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(foundLoanDetail!=null) {
//			entityManager.persist(foundLoanDetail);
//		}
//		else
//			throw new LoanDetailNotFoundException("Loan detail not found "+loanId);
//		System.out.println("Loan Detail Updated");
//		return adminRepo.updateApproval(LoanDetail loanDetail);
	}


	@Override
	public void deleteLoanDetailService(int loanId) {
		
		System.out.println("deleteLoanDetailService().. method");
		String message="Loan Detail not found";
		boolean deleted=false;
		try {
			adminRepo.deleteLoanDetail(loanId);
			deleted=true;
			message="Loan Detail Deleted";
			System.out.println("Delete Loan Detail Service deleted");
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public LoanDetail selectLoanDetailbyloanIdService(int loanId) {

		System.out.println("selectLoanDetailbyloanIdService().. method");
//		String message="Loan id not found";
//		boolean foundByLoanId=false;
		try {
			return adminRepo.selectLoanDetailbyloanId(loanId);
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}


	
	public List<LoanDetail> selectLoanDetailbyApprovalService(String approval) {

		System.out.println("selectLoanDetailbyApprovalService()..method");
		
		try {
			return  adminRepo.selectLoanDetailbyApproval(approval);
			
		} catch (LoanDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	
	public List<AdvancedUserDetail> selectAllAdvancedUserDetailService() {

		System.out.println("selectAllAdvancedUserDetailService() method from layer 4");

		return adminRepo.selectAllAdvancedUserDetail();
	}


	
	public AdvancedUserDetail getAdvancedUserDetailByUserIdService(int userId)  {

		System.out.println("getAdvancedUserDetailByUserIdService() method from layer 4");
		try {
			return adminRepo.selectAdvancedUserDetailByUserId(userId);
		} catch (AdvancedUserDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	public AdvancedUserDetail getAdvancedUserDetailByLoanIdService(int loanId) {

		System.out.println("getAdvancedUserDetailByLoanIdService() method from layer 4");
		try {
			return adminRepo.selectAdvancedUserDetailByLoanId(loanId);
		} catch (AdvancedUserDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	public List<EmploymentDetail> getEmploymentDetailByLoanIdService(int loanId) {
		
		System.out.println("getEmploymentDetailByLoanIdService() method from layer 4");
		try {
			return adminRepo.getEmploymentDetailsByLoanId(loanId);
		} catch (EmploymentDetailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	public List<UserDetail> selectAllUserDetailsService() {
		System.out.println("selectAllUserDetailsService method from layer 4");
		return adminRepo.selectAllUserDetails();
	}
	
	

}
