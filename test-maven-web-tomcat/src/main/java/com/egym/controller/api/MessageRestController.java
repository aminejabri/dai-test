package com.egym.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egym.entity.Notification;
import com.egym.repositories.MessageRepository;

@RestController
@RequestMapping(value = "/api/message")
public class MessageRestController {

	@Autowired
	MessageRepository messageRepository;

	@RequestMapping(value = ("/notifications"), method = RequestMethod.POST)
	@ResponseBody
	public List<Notification> affichNotif() {

		return messageRepository.getNotificationByUserId();
	}

}
