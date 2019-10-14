package com.virtusa.model;

public class DepartmentsModel {
	
	private int departmentId;
	private String departmentName;
	
	public DepartmentsModel() {}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
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
		DepartmentsModel other = (DepartmentsModel) obj;
		if (departmentId != other.departmentId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartmentsModel [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	

	
	

}
