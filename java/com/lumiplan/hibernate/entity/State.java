package com.lumiplan.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table (name = "state")
public class State
{
	@Id @GeneratedValue
	@Column (name = "sta_id")
	int staID;
	
	@Column (name = "sta_name")
	String staName;
	
	@ManyToOne
	@JoinColumn(name = "sta_cntr_id")
	Country country;
	
	@OneToMany(mappedBy = "state", fetch = FetchType.EAGER)
	List<City> cities;
	
	public State()
	{
		
	}
	
	public State(int id, String name, Country cntr)
	{
		this.staID = id;
		this.staName = name;
		this.country = cntr;
	}
	
	public State(String name, Country cntr)
	{
		this.staName = name;
		this.country = cntr;
	}

	public int getStaID() {
		return staID;
	}

	public void setStaID(int staID) {
		this.staID = staID;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [staID=" + staID + ", staName=" + staName + ", country="
				+ country + ", cities=" + cities + "]";
	}
	
}
