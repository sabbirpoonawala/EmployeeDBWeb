package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.JobsDAO;
import com.virtusa.entities.Jobs;
import com.virtusa.helper.FactoryEmployeeDB;
import com.virtusa.model.JobsModel;

public class JobsServiceImpl implements JobsService {

    private JobsDAO jobsDAO;
	public JobsServiceImpl() {
		this.jobsDAO=FactoryEmployeeDB.createJobsDAO();
		
	}
	@Override
	public List<JobsModel> retrieveJobs() {
		// TODO Auto-generated method stub
		List<JobsModel> jobsModelList=new ArrayList<>();
		try {
			List<Jobs> jobsList=jobsDAO.getAllJobs();
			for(Jobs jobs:jobsList) {
				JobsModel jobsModel=new JobsModel();
				jobsModel.setJobId(jobs.getJobId());
				jobsModel.setJobTitle(jobs.getJobTitle());
				jobsModelList.add(jobsModel);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("!ERROR[Retrieval of Jobs failed!!!]");
		}
		return jobsModelList;
	}

}
