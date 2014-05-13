package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
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

@WebServlet("/CreateEmployeePosition")
public class CreateEmployeePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String idPosition = request.getParameter("idPosition");
		String idEmployee = request.getParameter("idEmployee");
		String admissionPosition = request.getParameter("admissionPosition");
		
		EmployeePositionBusiness employeePositionBusiness = new EmployeePositionBusiness(JPA.em());
		EmployeeBusiness employeeBusiness = new EmployeeBusiness(JPA.em());
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		
		
		EmployeePosition employeePosition = new EmployeePosition();
		
		
		try {
			
			Date admission = converteData(admissionPosition);
			
			employeePosition.setAdmissionPosition(admission);
			employeePosition.setEmployee(employeeBusiness.findByID(Long.parseLong(idEmployee)));
			employeePosition.setPosition(positionBusiness.findByID(Long.parseLong(idPosition) ));
			
			employeePositionBusiness.save(employeePosition);
			
			List<Position> positions = positionBusiness.findAll();
			List<Employee> employees = employeeBusiness.findAll();
			
			
			request.setAttribute("positions", positions);
			request.setAttribute("employees", employees);
			
			request.setAttribute("msg", "Cadastrado com Sucesso");
			request.getRequestDispatcher("employeePosition.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro, verifique se digitou a data correta !");
			request.getRequestDispatcher("employeePosition.jsp").forward(request, response);
		}
	}
	
    private Date converteData(String mydata) throws ParseException {  
        String[] data = mydata.split("/");
        GregorianCalendar cal = new GregorianCalendar(
        		Integer.parseInt(data[2]), Integer.parseInt(data[1])-1, Integer.parseInt(data[0]));
        return cal.getTime();
          
    }  
}
