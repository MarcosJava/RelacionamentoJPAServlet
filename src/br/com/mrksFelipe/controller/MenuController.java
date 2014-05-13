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
import br.com.mrksFelipe.business.PositionBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Department;
import br.com.mrksFelipe.model.Employee;
import br.com.mrksFelipe.model.Position;


@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("employees")){
			employees(request,response);
		}else if (cmd.equalsIgnoreCase("departments")){
			departments(request,response);
		}else if (cmd.equalsIgnoreCase("createEmployee")){
			createEmployee(request,response);
		}else if(cmd.equalsIgnoreCase("positions")){
			position(request,response);
		}else if(cmd.equalsIgnoreCase("employeePosition")){
			employeePosition(request,response);
		}else{
			request.getRequestDispatcher("error404.jsp").forward(request, response);
		}
	}
	
	protected void employees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		try {
			List<Employee> employees = employeeBusiness.findAll();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employees.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void departments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		try {
			List<Department> departments = departmentBusiness.findAll();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("departments.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		try {
			List<Department> departments = departmentBusiness.findAll();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	protected void position(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		try {
			List<Position> positions = positionBusiness.findAll();
			request.setAttribute("positions", positions);
			request.getRequestDispatcher("positions.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void employeePosition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		
		try {
			List<Position> positions = positionBusiness.findAll();
			List<Employee> employees = employeeBusiness.findAll();
			
			
			request.setAttribute("positions", positions);
			request.setAttribute("employees", employees);
			
			request.getRequestDispatcher("employeePosition.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
