package com.igate.contactbook.bean;

public class EnquiryBean {
	private int enqryId;
	private String fName;
	private String lName;
	
	private String contactNo;
	private String pLocation;
	private String pDomain;
	public int getEnqryId() {
		return enqryId;
	}
	public void setEnqryId(int enqryId) {
		this.enqryId = enqryId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public String getpDomain() {
		return pDomain;
	}
	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}
	
	
	public String toString()
	{
		return "enquiry id is:"+enqryId+"\n first name is:"+fName+"\n last name is:"+lName+"\n contact no is:"+contactNo+"\n preferred location is:"+pLocation+"\n preferred doamin"+pDomain;
				
	}

}
