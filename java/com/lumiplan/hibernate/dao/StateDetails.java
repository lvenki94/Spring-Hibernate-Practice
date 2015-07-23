package com.lumiplan.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lumiplan.hibernate.entity.Country;
import com.lumiplan.hibernate.entity.State;

public class StateDetails extends SessionFactoryInitializer implements StateOpsDao
{
	/**
	 * Get the State Object with the given stateId
	 * @param stateId Id of the State Object Required
	 * @return State Object with the specified state Id
	 */
	
	public State getState(int stateId)
	{
		Session sess = openSession();
		
		Criteria crt = sess.createCriteria(State.class,"state");
		crt.add(Restrictions.eq("staID",stateId));
		
		List<State> stateLst = crt.list();
		
		//factory.close();
		sess.close();
		
		return stateLst.get(0);
	}
	
	/**
	 * Inserts state with the name and sets the country object with the specified country Id.
	 * @param name Specified State Name.
	 * @param cntrId To get the country object of the given country Id.
	 * @return Returns the State id after insertion.
	 */
	
	public int insertState(String name, int cntrId)
	{
		Session sess = openSession();
		Transaction tx;
		
		State stateObj = new State();
		
		CountryOperations cntrOpsObj = new CountryOperations();
		
		Country cntrObj  = cntrOpsObj.getCountryObj(cntrId);
		
		if(cntrObj != null)
		{
			stateObj = new State(name, cntrObj);
		}
		else
		{
			stateObj.setStaName(name);
		}
		
		tx = sess.beginTransaction();
		sess.save(stateObj);
		tx.commit();
		
		sess.close();
		
		return stateObj.getStaID();
	}
	
	/**
	 * Lists all the states inside the specified Country Object
	 * @param countryId Country Id of the required Country Object
	 * @return A List of all states within the specified Country Object
	 */
	
	public List<State> getStateList(int countryId)
	{
		System.out.println(factory);
		Session sess = openSession();
		
		List<State> ret = null;
		
		CountryOperations countryOpsObj = new CountryOperations();
		
		Country countryObj = countryOpsObj.getCountryObj(countryId);
		
		
		if(countryObj != null)
		{
			if(countryObj.getStates().size() != 0)
			{
				ret = countryObj.getStates();
			}
			else
			{
				ret = null;
			}
		}
		
		sess.close();
		return ret;
	}
	
	/**
	 * Deletes a state with the specified state Id
	 * @param stateId Id of the required state to be deleted
	 */
	
	public void deleteStateById(int stateId)
	{
		Session sess = openSession();
		Transaction tx;
		
		State stateObj = getState(stateId);
		Country cntrObj = stateObj.getCountry();

		List<State> staLst = getStateList(cntrObj.getCntrID());
		staLst.remove(stateObj);
		
		tx = sess.beginTransaction();
		sess.delete(stateObj);
		tx.commit();
		sess.close();
	}
}
