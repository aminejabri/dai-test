package com.egym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.User;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired UserContext userContext;
	
	@RequestMapping(value=("/inscription"), method = RequestMethod.GET)
	public 	ModelAndView getPage(){
		
		return new ModelAndView("inscription");
	}

	@RequestMapping(value=("/profil"), method = RequestMethod.GET)
	public 	ModelAndView getProfil(){
		
		User user = userRepository.getUserByUsername( userContext.getUserDetails().getUsername());
		return new ModelAndView("profil", "utilisateur", user );
	}
	

}
