package com.increff.empolyee;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class EmployeeTest {
		@Test
		public void sayHello() throws Exception {
//			System.out.println("hello");
			EmployeeApi api = new EmployeeApi();
//			api.select();
			api.insert();
			ResultSet rs1 = api.select();
			int i=0;
			while(rs1.next())
			{
				i++;
			}
			assertEquals(3, i);
			
		}
} 
