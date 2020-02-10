package com.egym.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.Programme;
import com.egym.entity.ProgrammeClient;
import com.egym.entity.Seance;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.entity.enums.TypeSeance;
import com.egym.repositories.ProgrammeRepository;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.UserRepository;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	ProgrammeRepository progRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SeanceRepository seanceRepo;
	
	@GetMapping(value="/ajouterProgramme")
	ModelAndView ajouterProgramme() {
		
		User u1 = new User("user", "user", "user@user", "user", "user", Arrays.asList(RoleEnum.ROLE_USER));
		
		//userRepo.persist(u1);
		
		Programme programme = new Programme("p2", 1);
		
		ProgrammeClient pg  = new ProgrammeClient();
		
		pg.setProgramme(programme);
		pg.setUser(u1);
		
		progRepo.persist(programme, pg);
		
		return new ModelAndView("test");
	}
	
	@GetMapping(value="/ajouterAdmin")
	ModelAndView ajouterAdmin() {
		
		
		if(!userRepo.usernameExists("admin")) {
			User admin = new User("admin", "admin", "admin@admin", "admin", "usadminer", Arrays.asList(RoleEnum.values()));
			userRepo.persist(admin);
		}
		
		return new ModelAndView("test");
	}
	
	
	@GetMapping(value="/ajouterSeanceProgramme")
	ModelAndView ajouterSeanceProgramme() {

		Programme programme = new Programme("progra seance", 1);
		
		SeanceProgramme sp  = new SeanceProgramme();
		Seance seance  = new Seance();
		
		sp.setProgramme(programme);
		sp.setSeance(seance);
		sp.setOrdreSeance(1);
		
		progRepo.persist(programme);
		seanceRepo.persist(seance, sp);
		
		return new ModelAndView("test");
	}
	
	@GetMapping(value="/ajouterSeanceClient")
	ModelAndView ajouterSeanceClient() {
		seanceRepo.getSeanceById(1);

		User u1;
		if(!userRepo.usernameExists("user")) {
			u1 = new User("user", "user", "user@user", "user", "user", Arrays.asList(RoleEnum.ROLE_USER));
			userRepo.persist(u1);
		} else {
			u1 = userRepo.getUserByUsername("user");
		}
		
		Programme programme = new Programme("progra seance", 1);
		
		SeanceClient sc = new SeanceClient();
		Seance seance  = new Seance();
		
		seance.setType(TypeSeance.BILAN);
		
		sc.setProgramme(programme);
		sc.setSeance(seance);
		sc.setOrdreSeance(1);
		sc.setClient(u1);
		
		progRepo.persist(programme);
		seanceRepo.persist(seance, sc);
		
		return new ModelAndView("test");
	}
}
