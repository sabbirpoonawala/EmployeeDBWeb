package com.virtusa.model;

public class UpdateEmployeesModel {
	
	private int employeeId;
	private double newSalary;
	public UpdateEmployeesModel() {
		
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(double newSalary) {
		this.newSalary = newSalary;
	}
	@Override
	public String toString() {
		return "UpdateEmployeesModel [employeeId=" + employeeId + ", newSalary=" + newSalary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		long temp;
		temp = Double.doubleToLongBits(newSalary);
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
		UpdateEmployeesModel other = (UpdateEmployeesModel) obj;
		if (employeeId != other.employeeId)
			return false;
		if (Double.doubleToLongBits(newSalary) != Double.doubleToLongBits(other.newSalary))
			return false;
		return true;
	}
	
	
	

}
