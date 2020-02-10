package com.egym.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.User;

@Transactional
@Repository
public class UserRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public boolean usernameExists(String username) {
		
		Query q = entityManager.createQuery("select case when (count(*) >0) then true else false end from User u where u.username = :username ");
		
		q.setParameter("username", username);
		return  (Boolean)q.getSingleResult();
	}
	
	public void persist(User user) {
		
		entityManager.persist(user);
	}

	public User getUserByUsername(String username) {

		Query q = entityManager.createQuery("select u from User u where u.username = :username ");
		q.setParameter("username", username);
		
		return  (User) q.getSingleResult();
	}
}