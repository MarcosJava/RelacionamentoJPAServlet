package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.PositionBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.Position;

@WebServlet("/RemovePosition")
public class RemovePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Position position = new Position();
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		
		try {
			
			String id = request.getParameter("idPosition");
			position = positionBusiness.findByID(Long.parseLong(id));
			
			positionBusiness.delete(position);
			
			List<Position> positions = positionBusiness.findAll();
			request.setAttribute("positions", positions);
			
			request.setAttribute("msg", "Excluido com Sucesso!");
			request.getRequestDispatcher("positions.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
