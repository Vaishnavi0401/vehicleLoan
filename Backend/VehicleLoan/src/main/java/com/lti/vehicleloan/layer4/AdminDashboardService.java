package com.lti.vehicleloan.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.vehicleloan.layer2.LoanDetail;

@Service
public interface AdminDashboardService {

	List<LoanDetail> selectAllLoanDetailsService();
	void updateApprovalService(LoanDetail loanDetail);
	void deleteLoanDetailService(int loanId);
	LoanDetail selectLoanDetailbyloanIdService(int loanId);
	List<LoanDetail> selectLoanDetailbyApprovalService(String approval);
}
