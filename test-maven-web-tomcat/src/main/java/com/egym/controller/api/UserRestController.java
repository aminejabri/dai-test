package com.egym.controller.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egym.entity.User;

@RestController
@RequestMapping(value="/api/user")
public class UserRestController {

	@RequestMapping(value=(""), method = RequestMethod.GET)
	void testPost(@RequestBody User  user){
		
	}
	
	@RequestMapping(value=("/exists"), method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody User verifierExistanceUser(@RequestBody User user){
		return user;
	}
	

}
