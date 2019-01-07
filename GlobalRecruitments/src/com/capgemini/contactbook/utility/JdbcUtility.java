package com.capgemini.contactbook.utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.contactbook.exception.ContactBookException;




public class JdbcUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws ContactBookException {

		Properties properties = new Properties();

		File file = new File("resources/db.properties");
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new ContactBookException("File not exists");
		}

		try {
			properties.load(inputStream);

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String userName = properties.getProperty("username");
			String password = properties.getProperty("pass");

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException e) {
				throw new ContactBookException("class not loaded..");
			} catch (SQLException e) {
				throw new ContactBookException("connection not established");
			}

		} catch (IOException e) {
			throw new ContactBookException("no data persent in fiole to read");
		}
		return connection;

	}

}
