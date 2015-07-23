package com.lumiplan.hibernate.dao;

import java.util.List;

import com.lumiplan.hibernate.entity.Country;

public interface CountryOpsDao 
{
	
	public Country getCountryObj(int countryId);
	
	public List<Country> getCountryList();

}
