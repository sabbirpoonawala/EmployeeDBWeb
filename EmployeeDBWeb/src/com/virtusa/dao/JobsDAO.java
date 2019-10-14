package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.Jobs;

public interface JobsDAO {
	
	public List<Jobs> getAllJobs() throws ClassNotFoundException,SQLException;

}
