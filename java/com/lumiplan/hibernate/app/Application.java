package com.lumiplan.hibernate.app;

import java.util.List;
import java.util.ListIterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lumiplan.hibernate.entity.*;
import com.lumiplan.hibernate.dao.*;

public class Application
{
	
	static ApplicationContext cxt = new ClassPathXmlApplicationContext("spring/application-config.xml");
	
	static CountryOpsDao cntrOpObj = (CountryOperations)cxt.getBean("countryOps");
	
	static StateOpsDao stateDet = (StateDetails)cxt.getBean("stateDets");
	
	
	
	public static void main(String args[])
	{	
		
		getCountries();
		//getStateDetails(1);
		//getCountry(3);
		//insertState("Orissa",1);
		//getStates(1);
		//deleteStateById(12);
		
	}
	
	/**
	 * Gets the State Object of the given State ID and Lists out all its Details
	 * @param stateId StateId of the Required State Object
	 */
	
	public static void getStateDetails(int stateId)
	{
		State stateObj = new State();
		try
		{
			stateObj = stateDet.getState(stateId);
	
			System.out.println(stateObj.getStaName());
			System.out.println("Belongs to "+stateObj.getCountry().getCntrName());
			
			List<City> ctyLst = stateObj.getCities();
			ListIterator<City> lstItr = ctyLst.listIterator();
			
			System.out.println("Cities in the State:");		
			while(lstItr.hasNext())
			{
				System.out.println(lstItr.next().getCtyName());
			}
		}catch(Exception e)
		{
			System.out.println("State Not Found");
		}
	}
	
	/**
	 * Gets the Country Object with the Specified Country ID
	 * @param cntrId Country ID of the required Country Object
	 */
	public static void getCountry(int cntrId)
	{
		
		Country countryObj = cntrOpObj.getCountryObj(cntrId);
		
		if(countryObj != null)
		{
			System.out.println(countryObj.getCntrName());
		}
		else
		{
			System.out.println("Country Not Found");
		}
	}
	
	/**
	 * Inserts State into the state table with the name and country id
	 * @param name Name of the State
	 * @param countryId Country to which the state belongs to
	 */
	
	public static void insertState(String name, int countryId)
	{
		int stId = stateDet.insertState(name, countryId);
		
		System.out.println(stId);
	}
	
	/**
	 * Gets the list of all the states in the specified country
	 * @param countryId to get the list of states in it.
	 */
	
	public static void getStates(int countryId)
	{
		
		List<State> stateLst = stateDet.getStateList(countryId);
		if(stateLst != null)
		{
			ListIterator<State> stateItr = stateLst.listIterator();
			
			while(stateItr.hasNext())
			{
				System.out.println(stateItr.next().getStaName());
			}
			
		}
		else
		{
			System.out.println("Country Does not Exist or there are no States in the Country");
		}
		
	}
	
	/**
	 * Deletes state with the given State Id
	 * @param stateId of the required state Object to be Deleted
	 */
	
	public static void deleteStateById(int stateId)
	{
		
		stateDet.deleteStateById(stateId);
		
		System.out.println("State Succesfully Deleted");
	}
	
	/**
	 * Prints the list of all Countries in the Table
	 */
	
	public static void getCountries()
	{
		List<Country> lstCntr = cntrOpObj.getCountryList();
		
		if(lstCntr.size() != 0)
		{
			ListIterator<Country> cntrItr = lstCntr.listIterator();
			while(cntrItr.hasNext())
			{
				System.out.println(cntrItr.next().getCntrName());
			}
		}
		else
		{
			System.out.println("No Countries in the Table");
		}
	}
}
