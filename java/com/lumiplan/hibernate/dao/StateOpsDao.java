package com.lumiplan.hibernate.dao;

import java.util.List;

import com.lumiplan.hibernate.entity.State;

public interface StateOpsDao
{
	public State getState(int stateId);
	
	public int insertState(String name, int cntrId);
	
	public List<State> getStateList(int countryId);
	
	public void deleteStateById(int stateId);

}
