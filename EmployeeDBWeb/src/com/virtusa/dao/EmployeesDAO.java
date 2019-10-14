package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.Employees;
import com.virtusa.model.ManagersModel;

/**
 * 
 * @author admin
 * Declaration of data operations for business Entity Employees
 *
 */
public interface EmployeesDAO {
	
	public List<Employees> getAllEmployees()throws ClassNotFoundException, SQLException;
	public Employees getDeparmentName(int employeeId)throws ClassNotFoundException, SQLException;
	public boolean storeEmployeeDetails(Employees employees)throws ClassNotFoundException, SQLException;
	public boolean updateEmployee(Employees employees)throws ClassNotFoundException, SQLException;
	public boolean deleteEmployeeDetails(Employees employees)throws ClassNotFoundException, SQLException;
	public String getJobTitle(int employeeId)throws ClassNotFoundException, SQLException;
	public Employees getEmployeeTaxOnSalary(int employeeId)throws ClassNotFoundException, SQLException;
	public List<Employees> getManagers()throws ClassNotFoundException, SQLException;
}
