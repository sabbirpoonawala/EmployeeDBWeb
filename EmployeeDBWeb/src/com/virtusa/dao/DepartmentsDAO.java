package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.Departments;
import com.virtusa.model.DepartmentsModel;

public interface DepartmentsDAO {
	
	public List<Departments> getAllDepartments() throws ClassNotFoundException, SQLException;

}
