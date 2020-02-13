package com.egym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.ExerciceClient;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/seance")
public class SeanceController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SeanceRepository seanceRepository;

	@Autowired
	UserContext userContext;

	@RequestMapping(value = ("/exercice/{id}"), method = RequestMethod.GET)
	public ModelAndView getlisteExercice(@PathVariable(value = "id") Integer id) {

		List<ExerciceClient> exerciceClient = seanceRepository.getExerciceBySeanceId(id);

		// pour chaque element x de la liste seanceClient on appelle un getter de
		// l'element seance pour loader ses attribut de la base
		// seanceClient.forEach(x -> x.getSeance().getId());

		return new ModelAndView("exercice-seance", "myModel", exerciceClient);
	}
}
