package com.lti.vehicleloan.layer2;

public class ApplicationFormDto {
	
	UserDetail userDetail;
	CarDetail carDetail;
	EmploymentDetail employmentDetail;
	LoanDetail loanDetail;
	AdvancedUserDetail advancedUserDetail;
	
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public CarDetail getCarDetail() {
		return carDetail;
	}
	public void setCarDetail(CarDetail carDetail) {
		this.carDetail = carDetail;
	}
	public EmploymentDetail getEmploymentDetail() {
		return employmentDetail;
	}
	public void setEmploymentDetail(EmploymentDetail employmentDetail) {
		this.employmentDetail = employmentDetail;
	}
	public LoanDetail getLoanDetail() {
		return loanDetail;
	}
	public void setLoanDetail(LoanDetail loanDetail) {
		this.loanDetail = loanDetail;
	}
	public AdvancedUserDetail getAdvancedUserDetail() {
		return advancedUserDetail;
	}
	public void setAdvancedUserDetail(AdvancedUserDetail advancedUserDetail) {
		this.advancedUserDetail = advancedUserDetail;
	}
}
