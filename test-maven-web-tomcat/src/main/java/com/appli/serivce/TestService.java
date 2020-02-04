package com.appli.serivce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appli.entity.Customer;

@Repository
public class TestService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void save(Customer customer) {
		
    	Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);

	}
}
