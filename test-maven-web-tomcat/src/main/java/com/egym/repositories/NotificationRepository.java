package com.egym.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.utils.UserContext;

@Transactional
@Repository
public class NotificationRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserContext userContext;

	public Long getNombreNotif() {

		return (Long) entityManager.createQuery("select count (*) from Notification n where n.recepteur = :recepteur")
				.setParameter("recepteur", userContext.getUser()).getSingleResult();

	}

}
