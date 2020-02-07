package com.egym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.User;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value=("/inscription"), method = RequestMethod.GET)
	public 	ModelAndView getPage(){
		
		int x = 1;
		return new ModelAndView("inscription");
	}
	

}
