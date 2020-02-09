package com.egym.controller;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}

	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/error404")
	public String show404(){
		return "error404";
	}
	
	@RequestMapping("/error500")
	public String show500(){
		return "error500";
	}
}
