package com.egym.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Notification;
import com.egym.utils.UserContext;

@Transactional
@Repository

public class MessageRepository {

	@Autowired
	UserContext userContext;

	@PersistenceContext
	EntityManager entityManager;

	public void persist(Notification not) {

		entityManager.persist(not);
	}

	public List<Notification> getNotificationByUserId() {
		Integer id = userContext.getUser().getIdUser();
		StringBuilder query = new StringBuilder();
		query.append(("select m from Notification m where m.id = :id "));

		return (List<Notification>) entityManager.createQuery(query.toString()).setParameter("id", id).getResultList();

	}
}