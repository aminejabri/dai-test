package com.egym.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Bilan;

@Transactional
@Repository
public class BilanRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Bilan bil) {

		entityManager.persist(bil);
	}

	/*
	 * public Message getMessageById(String id) {
	 * 
	 * Query q =
	 * entityManager.createQuery("select m from Message m where m.NOT_ID = :id ");
	 * q.setParameter("id", id);
	 * 
	 * return (Message) q.getSingleResult(); }
	 */

}
