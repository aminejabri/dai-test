package com.egym.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.User;

@Repository
@Transactional
public interface UserRepositoryInterface {

	public void save(User user);
}
