package com.capgemini.contactbook.dao;

import com.capgemini.contactbook.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookDao {
	
	
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException;
	public int  addEnquiry(EnquiryBean enqry) throws ContactBookException;
	
}
