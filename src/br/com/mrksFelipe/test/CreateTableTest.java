package br.com.mrksFelipe.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTableTest {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("RelacionamentoJpa");
		
		factory.close();
		
	}

}
