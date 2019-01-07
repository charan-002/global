package com.capgemini.contactbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;

import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl implements ContactBookService{

	
	ContactBookDao contactbookdao=new ContactBookDaoImpl();

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException 
	{
		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!validateFirstName(enqry.getfName()))
			{
			list.add(" first name should start with capital letter & length should be greater than 6 ");
		}
		if (!validateLastName(enqry.getlName()))
		{
			list.add(" last name  length should be atleast 6 charachter ");
		}
		if (!validateContacNo(enqry.getContactNo())) {
			list.add("enter vlaid contact number ");
		}
		if(!validatePLocation(enqry.getpLocation()))
		{
			list.add("enter valid location with min 4 charahters ");
			
		}
	if(!validatePDomain(enqry.getpDomain()))
		{
			list.add("enter valid domain with min 4 charahters ");
			
		}
		
		if (!list.isEmpty()) {
			result = false;
			throw new ContactBookException(list + "");
		} else {
			result = true;
		}
		return result;
	}
	
	
	public boolean validateFirstName(String fName) {

		String fnameRegEx = "[A-Z]{1}[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(fnameRegEx);
		Matcher matcher = pattern.matcher(fName);
		return matcher.matches();
	}
	public boolean validateLastName(String lName) {

		String lnameRegEx = "[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(lnameRegEx);
		Matcher matcher = pattern.matcher(lName);
		return matcher.matches();
	}
	public boolean validateContacNo(String contactNo) {

		String phoneregEx = "[0-9]{10}";
		Pattern pattern = Pattern.compile(phoneregEx);
		Matcher matcher = pattern.matcher(contactNo);
		return matcher.matches();
	}

	public boolean validatePLocation(String pLocation) {

		String locationRegEx = "[a-zA-Z]{3,}";
		Pattern pattern = Pattern.compile(locationRegEx);
		Matcher matcher = pattern.matcher(pLocation);
		return matcher.matches();
	}
	public boolean validatePDomain(String pDomain)
	{
		String domainRegEx = "[a-zA-Z]{3,}";
		Pattern pattern = Pattern.compile(domainRegEx);
		Matcher matcher = pattern.matcher(pDomain);
		return matcher.matches();
	}

		
	

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID)
			throws ContactBookException {
		
		return contactbookdao.getEnquiryDetails(EnquiryID);
	}

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		
		return contactbookdao.addEnquiry(enqry);
	}
	
	
	
}
