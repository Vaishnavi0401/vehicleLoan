package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_OF_EMPLOYMENT_DETAILS database table.
 * 
 */
@Entity
@Table(name="TYPE_OF_EMPLOYMENT_DETAILS")
@NamedQuery(name="TypeOfEmploymentDetail.findAll", query="SELECT t FROM TypeOfEmploymentDetail t")
public class TypeOfEmploymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TYPE_OF_EMP_ID")
	private Integer typeOfEmpId;

	@Column(name="TYPE_OF_EMPLOYMENT")
	private String typeOfEmployment;

	//bi-directional many-to-one association to EmploymentDetail
	@OneToMany(mappedBy="typeOfEmploymentDetail", fetch=FetchType.EAGER)
	private List<EmploymentDetail> employmentDetails;

	public TypeOfEmploymentDetail() {
	}

	public Integer getTypeOfEmpId() {
		return this.typeOfEmpId;
	}

	public void setTypeOfEmpId(Integer typeOfEmpId) {
		this.typeOfEmpId = typeOfEmpId;
	}

	public String getTypeOfEmployment() {
		return this.typeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}

//	public List<EmploymentDetail> getEmploymentDetails() {
//		return this.employmentDetails;
//	}

	public void setEmploymentDetails(List<EmploymentDetail> employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

//	public EmploymentDetail addEmploymentDetail(EmploymentDetail employmentDetail) {
//		getEmploymentDetails().add(employmentDetail);
//		employmentDetail.setTypeOfEmploymentDetail(this);
//
//		return employmentDetail;
//	}

//	public EmploymentDetail removeEmploymentDetail(EmploymentDetail employmentDetail) {
//		getEmploymentDetails().remove(employmentDetail);
//		employmentDetail.setTypeOfEmploymentDetail(null);
//
//		return employmentDetail;
//	}

}