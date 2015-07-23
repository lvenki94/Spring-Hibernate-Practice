package com.lumiplan.hibernate.servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lumiplan.hibernate.dao.CountryOpsDao;
import com.lumiplan.hibernate.dao.CountryOperations;
import com.lumiplan.hibernate.entity.Country;

import java.io.*;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet 
{
	static ApplicationContext cxt = new ClassPathXmlApplicationContext("spring/application-config.xml");
	
	static CountryOpsDao cntrOpObj = (CountryOperations)cxt.getBean("countryOps");
	
	/*static StateOpsDao stateDet = (StateDetails)cxt.getBean("stateDets");*/
	
	/*@Autowired
	private CountryOpsDao countryOps;*/
	

	public void init()throws ServletException
	{
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>First Page</title></head>");
		out.println("<body>First Servlet Page <ul>");
		
		
		List<Country> lstCntr = cntrOpObj.getCountryList();
		
		if(lstCntr.size() != 0)
		{
			ListIterator<Country> cntrItr = lstCntr.listIterator();
			while(cntrItr.hasNext())
			{
				out.println("<li>"+cntrItr.next().getCntrName()+"</li>");
			}	
		}
		else
		{
			out.println("No Countries in the Table");
		}
		
		out.println("</ul></body></html>");
		
		
	}
	
	public void destroy()
	{
		
	}

	
}
