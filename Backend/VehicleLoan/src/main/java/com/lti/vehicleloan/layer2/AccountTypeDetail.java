package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT_TYPE_DETAILS database table.
 * 
 */
@Entity
@Table(name="ACCOUNT_TYPE_DETAILS")
@NamedQuery(name="AccountTypeDetail.findAll", query="SELECT a FROM AccountTypeDetail a")
public class AccountTypeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_TYPE_ID")
	private Integer accountTypeId;

	@Column(name="ACCOUNT_TYPE")
	private String accountType;

	//bi-directional many-to-one association to EmploymentDetail
	@OneToMany(mappedBy="accountTypeDetail", fetch=FetchType.EAGER)
	private List<EmploymentDetail> employmentDetails;

	public AccountTypeDetail() {
	}

	public Integer getAccountTypeId() {
		return this.accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

//	public List<EmploymentDetail> getEmploymentDetails() {
//		return this.employmentDetails;
//	}

	public void setEmploymentDetails(List<EmploymentDetail> employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

	public EmploymentDetail addEmploymentDetail(EmploymentDetail employmentDetail) {
		getEmploymentDetails().add(employmentDetail);
		employmentDetail.setAccountTypeDetail(this);

		return employmentDetail;
	}

	public EmploymentDetail removeEmploymentDetail(EmploymentDetail employmentDetail) {
		getEmploymentDetails().remove(employmentDetail);
		employmentDetail.setAccountTypeDetail(null);

		return employmentDetail;
	}

}