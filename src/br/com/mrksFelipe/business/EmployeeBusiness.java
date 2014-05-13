package br.com.mrksFelipe.business;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.mrksFelipe.model.Employee;
import br.com.mrksFelipe.repository.EmployeeRepository;
import br.com.mrksFelipe.repository.EmployeeRepositoryJPA;


public class EmployeeBusiness {
	
	private EmployeeRepository employeeRepository;
	private EmployeeRepositoryJPA employeeRepositoryJPA;
	
	public EmployeeBusiness(EntityManager entityManager) {
		employeeRepositoryJPA  = new EmployeeRepositoryJPA(entityManager);
		employeeRepository = employeeRepositoryJPA;
	}
	
	public void save(Employee employee)throws Exception {
		employeeRepository.save(employee);
	}

	
	public Employee update(Employee employee)throws Exception {
		return employeeRepository.update(employee);

	}

	
	public void delete(Employee employee)throws Exception {
		employeeRepository.delete(employee.getId(),Employee.class);
		
	}


	public List<Employee> findAll()throws Exception {
		return employeeRepository.findAll();
	}


	
	public Employee findByID(Long id) throws Exception{
		if(id == null) return null;
		return employeeRepository.findByID(id);
	}


}
