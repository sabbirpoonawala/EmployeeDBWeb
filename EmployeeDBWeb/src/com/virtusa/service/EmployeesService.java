package com.virtusa.service;

import java.util.List;

import com.virtusa.entities.Employees;
import com.virtusa.model.EmployeesModel;
import com.virtusa.model.ManagersModel;
import com.virtusa.model.AllEmployeesModel;
import com.virtusa.model.UpdateEmployeesModel;

public interface EmployeesService {
	
	public List<EmployeesModel> retrieveEmployees();
	public List<AllEmployeesModel> retrieveAllEmployees();
	public EmployeesModel retrieveDepartmentName(int employeeId);
	public String registerEmployee(AllEmployeesModel model);
	public String deleteEmployee(AllEmployeesModel employees);
	public EmployeesModel retrieveJobTitle(int employeeId);
	public EmployeesModel retrieveEmployeeTax(int employeeId);
	public List<ManagersModel> getManagers();
	public String updateEmployee(AllEmployeesModel employeesModel);

}
