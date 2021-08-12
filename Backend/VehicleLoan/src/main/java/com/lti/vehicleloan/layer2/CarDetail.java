package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CAR_DETAILS database table.
 * 
 */
@Entity
@Table(name="CAR_DETAILS")
@NamedQuery(name="CarDetail.findAll", query="SELECT c FROM CarDetail c")
public class CarDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CAR_ID")
	private Integer carId;

	@Column(name="CAR_MODEL_IMAGE")
	private String carModelImage;

	private String model;

	@Column(name="ONROAD_PRICE")
	private BigDecimal onroadPrice;

	@Column(name="SHOWROOM_PRICE")
	private BigDecimal showroomPrice;

	@Column(name="VEHICLE_DOMAIN")
	private String vehicleDomain;

	//bi-directional many-to-one association to CarMaker
	@ManyToOne
	@JoinColumn(name="CAR_MAKER_ID")
	private CarMaker carMaker;

	//bi-directional many-to-one association to CarType
	@ManyToOne
	@JoinColumn(name="CAR_TYPE_ID")
	private CarType carType;

	//bi-directional many-to-one association to LoanDetail
	@OneToMany(mappedBy="carDetail", fetch=FetchType.EAGER)
	private List<LoanDetail> loanDetails;

	public CarDetail() {
	}

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarModelImage() {
		return this.carModelImage;
	}

	public void setCarModelImage(String carModelImage) {
		this.carModelImage = carModelImage;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getOnroadPrice() {
		return this.onroadPrice;
	}

	public void setOnroadPrice(BigDecimal onroadPrice) {
		this.onroadPrice = onroadPrice;
	}

	public BigDecimal getShowroomPrice() {
		return this.showroomPrice;
	}

	public void setShowroomPrice(BigDecimal showroomPrice) {
		this.showroomPrice = showroomPrice;
	}

	public String getVehicleDomain() {
		return this.vehicleDomain;
	}

	public void setVehicleDomain(String vehicleDomain) {
		this.vehicleDomain = vehicleDomain;
	}

	public CarMaker getCarMaker() {
		return this.carMaker;
	}

	public void setCarMaker(CarMaker carMaker) {
		this.carMaker = carMaker;
	}

	public CarType getCarType() {
		return this.carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

//	public List<LoanDetail> getLoanDetails() {
//		return this.loanDetails;
//	}

	public void setLoanDetails(List<LoanDetail> loanDetails) {
		this.loanDetails = loanDetails;
	}

//	public LoanDetail addLoanDetail(LoanDetail loanDetail) {
//		getLoanDetails().add(loanDetail);
//		loanDetail.setCarDetail(this);
//
//		return loanDetail;
//	}

//	public LoanDetail removeLoanDetail(LoanDetail loanDetail) {
//		getLoanDetails().remove(loanDetail);
//		loanDetail.setCarDetail(null);
//
//		return loanDetail;
//	}

}