package br.com.mrksFelipe.business;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.Department;
import br.com.mrksFelipe.repository.DepartmentRepository;
import br.com.mrksFelipe.repository.DepartmentRepositoryJPA;

public class DepartmentBusiness{
	
	private DepartmentRepository departmentRepository;
	private DepartmentRepositoryJPA departmentRepositoryJPA;
	
	public DepartmentBusiness(EntityManager em) {
		departmentRepositoryJPA = new DepartmentRepositoryJPA(em);
		departmentRepository = departmentRepositoryJPA;
	}

	public Department saveUpdate(Department department)throws Exception {
		return departmentRepository.update(department);
	}


	public void delete(Department department)throws Exception {
		departmentRepository.delete(department.getId(), Department.class);
		
	}

	public Department findByID(Long id)throws Exception {
		return departmentRepository.findByID(id);
	}

	public List<Department> findAll()throws Exception {
		return departmentRepository.findAll();
	}
	public List<Department> findDepartmentEmpty()throws Exception  {
		return departmentRepository.findDepartmentEmpty();
	}
	
}
