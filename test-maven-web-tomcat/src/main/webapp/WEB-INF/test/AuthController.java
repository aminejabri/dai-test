package com.egym.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.User;
import com.egym.repository.UserRepository;
import com.egym.repository.enums.RoleEnum;
import com.egym.serivce.UserService;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value ="/")
public class AuthController {
	
	@Autowired UserService userService;

	@Autowired UserContext userContext;

    @Autowired UserRepository userRepository;


	@GetMapping(value ="connexion")
	ModelAndView connexionGet() {
        
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User adminUser = new User("admin", "admin", "Admin", "ADMIN", Arrays.asList(RoleEnum.values()));
		//User user = new User("u	ser2", "user2", "user2", "USER", Arrays.asList(RoleEnum.ROLE_USER));
		//userRepository.save(adminUser);
		//userRepository.save(user);

		UserDetails user = userContext.getUserDetails();
		return new ModelAndView("login");
	}
	
	@PostMapping(value ="connexion")
	ModelAndView connexionPost(@ModelAttribute User user) {
        
		String username = user.getUsername();
		String password = user.getPassword();
		UserDetails userDetails =  userService.loadUserByUsername(username);
		int x=1;
		User user2 = new User();
		user2.setIdUser(x);
		return new ModelAndView("login");
	}


}
