package com.lumiplan.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lumiplan.hibernate.entity.Country;

public class SessionFactoryInitializer
{
	SessionFactory factory;
	
	public void initFactory()
	{
		
		
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session openSession()
	{
		System.out.println(factory);
		return this.factory.openSession();
	}
}
