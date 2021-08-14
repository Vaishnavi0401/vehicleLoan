package com.lti.vehicleloan.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.exceptions.UserDetailNotFoundException;

@Service
public interface AdminDashboardService {

	List<LoanDetail> selectAllLoanDetailsService();
	void updateApprovalService(LoanDetail loanDetail);
	void deleteLoanDetailService(int loanId);
	LoanDetail selectLoanDetailbyloanIdService(int loanId);
	List<LoanDetail> selectLoanDetailbyApprovalService(String approval);
	List<AdvancedUserDetail> selectAllAdvancedUserDetailService();
	AdvancedUserDetail getAdvancedUserDetailByUserIdService(int userId) ;
	AdvancedUserDetail getAdvancedUserDetailByLoanIdService(int loanId);
	List<EmploymentDetail> getEmploymentDetailByLoanIdService(int loanId);
}
