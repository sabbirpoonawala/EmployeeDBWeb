package com.virtusa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Departments;
import com.virtusa.entities.Employees;
import com.virtusa.integrate.ConnectionManager;

public class JDBCEmployeesDAOImpl implements EmployeesDAO {

	@Override
	public List<Employees> getAllEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from employees");
		
		List<Employees> employeesList=new ArrayList<Employees>();
		while(resultSet.next()) {
			Employees employees=new Employees();
			employees.setEmployeeId(resultSet.getInt("employee_id"));
			employees.setFirstName(resultSet.getString("first_name"));
			employees.setLastName(resultSet.getString("last_name"));
			employees.setEmail(resultSet.getString("email"));
			employees.setPhoneNumber(resultSet.getString("phone_number"));
			java.sql.Date 
			hire_date=resultSet.getDate("hire_date");
			
			employees.setHireDate(hire_date.toLocalDate());
			employees.setJobId(resultSet.getString("job_id"));
			employees.setSalary(resultSet.getDouble("salary"));
			employees.setCommissionPCT(resultSet.getDouble("commission_pct"));
			employees.setManagerId(resultSet.getInt("manager_id"));
			employees.setDepartmentId(resultSet.getInt("department_id"));
			employeesList.add(employees);
		}
		ConnectionManager.closeConnection();
		return employeesList;
	}

	@Override
	public Employees getDeparmentName(int employeeId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("select e.employee_id,d.department_name\r\n" + 
				"from employees e\r\n" + 
				"join departments d\r\n" + 
				"on(e.department_id=d.department_id)\r\n" + 
				"where employee_id=?");
		statement.setInt(1, employeeId);
		
		ResultSet resultSet=statement.executeQuery();
		Employees employees=new Employees();
		while(resultSet.next()) {
			
			employees.setEmployeeId(resultSet.getInt("employee_id"));
			
			Departments departments=new Departments();
			departments.setDepartmentName(resultSet.getString("department_name"));
			
			employees.setDepartments(departments);
			
		}
		ConnectionManager.closeConnection();
		return employees;
	}
/**
 * EMPLOYEE_ID    NOT NULL NUMBER(6)    
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE         
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2)  
COMMISSION_PCT          NUMBER(2,2)  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)  
 */
	@Override
	public boolean storeEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?,?)");
		statement.setInt(1,employees.getEmployeeId());
		statement.setString(2,employees.getFirstName());
		statement.setString(3, employees.getLastName());
		statement.setString(4, employees.getEmail());
		statement.setString(5,employees.getPhoneNumber());
		
		LocalDate localDate=employees.getHireDate();
		java.sql.Date hireDate=new java.sql.Date(localDate.getYear(),localDate.getMonthValue()-1,localDate.getDayOfMonth());
		statement.setDate(6,hireDate);
		
		statement.setString(7, employees.getJobId());
		statement.setDouble(8,employees.getSalary());
		statement.setDouble(9, employees.getCommissionPCT());
		statement.setInt(10, employees.getManagerId());
		statement.setInt(11, employees.getDepartmentId());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		if(rows>0)
			return true;
		else
	
		return false;
	}

@Override
public boolean updateEmployee(Employees employees) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Connection connection=ConnectionManager.openConnection();
	PreparedStatement statement=
			connection.prepareStatement("update employees set email=?,phone_number=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id=?");
	statement.setString(1,employees.getEmail());
	statement.setString(2, employees.getPhoneNumber());
	statement.setString(3, employees.getJobId());
	statement.setDouble(4, employees.getSalary());
	statement.setDouble(5, employees.getCommissionPCT());
	statement.setInt(6, employees.getManagerId());
	statement.setInt(7, employees.getDepartmentId());
    statement.setInt(8, employees.getEmployeeId());
	int rows=statement.executeUpdate();
	ConnectionManager.closeConnection();
	if(rows>0)
		return true;
	else
	return false;

}

@Override
public boolean deleteEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Connection connection=ConnectionManager.openConnection();
	PreparedStatement statement=
			connection.prepareStatement("delete from employees where employee_id=?");
	statement.setInt(1, employees.getEmployeeId());
	int rows=statement.executeUpdate();
	ConnectionManager.closeConnection();
	if(rows>0)
		return true;
	else
	return false;
}

@Override
public String getJobTitle(int employeeId) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Connection connection=ConnectionManager.openConnection();
	CallableStatement statement=
			connection.prepareCall("{ call RetrieveJobTitle(?,?)}");
	statement.registerOutParameter(2, Types.VARCHAR);
	statement.setInt(1, 106);
	statement.execute();
	String jobTitle=statement.getString(2);
	ConnectionManager.closeConnection();
	return jobTitle;
}

@Override
public Employees getEmployeeTaxOnSalary(int employeeId) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Connection connection=ConnectionManager.openConnection();
	PreparedStatement statement=connection.prepareStatement("select salary,commission_pct,tax_calc(salary) from employees where employee_id=?");
	statement.setInt(1, employeeId);
	ResultSet resultSet=statement.executeQuery();
	Employees employees=new Employees();
	while(resultSet.next()) {
		employees.setEmployeeId(employeeId);
		employees.setSalary(resultSet.getDouble("salary"));
		employees.setCommissionPCT(resultSet.getDouble("commission_pct"));
		employees.setTax(resultSet.getDouble(3));
	}
	ConnectionManager.closeConnection();
	return employees;
}

@Override
public List<Employees> getManagers() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Connection connection=ConnectionManager.openConnection();
    Statement statement= connection.createStatement();
    ResultSet resultSet=statement.executeQuery("select e.first_name,e.last_name,e.employee_id\r\n" + 
    		"from employees e\r\n" + 
    		"join departments d\r\n" + 
    		"on(e.manager_id=d.manager_id)");
    List<Employees> managersList=new ArrayList<>();
    while(resultSet.next()) {
    	Employees employee=new Employees();
    	employee.setFirstName(resultSet.getString("first_name"));
    	employee.setLastName(resultSet.getString("last_name"));
    	employee.setEmployeeId(resultSet.getInt("employee_id"));
    	managersList.add(employee);
    }
    ConnectionManager.closeConnection();
	return managersList;
}

}
