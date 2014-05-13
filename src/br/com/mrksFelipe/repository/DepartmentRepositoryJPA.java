package br.com.mrksFelipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mrksFelipe.model.Department;

public class DepartmentRepositoryJPA extends RepositoryJPA<Department, Long> implements DepartmentRepository {

	public DepartmentRepositoryJPA(EntityManager em) {
		super(Department.class, em);
	}

	
	@SuppressWarnings("unchecked")
	public List<Department> findDepartmentEmpty() {
		String sql = "SELECT * FROM department WHERE department.id not in (select fk_department from employee)";
		Query nativeQuery = getEm().createNativeQuery(sql, Department.class);
		 return nativeQuery.getResultList();
	}

}
