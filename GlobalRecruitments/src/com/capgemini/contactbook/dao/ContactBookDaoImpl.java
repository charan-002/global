package com.capgemini.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.utility.JdbcUtility;

import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements ContactBookDao {
	
	Connection conn = null;
	PreparedStatement statement = null;
	static Logger logger = Logger.getLogger(ContactBookDaoImpl.class);
	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException {
		logger.info("in getting enquiry details  mehtod..");

		conn = JdbcUtility.getConnection();
		System.out.println("hi");
		try {
			statement = conn
					.prepareStatement(QueryConstants.getDetails);
			statement.setInt(1, EnquiryID);
			ResultSet resultSet=null;
			
			 resultSet = statement.executeQuery();
							
			
			resultSet.next();
			EnquiryBean eb1 = new EnquiryBean();

			eb1.setEnqryId(resultSet.getInt(1));
			eb1.setfName(resultSet.getString(2));
			eb1.setlName(resultSet.getString(3));
			eb1.setContactNo(Long.toString(resultSet.getLong(4)));
			eb1.setpDomain(resultSet.getString(5));
			eb1.setpLocation(resultSet.getString(6));

			return eb1;

		} catch (SQLException e) {
			logger.error("in enquiry details method ex is: " + e.getMessage());
			throw new ContactBookException(" sorry no details found");
		}

		
		
	}

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException
	{
		
		logger.info("in add patient  deatils  method..");
		conn= JdbcUtility.getConnection();

		try {
			statement = conn.prepareStatement(QueryConstants.insertQuery);
			statement.setString(1, enqry.getfName());
			statement.setString(2, enqry.getlName());
			statement.setLong(3, Long.parseLong(enqry.getContactNo()));
			statement.setString(4, enqry.getpDomain());
			statement.setString(5, enqry.getpLocation());

			int r = statement.executeUpdate();

			statement = conn.prepareStatement(QueryConstants.getIdQuery);
			ResultSet rs = statement.executeQuery();
			rs.next();
			int id=rs.getInt(1);
			return id;

		} catch (SQLException e) {
			logger.error("statement not created..");
			e.printStackTrace();
			throw new ContactBookException("statement not created");

		}


		
	}
	
	

}
