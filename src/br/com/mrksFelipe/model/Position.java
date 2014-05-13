package br.com.mrksFelipe.model;

/*
 * @Author: Marcos Felipe -- mrksFelipe
 * Employee N --- N Position
 * No nosso caso terá uma coluna extra, na entidade relacional, por isso criaremos a classe EmployeePosition e a EmployeePositionId
 * Caso quiserssemos deixar N-N direto sem campo extra na entidade relacional, seria o codigo abaixo comentado,
 * em qualquer classe, lembrando que se fosse Bidirecional ,colocaria apenas um mappedBy do outro lado.
 * 
 * 
//@ManyToMany(fetch = FetchType.EAGER)
//@JoinTable(name="employee_position",
//	joinColumns={
//		@JoinColumn(name="fk_position")
//	},inverseJoinColumns={
//		@JoinColumn(name="fk__employee")
//	}
//)
//private List<Employee> employees;
*/



import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class Position{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "position")
    private List<EmployeePosition> employees;
	
	
	public Position() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<EmployeePosition> getEmployees() {
		return employees;
	}


	public void setEmployees(List<EmployeePosition> employees) {
		this.employees = employees;
	}
	

}
