package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CITY_ID")
	private String cityId;

	@Column(name="CITY_NAME")
	private String cityName;

	//bi-directional many-to-one association to AddressDetail
	@OneToMany(mappedBy="city", fetch=FetchType.EAGER)
	private List<AddressDetail> addressDetails;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	public City() {
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

//	public List<AddressDetail> getAddressDetails() {
//		return this.addressDetails;
//	}

	public void setAddressDetails(List<AddressDetail> addressDetails) {
		this.addressDetails = addressDetails;
	}
//
//	public AddressDetail addAddressDetail(AddressDetail addressDetail) {
//		getAddressDetails().add(addressDetail);
//		addressDetail.setCity(this);
//
//		return addressDetail;
//	}
//
//	public AddressDetail removeAddressDetail(AddressDetail addressDetail) {
//		getAddressDetails().remove(addressDetail);
//		addressDetail.setCity(null);
//
//		return addressDetail;
//	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}