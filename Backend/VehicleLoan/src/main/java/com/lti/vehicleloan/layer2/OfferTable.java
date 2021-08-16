package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the OFFER_TABLE database table.
 * 
 */
@Entity
@Table(name="OFFER_TABLE")
@NamedQuery(name="OfferTable.findAll", query="SELECT o FROM OfferTable o")
public class OfferTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OFFER_ID")
	private Integer offerId;

	@Column(name="OFFER_AMOUNT")
	private BigDecimal offerAmount;

	@Column(name="OFFER_RATE")
	private BigDecimal offerRate;

	@Column(name="OFFER_TENURE")
	private Integer offerTenure;
	
	@Column(name="OFFER_EMI")
	private double offerEmi;

	public double getOfferEmi() {
		return offerEmi;
	}

	public void setOfferEmi(double offerEmi) {
		this.offerEmi = offerEmi;
	}

	public OfferTable() {
	}

	public Integer getOfferId() {
		return this.offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public BigDecimal getOfferAmount() {
		return this.offerAmount;
	}

	public void setOfferAmount(BigDecimal offerAmount) {
		this.offerAmount = offerAmount;
	}

	public BigDecimal getOfferRate() {
		return this.offerRate;
	}

	public void setOfferRate(BigDecimal offerRate) {
		this.offerRate = offerRate;
	}

	public Integer getOfferTenure() {
		return this.offerTenure;
	}

	public void setOfferTenure(Integer offerTenure) {
		this.offerTenure = offerTenure;
	}

}