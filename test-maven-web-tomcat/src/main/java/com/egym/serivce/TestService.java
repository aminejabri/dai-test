package com.egym.serivce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Customer;

@Repository
public class TestService {
	

	@PersistenceContext
	EntityManager entityManagerFactory;
	
	@Transactional
	public void save(Customer customer) {
		
		entityManagerFactory.persist(customer);
	}
}
