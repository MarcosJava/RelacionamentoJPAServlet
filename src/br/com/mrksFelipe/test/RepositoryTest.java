package br.com.mrksFelipe.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mrksFelipe.model.Department;

public class RepositoryTest {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("RelacionamentoJpa");
		
		EntityManager manager = factory.createEntityManager();
		
		
		Department department = new Department();
		
		manager.getTransaction().begin();
		department = manager.find(Department.class, 7L);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		System.out.println(department.getName());
		
	}

}
