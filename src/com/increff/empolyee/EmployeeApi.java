package com.increff.empolyee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class EmployeeApi {
	
	private static final Logger  logger = Logger.getLogger(EmployeeApi.class);
	private Connection con;
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		
		
	}
	
	public EmployeeApi() throws Exception {
		BasicConfigurator.configure();
		Properties props = new Properties();
		InputStream inStream = new FileInputStream("employee.properties");
		props.load(inStream);

		Class.forName(props.getProperty("jdbc.driver"));
		con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
				props.getProperty("jdbc.password"));
	}
	
	public ResultSet select() throws SQLException {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from employee");
		return rs;
//		while (rs.next()) {
//			logger.info("sdkja");
//			logger.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + "fjlsdj fjdj lsj");
//		}
	}

	public void insert() throws SQLException {
		Statement stat = con.createStatement();
//		ResultSet rs = stat.executeQuery("select * from employee");
		for (int i = 0; i < 3; i++) {
			int id = 19 + i;
			int age = 20 + i;
			String name = "emp" + i;
			logger.info("insert into employee values(" + id + " ,'" + name + "'," + age + ")");
			stat.executeUpdate("insert into employee values(" + id + " ,'" + name + "'," + age + ")");
		}
	}

}
