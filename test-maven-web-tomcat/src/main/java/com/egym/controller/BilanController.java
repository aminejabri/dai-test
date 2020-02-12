package com.egym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.Bilan;
import com.egym.entity.User;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value="/bilan")
public class BilanController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserContext userContext;
	
	@Autowired 
	SeanceRepository seanceRepository;
	
	@RequestMapping(value=("/list"), method = RequestMethod.GET)
	public 	ModelAndView getBilanPage(){
		
		User user = userContext.getUser();
		List<Bilan> bilans = seanceRepository.getBilansByUserId(user.getIdUser());
		Object[] myModel = {user, bilans};
		
		return new ModelAndView("bilan", "myModel", myModel );
		
			
	}

}
