package com.egym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@GetMapping(value="/test")
	ModelAndView getTest() {
		
		return new ModelAndView("test");
	}
	
}
