package com.virtusa.model;

public class EmployeesModel {
	private int employeeId;
	private String fullName;
	private double totalSalary;
	private String contactDetails;
	private double tax;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	private DepartmentsModel departmentsModel;
	
	private JobsModel jobsModel;
	
	public EmployeesModel() {
		
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}



	public DepartmentsModel getDepartmentsModel() {
		return departmentsModel;
	}

	public void setDepartmentsModel(DepartmentsModel departmentsModel) {
		this.departmentsModel = departmentsModel;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public JobsModel getJobsModel() {
		return jobsModel;
	}

	public void setJobsModel(JobsModel jobsModel) {
		this.jobsModel = jobsModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactDetails == null) ? 0 : contactDetails.hashCode());
		result = prime * result + ((departmentsModel == null) ? 0 : departmentsModel.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((jobsModel == null) ? 0 : jobsModel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeesModel other = (EmployeesModel) obj;
		if (contactDetails == null) {
			if (other.contactDetails != null)
				return false;
		} else if (!contactDetails.equals(other.contactDetails))
			return false;
		if (departmentsModel == null) {
			if (other.departmentsModel != null)
				return false;
		} else if (!departmentsModel.equals(other.departmentsModel))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (jobsModel == null) {
			if (other.jobsModel != null)
				return false;
		} else if (!jobsModel.equals(other.jobsModel))
			return false;
		if (Double.doubleToLongBits(totalSalary) != Double.doubleToLongBits(other.totalSalary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeesModel [employeeId=" + employeeId + ", fullName=" + fullName + ", totalSalary=" + totalSalary
				+ ", contactDetails=" + contactDetails + ", departmentsModel=" + departmentsModel + ", jobsModel="
				+ jobsModel + "]";
	}

	

	
	
}
