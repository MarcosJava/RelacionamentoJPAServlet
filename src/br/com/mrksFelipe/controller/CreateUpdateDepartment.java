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


@WebServlet("/CreateUpdateDepartment")
public class CreateUpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		
		if(cmd.equalsIgnoreCase("createDepartment")){
			createDepartment(request, response);
		}else if(cmd.equalsIgnoreCase("updateDepartment")){
			updateDepartment(request, response);
		}else{
			
		}
			
	}
	
	
	protected void createDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		Department department = new Department();
		try {
			String id = request.getParameter("id");
			
			if(id.equalsIgnoreCase("")){
				department.setId(null);
			}else{
				department.setId(Long.parseLong( id ));
			}
			
			department.setName(request.getParameter("name"));
			
			//Update ta usando o MERGER que tanto salva como faz update
			departmentBusiness.saveUpdate(department);
			
			
			List<Department> departments = departmentBusiness.findAll();
			request.setAttribute("departments", departments);

			request.setAttribute("msg", "Concluido !");
			request.getRequestDispatcher("departments.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}   
		
}
	protected void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentBusiness departmentBusiness = new DepartmentBusiness(JPA.em());
		Department department = new Department();
		try {
			
			department = departmentBusiness.findByID(Long.parseLong(request.getParameter("idDepartment")));
			
			List<Department> departments = departmentBusiness.findAll();
			request.setAttribute("departments", departments);
			request.setAttribute("id", department.getId());
			request.setAttribute("name", department.getName());
			request.getRequestDispatcher("departments.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
