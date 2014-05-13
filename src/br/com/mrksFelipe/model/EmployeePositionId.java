package br.com.mrksFelipe.model;

import java.io.Serializable;

public class EmployeePositionId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long employee;
	private Long position;
	

	public long getEmployee() {
		return employee;
	}
	public void setEmployee(long employee) {
		this.employee = employee;
	}
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employee ^ (employee >>> 32));
		result = prime * result + (int) (position ^ (position >>> 32));
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
		EmployeePositionId other = (EmployeePositionId) obj;
		if (employee != other.employee)
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
	

}
