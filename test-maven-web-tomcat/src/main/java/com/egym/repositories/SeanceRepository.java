package com.egym.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Bilan;
import com.egym.entity.Exercice;
import com.egym.entity.Seance;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceExercice;
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
	 * @param sp11
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

	public List<Bilan> getBilansByUserId(Integer userId) {

		StringBuilder query = new StringBuilder();
		query.append("select b from Bilan b ");
		query.append("inner join  SeanceClient s on b.id = s.bilan.id ");
		query.append("inner join User u  on s.client.id = u.idUser ");
		query.append("where u.idUser = :userId ");
		return (ArrayList<Bilan>) entityManager.createQuery(query.toString()).setParameter("userId", userId)
				.getResultList();

	}

	public List<Exercice> getExercicesByUserId(Integer userId) {

		StringBuilder query = new StringBuilder();
		query.append("select e from exercice e ");
		query.append("inner join ");
		// query.append();
		// query.append();

		return (ArrayList<Exercice>) entityManager.createQuery(query.toString()).getResultList();
	}

	public List<SeanceProgramme> getSeanceProgrammeByProgrammeId(Integer programmeId) {

		StringBuilder query = new StringBuilder();
		query.append("select sp from SeanceProgramme sp where sp.programme.id = :programmeId");

		return (List<SeanceProgramme>) entityManager.createQuery(query.toString())
				.setParameter("programmeId", programmeId).getResultList();
	}

	public List<SeanceExercice> getSeanceExercicesBySeanceIds(List<Integer> idSeances) {

		if (idSeances == null || idSeances.isEmpty())
			return new ArrayList<>();

		StringBuilder query = new StringBuilder();
		query.append("select se from SeanceExercice se where se.seance.id in (:idSeances)");

		return (List<SeanceExercice>) entityManager.createQuery(query.toString()).setParameter("idSeances", idSeances)
				.getResultList();
	}

}
