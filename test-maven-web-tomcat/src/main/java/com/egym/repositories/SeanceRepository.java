package com.egym.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Programme;
import com.egym.entity.ProgrammeClient;
import com.egym.entity.Seance;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceProgramme;

@Transactional
@Repository
public class SeanceRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void persist(Seance seance) {
		
		entityManager.persist(seance);
	}

	/**
	 * Méthode pour persister une seance et un programme
	 * 
	 * @param seance
	 * @param sp
	 */
	public void persist(Seance seance, SeanceProgramme sp) {
		
		entityManager.persist(seance);
		entityManager.persist(sp);
	}

	/**
	 * Méthode pour persister une seance affectee à un client pour un client
	 * @param seance
	 * @param sp
	 */
	public void persist(Seance seance, SeanceClient sc) {
		
		entityManager.persist(seance);
		entityManager.persist(sc);
	}
	
	public Seance getSeanceById(Integer id) {
		
		return (Seance) entityManager.createQuery("select s from Seance s where s.id = :id").setParameter("id", id).getSingleResult();
	}
}
