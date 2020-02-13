package com.egym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.egym.dto.BilanClientSeance;
import com.egym.dto.ExercieClientSeance;
import com.egym.entity.Bilan;
import com.egym.entity.ExerciceClient;
import com.egym.entity.User;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/bilan")
public class BilanController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserContext userContext;

	@Autowired
	SeanceRepository seanceRepository;

	@RequestMapping(value = ("/list"), method = RequestMethod.GET)
	public ModelAndView getBilanPage() {

		User user = userContext.getUser();
		List<Bilan> bilans = seanceRepository.getBilansByUserId(user.getIdUser());

		Object[] myModel = { user, bilans };

		return new ModelAndView("bilan", "myModel", myModel);

	}

	@RequestMapping(value = ("/{idSeance}"), method = RequestMethod.GET)
	public ModelAndView getBilanPage(@PathVariable(value = "idSeance") Integer idSeance) {

		User user = userContext.getUser();
		Bilan bilan = seanceRepository.getBilanBySeanceClientId(idSeance);
		List<ExerciceClient> exercicesClient = seanceRepository.getExercicesClientParSeanceId(idSeance);
		BilanClientSeance bilanClientSeance = new BilanClientSeance();
		bilanClientSeance.setBilan(bilan);
		bilanClientSeance.setExercicesClient(exercicesClient);

		Object[] myModel = { user, bilanClientSeance };

		return new ModelAndView("bilan", "myModel", myModel);

	}

	@RequestMapping(value = ("/getExercieClientSeanceParSeanceId"), method = RequestMethod.GET)
	public ModelAndView getExercieClientSeanceParSeanceId() {

		User user = userContext.getUser();
		List<ExercieClientSeance> exercices = seanceRepository.getExercieClientSeanceParSeanceId(1);

		Object[] myModel = { user, exercices };

		return new ModelAndView("bilan", "myModel", myModel);

	}

}
