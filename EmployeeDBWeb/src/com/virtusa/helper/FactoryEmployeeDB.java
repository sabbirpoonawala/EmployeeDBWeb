package com.virtusa.helper;

import com.virtusa.dao.DepartmentsDAO;
import com.virtusa.dao.EmployeesDAO;
import com.virtusa.dao.JDBCDepartmentsDAOImpl;
import com.virtusa.dao.JDBCEmployeesDAOImpl;
import com.virtusa.dao.JDBCJobsDAOImpl;
import com.virtusa.dao.JobsDAO;
import com.virtusa.service.DepartmentsService;
import com.virtusa.service.DepartmentsServiceImpl;
import com.virtusa.service.EmployeesService;
import com.virtusa.service.EmployeesServiceImpl;
import com.virtusa.service.JobsService;
import com.virtusa.service.JobsServiceImpl;

public class FactoryEmployeeDB{
	
	public static EmployeesDAO createEmployeesDAO(){
		EmployeesDAO employeesDAO=new JDBCEmployeesDAOImpl();
		return employeesDAO;
		
	}
	public static EmployeesService createEmployeesService(){
		EmployeesService employeesService=new EmployeesServiceImpl();
		return employeesService;
	}
	public static JobsDAO createJobsDAO(){
		JobsDAO jobsDAO=new JDBCJobsDAOImpl();
		return jobsDAO;
		
	}
	public static JobsService createJobsService(){
		JobsService jobsService=
				new JobsServiceImpl();
		return jobsService;
	}

	public static DepartmentsDAO createDepartmentsDAO(){
		DepartmentsDAO departmentsDAO=new JDBCDepartmentsDAOImpl();
		return departmentsDAO;
		
	}
	public static DepartmentsService createDepartmentsService(){
		DepartmentsService departmentService=
				new DepartmentsServiceImpl();
		return departmentService;
	}
}
