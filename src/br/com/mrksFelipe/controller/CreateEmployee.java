package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.DepartmentBusiness;
import br.com.mrksFelipe.business.EmployeeBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Address;
import br.com.mrksFelipe.model.Department;
import br.com.mrksFelipe.model.Employee;

@WebServlet("/CreateEmployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		Department department = new Department();
		Address address = new Address();
		
		try {
			/*
			 * Cadastrando Empregado com Relação Departamento
			 */
			employee.setId(null);
			employee.setName(request.getParameter("name"));
			department = departmentBusiness.findByID(Long.parseLong( request.getParameter("idDepartment") ));
			employee.setDepartment(department);
			
			/*
			 * Cadastrando Empregado com Relação  Endereço
			 */
			address.setId(null);
			address.setCity(request.getParameter("city"));
			address.setStreet(request.getParameter("street"));
			address.setNumber(request.getParameter("number"));
			address.setEmployee(employee);
			employee.setAddress(address);
			
			/*
			 * Finalmente Persistindo no Banco de Dados
			 */
			employeeBusiness.save(employee);
			
			List<Employee> employees = employeeBusiness.findAll();
			
			request.setAttribute("employees", employees);
			request.setAttribute("msg", "Empregado Cadastrado com Sucesso");
			request.getRequestDispatcher("employees.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
