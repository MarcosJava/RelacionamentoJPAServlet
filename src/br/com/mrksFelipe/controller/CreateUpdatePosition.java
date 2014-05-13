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

@WebServlet("/CreateUpdatePosition")
public class CreateUpdatePosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("createPosition")){
			createPosition(request, response);
		}else if(cmd.equalsIgnoreCase("updatePosition")){
			updatePosition(request, response);
		}else{
			
		}
	}
	
	protected void createPosition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		Position position = new Position();
		try {
			
			String id = request.getParameter("id");
			
			if(id.equalsIgnoreCase("")){
				position.setId(null);
			}else{
				position.setId(Long.parseLong(id));
			}
			
			position.setName(request.getParameter("name"));
			
			positionBusiness.saveUpdate(position);
			
			List<Position> positions = positionBusiness.findAll();
			request.setAttribute("positions", positions);
			
			request.setAttribute("msg", "Concluido com Sucesso!");
			request.getRequestDispatcher("positions.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void updatePosition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PositionBusiness positionBusiness = new PositionBusiness(JPA.em());
		Position position = new Position();
		try {
			
			position = positionBusiness.findByID(Long.parseLong( request.getParameter("idPosition") ));
			
			List<Position> positions = positionBusiness.findAll();
			request.setAttribute("positions", positions);
			request.setAttribute("id", position.getId());
			request.setAttribute("name", position.getName());
			
			request.getRequestDispatcher("positions.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
