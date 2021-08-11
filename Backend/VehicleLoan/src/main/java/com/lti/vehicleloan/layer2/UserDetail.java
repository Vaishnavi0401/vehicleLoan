package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

	private Integer age;

	private String email;

	private String gender;

	@Column(name="MOBILE_NUMBER")
	private BigInteger mobileNumber;

	private String name;

	private String password;

	@Column(name="ROLE")
	private Integer role;

	//bi-directional many-to-one association to EmploymentDetail
	@OneToMany(mappedBy="userDetail")
	private List<EmploymentDetail> employmentDetails;

	//bi-directional many-to-one association to LoanDetail
	@OneToMany(mappedBy="userDetail")
	private List<LoanDetail> loanDetails;

	//bi-directional one-to-one association to AdvancedUserDetail
	@OneToOne(mappedBy="userDetail")
	private AdvancedUserDetail advancedUserDetail;

	//bi-directional one-to-one association to AddressDetail
	@OneToOne()
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID")
	private AddressDetail addressDetail;

	public UserDetail() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigInteger getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

//	public List<EmploymentDetail> getEmploymentDetails() {
//		return this.employmentDetails;
//	}

	public void setEmploymentDetails(List<EmploymentDetail> employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

//	public EmploymentDetail addEmploymentDetail(EmploymentDetail employmentDetail) {
//		getEmploymentDetails().add(employmentDetail);
//		employmentDetail.setUserDetail(this);
//
//		return employmentDetail;
//	}

//	public EmploymentDetail removeEmploymentDetail(EmploymentDetail employmentDetail) {
//		getEmploymentDetails().remove(employmentDetail);
//		employmentDetail.setUserDetail(null);
//
//		return employmentDetail;
//	}

//	public List<LoanDetail> getLoanDetails() {
//		return this.loanDetails;
//	}

	public void setLoanDetails(List<LoanDetail> loanDetails) {
		this.loanDetails = loanDetails;
	}

//	public LoanDetail addLoanDetail(LoanDetail loanDetail) {
//		getLoanDetails().add(loanDetail);
//		loanDetail.setUserDetail(this);
//
//		return loanDetail;
//	}

//	public LoanDetail removeLoanDetail(LoanDetail loanDetail) {
//		getLoanDetails().remove(loanDetail);
//		loanDetail.setUserDetail(null);
//
//		return loanDetail;
//	}

//	public AdvancedUserDetail getAdvancedUserDetail() {
//		return this.advancedUserDetail;
//	}

	public void setAdvancedUserDetail(AdvancedUserDetail advancedUserDetail) {
		this.advancedUserDetail = advancedUserDetail;
	}

	public AddressDetail getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(AddressDetail addressDetail) {
		this.addressDetail = addressDetail;
	}

}