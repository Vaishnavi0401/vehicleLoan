package com.lti.vehicleloan.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.LoanDetailNotFoundException;

@Repository
public interface AdminDashboardRepository {

	List<LoanDetail> selectAllLoanDetails();
	void updateApproval(LoanDetail loanDetail) throws LoanDetailNotFoundException;

	void deleteLoanDetail(int loanId) throws LoanDetailNotFoundException;

	LoanDetail selectLoanDetailbyloanId(int loanId) throws LoanDetailNotFoundException;
	
	List<LoanDetail> selectLoanDetailbyApproval(String approval) throws LoanDetailNotFoundException;

}
