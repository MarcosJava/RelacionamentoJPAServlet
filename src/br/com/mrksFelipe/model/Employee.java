package br.com.mrksFelipe.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="fk_department")
	private Department department;
	
	@OneToMany(mappedBy = "employee")
    private List<EmployeePosition> positions;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="employee")
	private Address address;
	

	public Employee() {
		
	}

	/**
	 * 
	 * Getter & Setter
	 * **/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<EmployeePosition> getPositions() {
		return positions;
	}

	public void setPositions(List<EmployeePosition> positions) {
		this.positions = positions;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	
	
}
