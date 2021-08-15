package com.lti.vehicleloan.layer2;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESS_DETAILS database table.
 * 
 */
@Entity
@Table(name="ADDRESS_DETAILS")
@NamedQuery(name="AddressDetail.findAll", query="SELECT a FROM AddressDetail a")
public class AddressDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private Integer addressId;

	private String address;

	private Long pincode;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private City city;

	//bi-directional one-to-one association to UserDetail
	@OneToOne(mappedBy="addressDetail")
	private UserDetail userDetail;

	public AddressDetail() {
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return this.pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

//	public UserDetail getUserDetail() {
//		return this.userDetail;
//	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}