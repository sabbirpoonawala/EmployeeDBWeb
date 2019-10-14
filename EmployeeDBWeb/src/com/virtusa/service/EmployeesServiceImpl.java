package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.EmployeesDAO;
import com.virtusa.entities.Departments;
import com.virtusa.entities.Employees;
import com.virtusa.exception.NoEmployeeFoundException;
import com.virtusa.exception.SalaryNotValidException;
import com.virtusa.helper.FactoryEmployeeDB;
import com.virtusa.model.DepartmentsModel;
import com.virtusa.model.EmployeesModel;
import com.virtusa.model.JobsModel;
import com.virtusa.model.ManagersModel;
import com.virtusa.model.AllEmployeesModel;
import com.virtusa.model.UpdateEmployeesModel;

public class EmployeesServiceImpl implements EmployeesService {

	private EmployeesDAO employeesDAO;
	
	public EmployeesServiceImpl() {
		this.employeesDAO=FactoryEmployeeDB.createEmployeesDAO();
		
	}
	
	public List<ManagersModel> getManagers(){
		List<ManagersModel> managerModelList=new ArrayList<>();
		try {
			List<Employees> employees=employeesDAO.getManagers();
			for(Employees employee:employees) {
				ManagersModel managerModel=new ManagersModel();
				managerModel.setFirstName(employee.getFirstName());
				managerModel.setLastName(employee.getLastName());
				managerModel.setEmployeeId(employee.getEmployeeId());
				managerModelList.add(managerModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return managerModelList;
		
	}
	
	@Override
	public List<AllEmployeesModel> retrieveAllEmployees() {
		// TODO Auto-generated method stub
		List<AllEmployeesModel> allemployeesModelList=new ArrayList<>();
		try {
			List<Employees> employeesList=employeesDAO.getAllEmployees();
			for(Employees employees:employeesList) {
				
				AllEmployeesModel employeesAllModel=new AllEmployeesModel();
				employeesAllModel.setEmployeeId(employees.getEmployeeId());
				employeesAllModel.setFirstName(employees.getFirstName());
				employeesAllModel.setLastName(employees.getLastName());
				employeesAllModel.setSalary(employees.getSalary());
				employeesAllModel.setCommissionPCT(employees.getCommissionPCT());				
				employeesAllModel.setPhoneNumber(employees.getPhoneNumber());
				employeesAllModel.setEmail(employees.getEmail());
				employeesAllModel.setHireDate(employees.getHireDate());
				employeesAllModel.setJobId(employees.getJobId());
				employeesAllModel.setManagerId(employees.getManagerId());
				employeesAllModel.setDepartmentId(employees.getDepartmentId());
				allemployeesModelList.add(employeesAllModel);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allemployeesModelList;
	}
	
	@Override
	public List<EmployeesModel> retrieveEmployees() {
		// TODO Auto-generated method stub
		List<EmployeesModel> employeesModelList=new ArrayList<>();
		try {
			List<Employees> employeesList=employeesDAO.getAllEmployees();
			for(Employees employees:employeesList) {
				
				EmployeesModel employeesModel=new EmployeesModel();
				employeesModel.setEmployeeId(employees.getEmployeeId());
				employeesModel.setFullName(employees.getFirstName()+" "+employees.getLastName());
				employeesModel.setTotalSalary(employees.getSalary()+employees.getSalary()*employees.getCommissionPCT());				
				employeesModel.setContactDetails("Ph No:"+employees.getPhoneNumber()+","+"Email:"+employees.getEmail());
				employeesModel.setEmail(employees.getEmail());
				employeesModelList.add(employeesModel);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employeesModelList;
	}
	@Override
	public EmployeesModel retrieveDepartmentName(int employeeId) {
		// TODO Auto-generated method stub
		Employees employees=null;
		EmployeesModel employeesModel=new EmployeesModel();
		try {
			employees=employeesDAO.getDeparmentName(employeeId);
			employeesModel.setEmployeeId(employees.getEmployeeId());
			Departments departments=employees.getDepartments();
			DepartmentsModel departmentModel=new DepartmentsModel();
			
			departmentModel.setDepartmentName(departments.getDepartmentName());
			employeesModel.setDepartmentsModel(departmentModel);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeesModel;
	}
	@Override
	public String registerEmployee(AllEmployeesModel model) {
		// TODO Auto-generated method stub
		
		Employees employees=new Employees();
		employees.setEmployeeId(model.getEmployeeId());
		employees.setFirstName(model.getFirstName());
		employees.setLastName(model.getLastName());
		employees.setEmail(model.getEmail());
		employees.setPhoneNumber(model.getPhoneNumber());
		employees.setHireDate(model.getHireDate());
		employees.setJobId(model.getJobId());
		
		if(model.getSalary()>25000) {
			employees.setSalary(model.getSalary());
		}else {
			try {
			throw new SalaryNotValidException("Salary not valid");
			}catch(SalaryNotValidException e) {
				System.out.println("!ERROR[Salary must be greater than 25000]");
			}
		}
			
		employees.setCommissionPCT(model.getCommissionPCT());
		employees.setManagerId(model.getManagerId());
		employees.setDepartmentId(model.getDepartmentId());
		String result="fail";
		try {
			boolean stored=employeesDAO.storeEmployeeDetails(employees);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[Registration failed because of internal issues...]");
		}
		return result;
	}
	@Override
	public String updateEmployee(AllEmployeesModel model) {
		// TODO Auto-generated method stub
		Employees employees=new Employees();
		employees.setEmployeeId(model.getEmployeeId());
		employees.setEmail(model.getEmail());
		employees.setPhoneNumber(model.getPhoneNumber());
		employees.setJobId(model.getJobId());
		employees.setDepartmentId(model.getDepartmentId());
		employees.setManagerId(model.getManagerId());
		employees.setCommissionPCT(model.getCommissionPCT());
		if(model.getSalary()>25000) {
			employees.setSalary(model.getSalary());
		}else {
			try {
			throw new SalaryNotValidException("Salary not valid");
			}catch(SalaryNotValidException e) {
				System.out.println("!ERROR[Salary must be greater than 25000]");
			}
		}
		
		String result="fail";
		try {
			boolean updated=employeesDAO.updateEmployee(employees);
			if(updated)
				result="success";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[Salary updation failed!!]");
		}
		return result;
	}
	@Override
	public String deleteEmployee(AllEmployeesModel model) {
		// TODO Auto-generated method stub
		
		List<EmployeesModel> employeesList= retrieveEmployees();
		String result="fail";
		boolean employeeFound=false;
		Employees employees=new Employees();
		for(EmployeesModel employeesModel: employeesList) {
			if(employeesModel.getEmployeeId()==model.getEmployeeId()) {
				employees.setEmployeeId(model.getEmployeeId());
				employeeFound=true;
				break;
			}
		}
		if(employeeFound) {
		try {
			boolean deleted=employeesDAO.deleteEmployeeDetails(employees);
			if(deleted)
				result="success";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("!ERROR[Employee record deletion failed!!]");
		}	
		
	}
		else {
			try {
				throw new NoEmployeeFoundException("Employee not found");
			} catch (NoEmployeeFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[Employee with specified id does not exist!!]");
			}
		}
		return result;

}
	@Override
	public EmployeesModel retrieveJobTitle(int employeeId) {
		// TODO Auto-generated method stub
		EmployeesModel employeesModel=new EmployeesModel();
		try {
			String jobTitle=employeesDAO.getJobTitle(employeeId);
			JobsModel jobsModel=new JobsModel();
			jobsModel.setJobTitle(jobTitle);
			employeesModel.setEmployeeId(employeeId);
			employeesModel.setJobsModel(jobsModel);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("![Error Job Title could not be retrieved!!]");
		}
		return employeesModel;
	}
	@Override
	public EmployeesModel retrieveEmployeeTax(int employeeId) {
		// TODO Auto-generated method stub
		EmployeesModel employeesModel=new EmployeesModel();
		try {
			Employees employees=employeesDAO.getEmployeeTaxOnSalary(employeeId);
			employeesModel.setEmployeeId(employees.getEmployeeId());
			employeesModel.setTotalSalary(employees.getSalary()+(employees.getSalary()*employees.getCommissionPCT()));
			employeesModel.setTax(employees.getTax());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("![Error Employee Tax details could not be retrieved!!]");
		}
		return employeesModel;
	}
	}
