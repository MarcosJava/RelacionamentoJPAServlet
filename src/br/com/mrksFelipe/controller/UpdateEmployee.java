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


@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String update = request.getParameter("update");
		if(update.equalsIgnoreCase("1")){
			update1(request,response);
		}else if(update.equalsIgnoreCase("2")){
			update2(request,response);
		}
	}
	protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		
		try {
			List<Department> departments = departmentBusiness.findAll();
			employee = employeeBusiness.findByID(Long.parseLong( request.getParameter("idEmployee") ));
			request.setAttribute("employee", employee);
	
			
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employee employee = new Employee();
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		Department department = new Department();
		Address address = new Address();
		
		try {
			/*
			 * Setando Empregado com Relação Departamento
			 */
			employee.setId(Long.parseLong( request.getParameter("idEmployee") ));
			employee.setName(request.getParameter("name"));
			department = departmentBusiness.findByID(Long.parseLong( request.getParameter("idDepartment") ));
			employee.setDepartment(department);
			
			/*
			 * Setando Empregado com Relação  Endereço
			 */
			address.setId(Long.parseLong( request.getParameter("idAddress") ) );
			address.setCity(request.getParameter("city"));
			address.setStreet(request.getParameter("street"));
			address.setNumber(request.getParameter("number"));
			address.setEmployee(employee);
			employee.setAddress(address);
			
			/*
			 * Finalmente Editando no Banco de Dados
			 */
			employeeBusiness.update(employee);
			
			List<Employee> employees = employeeBusiness.findAll();
			request.setAttribute("employees", employees);
			
			request.setAttribute("msg", "Empregado Editado com Sucesso");
			request.getRequestDispatcher("employees.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
