package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.DepartmentBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Department;


@WebServlet("/RemoveDepartment")
public class RemoveDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idDepartment");
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		Department department = new Department();
		try {
			department = departmentBusiness.findByID(Long.parseLong(id));
			departmentBusiness.delete(department);
			
			List<Department> departments = departmentBusiness.findAll();
			request.setAttribute("departments", departments);
			request.setAttribute("msg", "Excluido com Sucesso");
			request.getRequestDispatcher("departments.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
