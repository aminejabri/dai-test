package com.egym.controller.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egym.dto.BilanMessage;
import com.egym.entity.Bilan;
import com.egym.entity.Notification;
import com.egym.entity.Profil;
import com.egym.entity.User;
import com.egym.repositories.BilanRepository;
import com.egym.repositories.MessageRepository;
import com.egym.repositories.ProfilRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Transactional
@RestController
@RequestMapping(value = "/api/user")
public class BilanRestController {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserContext userContext;

	@Autowired
	ProfilRepository profilRepository;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	BilanRepository bilanRepository;

	@RequestMapping(value = ("/validerbilan"), method = RequestMethod.POST)
	@ResponseBody
	void enregistrerBilan(@RequestBody BilanMessage bilanForm) {

		User emetteur = userContext.getUser();
		User recepteur = userContext.getUser();

		Bilan bilan = new Bilan();
		bilan.setFreqCardiaque1min(bilanForm.getFc1());
		bilan.setFreqCardiaque30Flex(bilanForm.getFc30());
		bilan.setFreqCardiaque5minAllonge(bilanForm.getFc5());
		bilan.setFreqCardiaqueCible(bilanForm.getFccible());
		bilan.setFreqCardiaqueRepos(bilanForm.getFcrepos());
		bilan.setIndiceDickson(bilanForm.getDips());
		bilan.setPoid(bilanForm.getPoids());

		Notification not = new Notification();

		not.setEmetteur(emetteur);
		not.setRecepteur(recepteur);
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append(bilanForm.getMessagconfirmation());
		not.setMessage(messageBuilder.toString());

		Profil prof = new Profil();

		prof.setCuisse(bilanForm.getCuisse());
		prof.setBras(bilanForm.getBras());
		prof.setHanche(bilanForm.getHanches());
		prof.setPoitrine(bilanForm.getPoitrine());
		prof.setTaille(bilanForm.getTaille());

		bilanRepository.persist(bilan);

		messageRepository.persist(not);

		profilRepository.persist(prof);

	}

}
