package com.egym.controller;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.Bilan;
import com.egym.entity.Exercice;
import com.egym.entity.ExerciceClient;
import com.egym.entity.Notification;
import com.egym.entity.Periode;
import com.egym.entity.PeriodeProgramme;
import com.egym.entity.Profil;
import com.egym.entity.Programme;
import com.egym.entity.ProgrammeClient;
import com.egym.entity.Seance;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceExercice;
import com.egym.entity.SeancePeriode;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.entity.enums.TypeExercice;
import com.egym.entity.enums.TypeProgramme;
import com.egym.entity.enums.TypeSeance;
import com.egym.repositories.ProgrammeRepository;
import com.egym.repositories.SeanceRepository;
import com.egym.repositories.TestRepository;
import com.egym.repositories.UserRepository;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ProgrammeRepository progRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	SeanceRepository seanceRepo;

	@Autowired
	TestRepository testRepo;

	@GetMapping(value = "/populateDataBase")
	public String populateDataBase() {

		createInstances();
		return "done";
	}

	private void createInstances() {
		testRepo.createUsers();
		User u1 = userRepo.getUserByUsername("chleo");
		User u2 = userRepo.getUserByUsername("georges");
		User u3 = userRepo.getUserByUsername("jd");

		testRepo.createInstance(Arrays.asList(u1, u2, u3));
	}

	@GetMapping(value = "/ajouterProgramme")
	ModelAndView ajouterProgramme() {

		User u1 = new User("chleo", "chleo", "chleo@chleo", "chleo", "chleo", new Date(634815155L),
				Arrays.asList(RoleEnum.ROLE_USER));

		User u2 = new User("georges", "georges", "georges@georges", "georges", "georges", new Date(697887155L),
				Arrays.asList(RoleEnum.ROLE_USER));

		User u3 = new User("jd", "jd", "jd@jd", "jd", "jd", new Date(697887155L), Arrays.asList(RoleEnum.ROLE_USER));

		Profil profil = new Profil();
		profil.setPoitrine(10.);
		profil.setTaille(10.);
		profil.setHanche(10.);
		profil.setCuisse(10.);
		profil.setBras(10.);
		profil.setObj("cest quoi");
		profil.setClient(u1);

		entityManager.persist(profil);

		Programme programme = new Programme();
		programme.setNom("prog1");
		programme.setType(TypeProgramme.NORMAL);

		ProgrammeClient pg = new ProgrammeClient();

		pg.setProgramme(programme);
		pg.setUser(u1);

		progRepo.persist(programme, pg);

		SeanceProgramme sp = new SeanceProgramme();
		Seance seance = new Seance();

		sp.setProgramme(programme);
		sp.setSeance(seance);
		sp.setOrdreSeance(1);

		progRepo.persist(programme);
		seanceRepo.persist(seance, sp);

		seance.setType(TypeSeance.BILAN);

		SeanceClient sc = new SeanceClient();

		sc.setProgramme(programme);
		sc.setSeance(seance);
		sc.setOrdreSeance(1);
		sc.setClient(u1);

		progRepo.persist(programme);
		seanceRepo.persist(seance, sc);

		Bilan bilan = new Bilan();
		bilan.setFreqCardiaqueRepos(10.);
		bilan.setFreqCardiaqueCible(10.);
		bilan.setFreqCardiaqueMax(10.);
		bilan.setPoid(10.);
		bilan.setIndiceDickson(10.);
		bilan.setFreqCardiaque5minAllonge(10.);
		bilan.setFreqCardiaque30Flex(10.);
		bilan.setFreqCardiaque1min(10.);
		bilan.setSeanceClient(sc);

		entityManager.persist(bilan);

		Periode periode = new Periode();

		entityManager.persist(programme);

		PeriodeProgramme pp = new PeriodeProgramme();
		pp.setPeriode(periode);
		pp.setProgramme(programme);
		pp.setOrdrePeriode(1);
		pp.setUser(u1);

		entityManager.persist(pp);

		SeancePeriode spe = new SeancePeriode();
		spe.setOrdreSeance(1);
		spe.setPeriode(periode);
		spe.setSeance(seance);

		entityManager.persist(spe);

		Exercice exercice = new Exercice();
		exercice.setNom("nom");
		exercice.setDescription("desc");
		entityManager.persist(exercice);

		ExerciceClient ec = new ExerciceClient();
		ec.setClient(u1);
		ec.setExercice(exercice);
		ec.setOrdreSeance(1);
		ec.setOrdreExercice(1);
		ec.setSeance(seance);

		entityManager.persist(ec);

		SeanceExercice se = new SeanceExercice();

		se.setExercice(exercice);
		se.setSeance(seance);
		se.setOrdreExercice(1);
		se.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se);

		Notification notification = new Notification();
		notification.setEmetteur(u1);

		return new ModelAndView("test");
	}

	@GetMapping(value = "/ajouterAdmin")
	ModelAndView ajouterAdmin() {

		if (!userRepo.usernameExists("admin")) {
			User admin = new User("admin", "admin", "admin@admin", "admin", "usadminer", new Date(634815155L),
					Arrays.asList(RoleEnum.values()));
			userRepo.persist(admin);
		}

		return new ModelAndView("test");
	}

	@GetMapping(value = "/ajouterSeanceProgramme")
	ModelAndView ajouterSeanceProgramme() {

		Programme programme = new Programme();
		programme.setNom("prog1");
		programme.setType(TypeProgramme.NORMAL);

		SeanceProgramme sp = new SeanceProgramme();
		Seance seance = new Seance();

		sp.setProgramme(programme);
		sp.setSeance(seance);
		sp.setOrdreSeance(1);

		progRepo.persist(programme);
		seanceRepo.persist(seance, sp);

		return new ModelAndView("test");
	}

	@GetMapping(value = "/ajouterSeanceClient")
	ModelAndView ajouterSeanceClient() {
		seanceRepo.getSeanceById(1);

		User u1;
		if (!userRepo.usernameExists("user")) {
			u1 = new User("user", "user", "user@user", "user", "user", new Date(634815155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			userRepo.persist(u1);
		} else {
			u1 = userRepo.getUserByUsername("user");
		}

		Programme programme = new Programme();
		programme.setNom("prog1");
		programme.setType(TypeProgramme.NORMAL);

		SeanceClient sc = new SeanceClient();
		Seance seance = new Seance();

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
