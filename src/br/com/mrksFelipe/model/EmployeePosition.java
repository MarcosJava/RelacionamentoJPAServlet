package br.com.mrksFelipe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee_position")
@IdClass(EmployeePositionId.class)
@NamedQueries({
		@NamedQuery(name="EmployeePosition.findByIdEmployee", 
		query="SELECT ep FROM EmployeePosition ep WHERE ep.employee.id=:idEmployee"),
		@NamedQuery(name="EmployeePosition.findByEmployeeAndPosition", 
		query="SELECT ep FROM EmployeePosition ep WHERE ep.employee=:employee AND ep.position=:position")
})
public class EmployeePosition {

	@Id
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_position")
	private Position position;
	
	@Temporal(TemporalType.DATE)
	private Date admissionPosition;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getAdmissionPosition() {
		return admissionPosition;
	}

	public void setAdmissionPosition(Date admissionPosition) {
		this.admissionPosition = admissionPosition;
	}
	
	
	
	
	
	
}
