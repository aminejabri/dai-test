package com.egym.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Profil;

@Transactional
@Repository
public class ProfilRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Profil profil) {

		entityManager.persist(profil);
	}

}