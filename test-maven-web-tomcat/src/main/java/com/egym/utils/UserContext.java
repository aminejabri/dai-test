package com.egym.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.egym.entity.User;
import com.egym.repositories.UserRepository;

/**
 * Classe qui founit les détails d'un utilisateur context
 * 
 * @author amine
 *
 */
@Component
public class UserContext {

	@Autowired
	UserRepository userRepo;
	
	public UserDetails getUserDetails() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return (UserDetails)auth.getPrincipal();
		}
		return null;
	}
	
	public User getUser() {
		
		if (getUserDetails()!= null) {
			
			return userRepo.getUserByUsername( getUserDetails().getUsername());
		}
		return null;
	}
	
}
