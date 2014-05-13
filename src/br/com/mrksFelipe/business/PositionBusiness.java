package br.com.mrksFelipe.business;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mrksFelipe.model.Position;
import br.com.mrksFelipe.repository.PositionRepository;
import br.com.mrksFelipe.repository.PositionRepositoryJPA;

public class PositionBusiness {
	
	PositionRepository positionRepository;
	PositionRepositoryJPA positionRepositoryJPA;
	
	public PositionBusiness(EntityManager entityManager) {
		positionRepositoryJPA = new PositionRepositoryJPA(entityManager);
		positionRepository = positionRepositoryJPA;
	}

	public Position saveUpdate(Position obj) {
		return positionRepository.update(obj);
	}

	
	public void delete(Position position) {
		positionRepository.delete(position.getId(), Position.class);
		
	}

	public Position findByID(Long id) {
		return positionRepository.findByID(id);
	}

	
	public List<Position> findAll() {
		return positionRepository.findAll();
	}
	
	
	
}
