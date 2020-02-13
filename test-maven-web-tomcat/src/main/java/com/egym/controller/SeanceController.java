package com.egym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/seance")
public class SeanceController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SeanceRepository seanceRepository;

	@Autowired
	UserContext userContext;

}
