package com.egym.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Notification;

@Transactional
@Repository
public class MessageRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Notification not) {

		entityManager.persist(not);
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
