package com.virtusa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.virtusa.dao.EmployeesDAO;
import com.virtusa.dao.JDBCEmployeesDAOImpl;
import com.virtusa.entities.Employees;

class TestJDBCEmployeesDAOImpl {

	@Test
	public void testGetAllEmployees_positive() {
		EmployeesDAO employeesDAO=
				new JDBCEmployeesDAOImpl();
		
		try {
			List<Employees> employeesList=
					employeesDAO.getAllEmployees();
			assertEquals(true,employeesList.size()>0);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
		
		
	}

}
