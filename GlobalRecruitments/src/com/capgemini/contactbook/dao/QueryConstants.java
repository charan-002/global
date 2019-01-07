package com.capgemini.contactbook.dao;

public class QueryConstants
{
	
public static final String insertQuery = "insert into enquiry values(enquiries.nextval,?,?,?,?,?)";
	
	public static final String getIdQuery = "select max(enqryid) from enquiry";
	
	public static final String getDetails="select * from enquiry where enqryid=?";

}
