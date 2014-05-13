package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.EmployeeBusiness;
import br.com.mrksFelipe.business.EmployeePositionBusiness;
import br.com.mrksFelipe.business.PositionBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Employee;
import br.com.mrksFelipe.model.EmployeePosition;
import br.com.mrksFelipe.model.Position;


@WebServlet("/RemoveEmployeePosition")
public class RemoveEmployeePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEmployee = request.getParameter("idEmployee");
		String idPosition = request.getParameter("idPosition");
		
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		EmployeePositionBusiness employeePositionBusiness = new EmployeePositionBusiness(JPA.em());
		try {
			
			Employee employee = employeeBusiness.findByID(Long.parseLong(idEmployee));
			Position position = positionBusiness.findByID(Long.parseLong(idPosition));
			
			EmployeePosition employeePosition = new EmployeePosition();
			employeePosition.setEmployee(employee);
			employeePosition.setPosition(position);
			
			employeePositionBusiness.delete(employeePosition);
			
			List<EmployeePosition> employeePositions = new ArrayList<EmployeePosition>();
			employeePositions = employeePositionBusiness.findEmployeePositionByEmployee(Long.parseLong(idEmployee));
			
			request.setAttribute("employee", employeePositions.get(0).getEmployee().getName());
			request.setAttribute("employeePositions", employeePositions);
			request.getRequestDispatcher("employeePositions.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
