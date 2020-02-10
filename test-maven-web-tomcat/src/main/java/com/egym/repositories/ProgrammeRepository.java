package com.egym.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Programme;
import com.egym.entity.ProgrammeClient;

@Transactional
@Repository
public class ProgrammeRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void persist(Programme programme, ProgrammeClient pg) {
		
		entityManager.persist(programme);
		entityManager.persist(pg);
	}

	public void persist(Programme programme) {
		
		entityManager.persist(programme);
	}
}
