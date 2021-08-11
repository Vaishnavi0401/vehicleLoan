package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CAR_TYPE database table.
 * 
 */
@Entity
@Table(name="CAR_TYPE")
@NamedQuery(name="CarType.findAll", query="SELECT c FROM CarType c")
public class CarType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_TYPE_ID")
	private Integer carTypeId;

	@Column(name="CAR_TYPE")
	private String carType;

	//bi-directional many-to-one association to CarDetail
	@OneToMany(mappedBy="carType", fetch=FetchType.EAGER)
	private List<CarDetail> carDetails;

	public CarType() {
	}

	public Integer getCarTypeId() {
		return this.carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public List<CarDetail> getCarDetails() {
		return this.carDetails;
	}

	public void setCarDetails(List<CarDetail> carDetails) {
		this.carDetails = carDetails;
	}

	public CarDetail addCarDetail(CarDetail carDetail) {
		getCarDetails().add(carDetail);
		carDetail.setCarType(this);

		return carDetail;
	}

	public CarDetail removeCarDetail(CarDetail carDetail) {
		getCarDetails().remove(carDetail);
		carDetail.setCarType(null);

		return carDetail;
	}

}