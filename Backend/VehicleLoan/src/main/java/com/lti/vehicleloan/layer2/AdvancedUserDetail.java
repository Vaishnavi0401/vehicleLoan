package com.lti.vehicleloan.layer2;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADVANCED_USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="ADVANCED_USER_DETAILS")
@NamedQuery(name="AdvancedUserDetail.findAll", query="SELECT a FROM AdvancedUserDetail a")
public class AdvancedUserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADVANCED_DETAILS_ID")
	private Integer advancedDetailsId;

	@Column(name="AADHAAR_CARD")
	private String aadhaarCard;

	@Column(name="PAN_CARD")
	private String panCard;

	private String photo;

	@Column(name="SALARY_SLIP")
	private String salarySlip;

	//bi-directional one-to-one association to UserDetail
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserDetail userDetail;

	public AdvancedUserDetail() {
	}

	public Integer getAdvancedDetailsId() {
		return this.advancedDetailsId;
	}

	public void setAdvancedDetailsId(Integer advancedDetailsId) {
		this.advancedDetailsId = advancedDetailsId;
	}

	public String getAadhaarCard() {
		return this.aadhaarCard;
	}

	public void setAadhaarCard(String aadhaarCard) {
		this.aadhaarCard = aadhaarCard;
	}

	public String getPanCard() {
		return this.panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSalarySlip() {
		return this.salarySlip;
	}

	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}