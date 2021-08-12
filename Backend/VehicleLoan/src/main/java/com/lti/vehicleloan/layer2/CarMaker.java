package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CAR_MAKER database table.
 * 
 */
@Entity
@Table(name="CAR_MAKER")
@NamedQuery(name="CarMaker.findAll", query="SELECT c FROM CarMaker c")
public class CarMaker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_MAKER_ID")
	private Integer carMakerId;

	@Column(name="CAR_MAKER")
	private String carMaker;

	//bi-directional many-to-one association to CarDetail
	@OneToMany(mappedBy="carMaker", fetch=FetchType.EAGER)
	private List<CarDetail> carDetails;

	public CarMaker() {
	}

	public Integer getCarMakerId() {
		return this.carMakerId;
	}

	public void setCarMakerId(Integer carMakerId) {
		this.carMakerId = carMakerId;
	}

	public String getCarMaker() {
		return this.carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

//	public List<CarDetail> getCarDetails() {
//		return this.carDetails;
//	}

	public void setCarDetails(List<CarDetail> carDetails) {
		this.carDetails = carDetails;
	}

//	public CarDetail addCarDetail(CarDetail carDetail) {
//		getCarDetails().add(carDetail);
//		carDetail.setCarMaker(this);
//
//		return carDetail;
//	}

//	public CarDetail removeCarDetail(CarDetail carDetail) {
//		getCarDetails().remove(carDetail);
//		carDetail.setCarMaker(null);
//
//		return carDetail;
//	}

}