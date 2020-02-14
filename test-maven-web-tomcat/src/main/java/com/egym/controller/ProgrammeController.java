package com.egym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.SeanceClient;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/programme")
@Transactional
public class ProgrammeController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SeanceRepository seanceRepository;

	@Autowired
	UserContext userContext;

	// @RequestMapping(value = ("/list"), method = RequestMethod.GET)
	// public ModelAndView getProgrammes() {
	//
	// return new ModelAndView("programme", "utilisateur", userContext.getUser());
	// }

	@RequestMapping(value = ("/list"), method = RequestMethod.GET)
	public ModelAndView getlisteSeance() {

		List<SeanceClient> seanceClient = seanceRepository.getSeanceProgrammeByUserId();

		// pour chaque element x de la liste seanceClient on appelle un getter de
		// l'element séance pour loader ses attribut de la base
		seanceClient.forEach(x -> x.getSeance().getId());

		return new ModelAndView("programme", "myModel", seanceClient);
	}

}
