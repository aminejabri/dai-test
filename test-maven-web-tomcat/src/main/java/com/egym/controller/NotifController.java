package com.egym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egym.repositories.NotificationRepository;

@RestController
@RequestMapping(value = "/notification")
public class NotifController {

	@Autowired
	NotificationRepository notificationRepository;

	// @RequestMapping(value = ("/count"), method = RequestMethod.POST)
	// @ResponseBody
	// public Long countNotif() {
	//
	// return notificationRepository.getNombreNotif();
	// }

}
