package br.com.mrksFelipe.business;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.mrksFelipe.model.EmployeePosition;
import br.com.mrksFelipe.repository.EmployeePositionRepository;
import br.com.mrksFelipe.repository.EmployeePositionRepositoryJPA;

public class EmployeePositionBusiness {

	private EmployeePositionRepository repository;
	private EmployeePositionRepositoryJPA jpa;
	
	public EmployeePositionBusiness(EntityManager em) {
		this.jpa = new EmployeePositionRepositoryJPA(em);
		this.repository = this.jpa;
	}
	
	public void save(EmployeePosition obj) {
		this.repository.save(obj);
		
	}

	public EmployeePosition update(EmployeePosition obj) {
		return this.repository.update(obj);
	}

	
	public void delete(EmployeePosition ep) {
		this.repository.remove(ep); 
	}

	
	public EmployeePosition findByID(Long id) {
		return this.repository.findByID(id);
	}

	
	public List<EmployeePosition> findAll() {
		return this.repository.findAll();
	}
	public List<EmployeePosition> findEmployeePositionByEmployee(
			Long idEmployee) {
		return this.repository.findEmployeePositionByIdEmployee(idEmployee);
	}
			

}
