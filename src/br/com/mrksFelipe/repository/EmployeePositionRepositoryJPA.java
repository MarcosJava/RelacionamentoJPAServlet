package br.com.mrksFelipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mrksFelipe.model.EmployeePosition;

public class EmployeePositionRepositoryJPA extends RepositoryJPA<EmployeePosition, Long> implements EmployeePositionRepository {

	EntityManager em;
	
	
	public EmployeePositionRepositoryJPA(EntityManager em) {
		super(EmployeePosition.class, em);
		this.em = em ;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeePosition> findEmployeePositionByIdEmployee(
			Long idEmployee) {
		Query query = this.em.createNamedQuery("EmployeePosition.findByIdEmployee");
		query.setParameter("idEmployee", idEmployee);
		
		return query.getResultList();
	}

	
	public void remove(EmployeePosition ep) {
		
		Query query = this.em.createNamedQuery("EmployeePosition.findByEmployeeAndPosition");
		query.setParameter("employee", ep.getEmployee());
		query.setParameter("position", ep.getPosition());
		
		
		EmployeePosition remover = (EmployeePosition) query.getSingleResult();
		this.em.remove(remover);
	}

	
}
