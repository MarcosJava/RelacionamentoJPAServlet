package br.com.mrksFelipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.EmployeeBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Employee;


@WebServlet("/RemoveEmployee")
public class RemoveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		
		try {
			employee.setId(Long.parseLong(request.getParameter("idEmployee")));
			employeeBusiness.delete(employee);
			
			request.setAttribute("msg", "Excluido com Sucesso");
			request.setAttribute("employees", employeeBusiness.findAll());
			request.getRequestDispatcher("employees.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
