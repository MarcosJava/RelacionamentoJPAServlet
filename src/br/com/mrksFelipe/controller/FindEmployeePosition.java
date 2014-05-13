package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.mrksFelipe.business.EmployeePositionBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.EmployeePosition;


@WebServlet("/FindEmployeePosition")
public class FindEmployeePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeePositionBusiness employeePositionBusiness = new EmployeePositionBusiness(JPA.em());
		List<EmployeePosition> employeePositions = new ArrayList<EmployeePosition>();
		
		String idEmployee = request.getParameter("idEmployee");
		try {
			
			employeePositions = employeePositionBusiness.findEmployeePositionByEmployee(Long.parseLong(idEmployee));
			
			request.setAttribute("employee", employeePositions.get(0).getEmployee().getName());
			request.setAttribute("employeePositions", employeePositions);
			request.getRequestDispatcher("employeePositions.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
