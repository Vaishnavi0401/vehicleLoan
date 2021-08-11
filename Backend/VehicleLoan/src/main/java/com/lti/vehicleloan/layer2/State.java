package com.lti.vehicleloan.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "STATE" database table.
 * 
 */
@Entity
@Table(name="\"STATE\"")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STATE_ID")
	private String stateId;

	@Column(name="STATE_NAME")
	private String stateName;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="state", fetch=FetchType.EAGER)
	private List<City> cities;

	public State() {
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setState(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setState(null);

		return city;
	}

}