package com.egym.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Seance;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.utils.UserContext;

@Transactional
@Repository
public class SeanceRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserContext userContext;

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
	 * 
	 * @param seance
	 * @param sp
	 */
	public void persist(Seance seance, SeanceClient sc) {

		entityManager.persist(seance);
		entityManager.persist(sc);
	}

	public Seance getSeanceById(Integer id) {

		return (Seance) entityManager.createQuery("select s from Seance s where s.id = :id").setParameter("id", id)
				.getSingleResult();
	}

	public List<SeanceClient> getSeanceProgrammeByUserId() {
		User utilisateurCourant = userContext.getUser();
		StringBuilder query = new StringBuilder();
		query.append("select sc from SeanceClient sc ");
		query.append("where sc.client =:utilisateurCourant");

		return (ArrayList<SeanceClient>) entityManager.createQuery(query.toString())
				.setParameter("utilisateurCourant", utilisateurCourant).getResultList();
	}

}
