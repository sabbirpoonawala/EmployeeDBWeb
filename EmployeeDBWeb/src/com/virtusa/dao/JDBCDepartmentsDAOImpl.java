package com.virtusa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Departments;
import com.virtusa.integrate.ConnectionManager;

public class JDBCDepartmentsDAOImpl implements DepartmentsDAO {

	@Override
	public List<Departments> getAllDepartments() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from departments");
		
		List<Departments> departmentList=new ArrayList<>();
		while(resultSet.next()) {
			Departments departments=new Departments();
			departments.setDepartmentId(resultSet.getInt("department_id"));
			departments.setDepartmentName(resultSet.getString("department_name"));
			departmentList.add(departments);
		}
		ConnectionManager.closeConnection();
		return departmentList;
	}
}
