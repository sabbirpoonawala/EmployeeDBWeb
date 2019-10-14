package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.DepartmentsDAO;
import com.virtusa.dao.JobsDAO;
import com.virtusa.entities.Departments;
import com.virtusa.entities.Jobs;
import com.virtusa.helper.FactoryEmployeeDB;
import com.virtusa.model.DepartmentsModel;
import com.virtusa.model.JobsModel;

public class DepartmentsServiceImpl implements DepartmentsService {

	 private DepartmentsDAO departmentsDAO;
		public DepartmentsServiceImpl() {
			this.departmentsDAO=FactoryEmployeeDB.createDepartmentsDAO();
			
		}
	@Override
	public List<DepartmentsModel> retrieveDepartments() {
		// TODO Auto-generated method stub
		List<DepartmentsModel> departmentsModelList=new ArrayList<>();
		try {
			List<Departments> departmentsList=departmentsDAO.getAllDepartments();
			for(Departments department:departmentsList) {
				DepartmentsModel departmentsModel=new DepartmentsModel();
				departmentsModel.setDepartmentId(department.getDepartmentId());
				departmentsModel.setDepartmentName(department.getDepartmentName());
				departmentsModelList.add(departmentsModel);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("!ERROR[Retrieval of Departments failed!!!]");
		}
		return departmentsModelList;
	}
	}


