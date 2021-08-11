package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LOAN_DETAILS database table.
 * 
 */
@Entity
@Table(name="LOAN_DETAILS")
@NamedQuery(name="LoanDetail.findAll", query="SELECT l FROM LoanDetail l")
public class LoanDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_ID")
	private Integer loanId;

	@Temporal(TemporalType.DATE)
	@Column(name="APPLY_DATE")
	private Date applyDate;

	private String approval;

	private BigDecimal emi;

	@Column(name="EXISTING_EMI")
	private BigDecimal existingEmi;

	@Column(name="PRINCIPAL_AMOUNT")
	private BigDecimal principalAmount;

	@Column(name="RATE_OF_INTEREST")
	private BigDecimal rateOfInterest;

	private Integer tenure;

	//bi-directional many-to-one association to CarDetail
	@ManyToOne
	@JoinColumn(name="CAR_ID")
	private CarDetail carDetail;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetail userDetail;

	public LoanDetail() {
	}

	public Integer getLoanId() {
		return this.loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getApproval() {
		return this.approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public BigDecimal getEmi() {
		return this.emi;
	}

	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}

	public BigDecimal getExistingEmi() {
		return this.existingEmi;
	}

	public void setExistingEmi(BigDecimal existingEmi) {
		this.existingEmi = existingEmi;
	}

	public BigDecimal getPrincipalAmount() {
		return this.principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public BigDecimal getRateOfInterest() {
		return this.rateOfInterest;
	}

	public void setRateOfInterest(BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getTenure() {
		return this.tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public CarDetail getCarDetail() {
		return this.carDetail;
	}

	public void setCarDetail(CarDetail carDetail) {
		this.carDetail = carDetail;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}