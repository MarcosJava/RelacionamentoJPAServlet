package br.com.mrksFelipe.repository;



import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.Employee;

public class EmployeeRepositoryJPA extends RepositoryJPA<Employee, Long> implements EmployeeRepository {

	public EmployeeRepositoryJPA(EntityManager em) {
		super(Employee.class, em);
	}


}
