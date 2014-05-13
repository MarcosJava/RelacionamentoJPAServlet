package br.com.mrksFelipe.repository;

import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.Position;

public class PositionRepositoryJPA extends RepositoryJPA<Position, Long> implements PositionRepository{

	public PositionRepositoryJPA(EntityManager em) {
		super(Position.class, em);
	}
	
	

}
