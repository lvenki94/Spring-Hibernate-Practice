package com.lumiplan.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table (name = "city")
public class City 
{
	@Id @GeneratedValue
	@Column (name = "cty_id")
	int ctyID;
	
	@Column (name = "cty_name")
	String ctyName;
	
	@ManyToOne
	@JoinColumn(name = "cty_sta_id")
	State state;
	
	public City()
	{
		
	}
	
	public City(int id, String name, State sta)
	{
		ctyID = id;
		ctyName = name;
		state = sta;
	}

	public City(String name, State sta, Country  cntr)
	{
		ctyName = name;
		state = sta;
	}
	
	public int getCtyID() {
		return ctyID;
	}

	public void setCtyID(int ctyID) {
		this.ctyID = ctyID;
	}

	public String getCtyName() {
		return ctyName;
	}

	public void setCtyName(String ctyName) {
		this.ctyName = ctyName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [ctyID=" + ctyID + ", ctyName=" + ctyName + ", state=" + state + "]";
	}
	
}
