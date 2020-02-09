package com.egym.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egym.entity.User;
import com.egym.repositories.UserRepository;

@RestController
@RequestMapping(value="/api/user")
public class UserRestController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value=(""), method = RequestMethod.GET)
	void testPost(@RequestBody User  user){
		
	}
	
	@RequestMapping(value=("/username-exists"), method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody Boolean verifierExistanceUsername(@RequestBody Object username){
		
		return userRepository.usernameExists(username.toString());
	}
	
	@RequestMapping(value=("/email-exists"), method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody Boolean verifierExistanceemail(@RequestBody String email){
		
		return true;
	}
	

}
