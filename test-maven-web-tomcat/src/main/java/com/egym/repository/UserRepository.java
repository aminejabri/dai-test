package com.egym.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.egym.entity.User;

@Repository
public class UserRepository implements UserRepositoryInterface {

	@PersistenceContext
	EntityManager entityManager;

	public void save(User user) {

		entityManager.persist(user);
	}

}
