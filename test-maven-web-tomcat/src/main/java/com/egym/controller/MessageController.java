package com.egym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.User;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserContext userContext;

	@RequestMapping(value = ("/envoyes"), method = RequestMethod.GET)
	public ModelAndView getMessages() {

		User user = userRepository.getUserByUsername(userContext.getUserDetails().getUsername());
		return new ModelAndView("messages");
	}

}
