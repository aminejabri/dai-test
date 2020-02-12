package com.egym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/programme")
public class ProgrammeController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserContext userContext;

	@RequestMapping(value = ("/list"), method = RequestMethod.GET)
	public ModelAndView getProgrammes() {

		return new ModelAndView("programme", "utilisateur", userContext.getUser());
	}

}
