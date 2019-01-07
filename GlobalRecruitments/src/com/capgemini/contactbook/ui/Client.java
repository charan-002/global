package com.capgemini.contactbook.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.igate.contactbook.bean.EnquiryBean;
 import com.capgemini.contactbook.exception.*;


public class Client {
	static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args)
	{
		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("log4j file loaded...");
		logger.info("inside main method");
		
		ContactBookService service = new ContactBookServiceImpl();

		Scanner scanner = new Scanner(System.in);

		// patientService service = new patientServiceImpl();
		while (true)

		{
			System.out
					.println("***********Global Recruitments**********");
			System.out
					.println("_____________________________________________________");
			System.out.println("1. Enter enquiry details");
			System.out.println("2. view enquiry details on ID");
			System.out.println("0. EXIT");
			System.out.println("Please enter a choice:");
			int option=0;
			try
			{
			 option = scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter only digits:");
			}

			switch (option) {

			case 1:
				scanner.nextLine();
				EnquiryBean eb = new EnquiryBean();

				System.out.println("enter first name:");
				String fname = scanner.nextLine();
				eb.setfName(fname);
				
				System.out.println("enter last name:");
				
				 String lname = scanner.nextLine();
				 eb.setlName(lname);
				
				 System.out.println("enter contact number:");
				 String contactno=scanner.nextLine();
				 
				eb.setContactNo(contactno);
				System.out.println("enter preferred domain:");
				String pdomain=scanner.nextLine();
				eb.setpDomain(pdomain);

				System.out.println("enter prefered location");
				String plocation=scanner.nextLine();
				

				eb.setpLocation(plocation);

				try {

					boolean result = service.isValidEnquiry(eb);

					if (result) {
						int id = service.addEnquiry(eb);
						System.out.println("Thank you: "+eb.getfName()+" "+eb.getlName()+"your unique id is:"
										+id);
					}

				} catch (ContactBookException e) {
					System.err.println(e.getMessage());
				}

				break;
			case 2:
				System.out.println("Enter the enquiry no");
				int id=0;
				try{
					id = scanner.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("enter only digits");
				}
				
				
				
				EnquiryBean eb1;
				try {
					eb1 = service.getEnquiryDetails(id);
					System.out.println(eb1);

				} catch (ContactBookException e) {

					System.err.println(e.getMessage());
				}
				break;
			case 0:
				System.out.println("Thank you");
				System.exit(0);
				break;

			default:
				break;
			}

		}

	

	}

}
