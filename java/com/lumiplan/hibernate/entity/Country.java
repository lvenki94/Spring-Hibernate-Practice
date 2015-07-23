package com.lumiplan.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import java.util.List;

@Entity
@Table (name = "country")
public class Country 
{
	@Id @GeneratedValue
	@Column (name = "cntr_id")
	int cntrID;
	
	@Column (name = "cntr_name")
	String cntrName;
	
	@OneToMany(mappedBy = "country")
	List<State> states;
	
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public Country()
	{
		
	}
	
	public Country(int id, String name)
	{
		cntrID = id;
		cntrName = name;
	}
	
	public Country(String name)
	{
		cntrName = name;
	}

	public int getCntrID() {
		return cntrID;
	}

	public void setCntrID(int cntrID) {
		this.cntrID = cntrID;
	}

	public String getCntrName() {
		return cntrName;
	}

	public void setCntrName(String cntrName) {
		this.cntrName = cntrName;
	}

	@Override
	public String toString() {
		return "Country [cntrID=" + cntrID + ", cntrName=" + cntrName
				+ ", states=" + states + "]";
	}
	
}
