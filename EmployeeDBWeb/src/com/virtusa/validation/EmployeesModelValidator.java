package com.virtusa.validation;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.helper.FactoryEmployeeDB;
import com.virtusa.model.DepartmentsModel;
import com.virtusa.model.EmployeesModel;
import com.virtusa.model.JobsModel;
import com.virtusa.model.AllEmployeesModel;
import com.virtusa.service.DepartmentsService;
import com.virtusa.service.EmployeesService;
import com.virtusa.service.JobsService;

public class EmployeesModelValidator {
	
	public boolean validate(AllEmployeesModel model) {
		boolean result=false;
		if(validString(model.getFirstName()) && validString(model.getLastName()) && validNumber(model.getEmployeeId()) && validSalary(model.getSalary())){
			result=true;
		}
		return result;
	}
	public boolean validString(String val) {
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		
		for(char ch:chars) {
			if(alphabets.contains(ch)) {
				result=true;
			}else {
				return false;
			}
		}
		return result;
	}

	public boolean validNumber(int number) {
		boolean result=false;
		String data=String.valueOf(number);
		if(data.matches(".*[0-9]")) {
			result=true;
		}
		return result;
	}
	
	public boolean validSalary(double salary) {
		boolean result=false;
		String salaryVal=String.valueOf((int)salary);
		if(salary>0 && salaryVal.length()<=5) {
			result=true;
		}
		return result;
}
	
	public boolean employeeIdExists(int employeeId) {
		EmployeesService employeeService=FactoryEmployeeDB.createEmployeesService();
		List<EmployeesModel> employeesModelList=employeeService.retrieveEmployees();
		for(EmployeesModel employeesModel:employeesModelList) {
			
			if(employeesModel.getEmployeeId()==employeeId) {
				return true;
			}
		}
		return false;
	}
	public boolean validEmail(String email) {
		boolean result=false;
		if(email.matches("^(.+)@(.+)$")) {
			result=true;
		}
		return result;
	}
	
	public boolean emailExist(String email) {
		boolean result=false;
		EmployeesService employeeService=FactoryEmployeeDB.createEmployeesService();
		List<EmployeesModel> employeesModelList=employeeService.retrieveEmployees();
		for(EmployeesModel employeesModel:employeesModelList) {
			
			if(employeesModel.getEmail().contentEquals(email)) {
				return true;
				
			}
		}
		return result;
	}
	public boolean validJob(String jobId) {
		boolean result=false;
		
		JobsService jobService=
				FactoryEmployeeDB.createJobsService();
		List<JobsModel> jobsModelList=jobService.retrieveJobs();
		for(JobsModel job:jobsModelList) {
			if(job.getJobId().equals(jobId)) {
				result=true;
				return result;
			}
			
		}
		return result;
	}
	public boolean validDepartment(int departmentId) {
		boolean result=false;
		
		DepartmentsService departmentsService=
				FactoryEmployeeDB.createDepartmentsService();
		List<DepartmentsModel> departmentModelList=departmentsService.retrieveDepartments();
		for(DepartmentsModel department:departmentModelList) {
			if(department.getDepartmentId()==departmentId) {
				result=true;
				return result;
			}
			
		}
		return result;
	}
	public boolean validManagerId(int managerId) {
		boolean result=false;
		EmployeesService employeesService=
				FactoryEmployeeDB.createEmployeesService();
		List<EmployeesModel> employeesModelList=employeesService.retrieveEmployees();
		for(EmployeesModel department:employeesModelList) {
			if(department.getEmployeeId()==managerId) {
				result=true;
				return result;
			}
		}
		return result;
	}
}