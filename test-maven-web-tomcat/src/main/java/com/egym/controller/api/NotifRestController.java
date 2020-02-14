package com.egym.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egym.repositories.NotificationRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@RestController
@RequestMapping(value = "/api/notification")
public class NotifRestController {

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserContext userContext;

	@RequestMapping(value = ("/count"), method = RequestMethod.POST)
	@ResponseBody
	public Long countNotif() {

		return notificationRepository.getNombreNotif();
	}

}
