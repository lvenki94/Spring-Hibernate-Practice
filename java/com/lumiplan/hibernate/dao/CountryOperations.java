package com.lumiplan.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.lumiplan.hibernate.entity.Country;

public class CountryOperations extends SessionFactoryInitializer implements CountryOpsDao
{ 

	/**
	 * Gets the Country Object of the Specified Country ID
	 * @param countryId for the Required Country Object
	 * @return Country Object of the Country ID Specified
	 */
	
	public Country getCountryObj(int countryId)
	{
		//System.out.println(factory);
		Country ret = null;
		
		Session sess = openSession();
		
		Criteria crt = sess.createCriteria(Country.class);
		crt.add(Restrictions.eq("cntrID",countryId));
		
		List<Country> cntrLst = crt.list();
		
		if(cntrLst.size() == 1)
		{
			ret = cntrLst.get(0);
		}
		else
		{
			ret = null;
		}
		
		//sess.close();
		//factory.close();
		
		return ret;
	}
	
	/**
	 * Returns List of all Countries in the Table
	 * @return A List of all countries in the Table
	 */
	public List<Country> getCountryList()
	{
		Session sess = openSession();
		
		Criteria crt = sess.createCriteria(Country.class);
		
		return crt.list();
		
	}
}
