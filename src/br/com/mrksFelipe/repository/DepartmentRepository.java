package br.com.mrksFelipe.repository;

import java.util.List;

import br.com.mrksFelipe.model.Department;

public interface DepartmentRepository extends GenericRepository<Department, Long>{
	
	public List<Department> findDepartmentEmpty();
	
}
