package com.appli.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/")
public class MainController {

	
	MainController(){
		
	}
	
	@GetMapping(value ="/view")
	String getView() {
		
		return "view";
	}
}
