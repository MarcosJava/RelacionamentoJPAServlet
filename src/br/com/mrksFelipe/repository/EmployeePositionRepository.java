package br.com.mrksFelipe.repository;

import java.util.List;
import br.com.mrksFelipe.model.EmployeePosition;

public interface EmployeePositionRepository extends GenericRepository<EmployeePosition, Long> {

	public List<EmployeePosition> findEmployeePositionByIdEmployee(Long idEmployee);
	public void remove(EmployeePosition ep);
}
