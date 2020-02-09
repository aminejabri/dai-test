package com.egym.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.User;

@Repository
public class UserRepository {
	
/*
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
    public User findByUsername(String username) {

		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.find(User.class, 1);
    }
	
	@Transactional
	public void save(User user) {
    	
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
	}
	*/
	
}