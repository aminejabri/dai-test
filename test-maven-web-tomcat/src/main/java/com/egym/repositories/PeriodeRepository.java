package com.egym.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.PeriodeProgramme;
import com.egym.entity.Seance;

@Transactional
@Repository
public class PeriodeRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Seance seance) {

		entityManager.persist(seance);
	}

	public List<PeriodeProgramme> getPeriodesByProgrammeId(Integer idProgramme) {

		StringBuilder query = new StringBuilder();
		query.append("select pp from PeriodeProgramme pp where pp.periode.id = :idProgramme");

		return (List<PeriodeProgramme>) entityManager.createQuery(query.toString())
				.setParameter("idProgramme", idProgramme).getResultList();
	}
}
