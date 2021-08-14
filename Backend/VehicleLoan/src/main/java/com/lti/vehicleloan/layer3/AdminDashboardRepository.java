package com.lti.vehicleloan.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.exceptions.AdvancedUserDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.EmploymentDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.LoanDetailNotFoundException;
import com.lti.vehicleloan.layer2.exceptions.UserDetailNotFoundException;
import com.lti.vehicleloan.layer2.UserDetail;

@Repository
public interface AdminDashboardRepository {

	List<LoanDetail> selectAllLoanDetails();
	void updateApproval(LoanDetail loanDetail) throws LoanDetailNotFoundException;

	void deleteLoanDetail(int loanId) throws LoanDetailNotFoundException;

	LoanDetail selectLoanDetailbyloanId(int loanId) throws LoanDetailNotFoundException;
	
	List<LoanDetail> selectLoanDetailbyApproval(String approval) throws LoanDetailNotFoundException;
	
	List<AdvancedUserDetail> selectAllAdvancedUserDetail();
	
	UserDetail getUserDetailByUserId(int userId) throws UserDetailNotFoundException;
	
	AdvancedUserDetail selectAdvancedUserDetailByUserId(int userId) throws AdvancedUserDetailNotFoundException;
	
	AdvancedUserDetail selectAdvancedUserDetailByLoanId(int loanId) throws AdvancedUserDetailNotFoundException;
	
	
	List<UserDetail> getUserDetailsByLoanId(int loanId);
	
	List<EmploymentDetail> getEmploymentDetailsByLoanId(int loanId) throws EmploymentDetailNotFoundException;
	
	

}
