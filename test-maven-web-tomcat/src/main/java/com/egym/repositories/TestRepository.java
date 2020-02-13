package com.egym.repositories;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Exercice;
import com.egym.entity.Periode;
import com.egym.entity.Profil;
import com.egym.entity.Programme;
import com.egym.entity.Seance;
import com.egym.entity.SeanceExercice;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.entity.enums.TypeExercice;
import com.egym.entity.enums.TypeProgramme;
import com.egym.entity.enums.TypeSeance;
import com.egym.services.ProgrammeService;

@Transactional
@Repository
public class TestRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ProgrammeService programmeService;

	@Autowired
	UserRepository userRepo;

	User admin;
	User u1;
	User u2;
	User u3;

	Periode periode;
	Periode periode2;

	@Transactional(rollbackFor = Exception.class)
	public void createInstance() {

		createUsers();

		createProfiles();

		createProgrammes();

		createSeances();

		createPeriodes();

		createExercices();

		affectProgrammes();
	}

	private void affectProgrammes() {

		programmeService.affecterProgrammeClient(u1, programme);
		programmeService.affecterProgrammeClient(u2, programme2);
		programmeService.affecterProgrammeClient(u2, programme1);
	}

	Exercice exercice;
	Exercice exercice2;
	Exercice exercice3;
	Exercice exercice4;
	Exercice exercice5;
	Exercice exercice6;
	Exercice exercice7;
	Exercice exercice8;
	Exercice exercice9;
	Exercice exercice10;
	Exercice exercice11;

	SeanceExercice se;
	SeanceExercice se2;
	SeanceExercice se3;
	SeanceExercice se4;

	private void createExercices() {
		exercice = new Exercice();
		exercice.setNom("Gainage");
		exercice.setDescription("desc");
		entityManager.persist(exercice);

		exercice2 = new Exercice();
		exercice2.setNom("Fentes avant");
		exercice2.setDescription("desc");
		entityManager.persist(exercice2);

		exercice3 = new Exercice();
		exercice3.setNom("Crunch");
		exercice3.setDescription("desc");
		entityManager.persist(exercice3);

		exercice4 = new Exercice();
		exercice4.setNom("1/2 pompes");
		exercice4.setDescription("desc");
		entityManager.persist(exercice4);

		exercice5 = new Exercice();
		exercice5.setNom("1/2 squat");
		exercice5.setDescription("desc");
		entityManager.persist(exercice5);

		exercice6 = new Exercice();
		exercice6.setNom("Dips");
		exercice6.setDescription("desc");
		entityManager.persist(exercice6);

		exercice7 = new Exercice();
		exercice7.setNom("Burpees");
		exercice7.setDescription("desc");
		entityManager.persist(exercice7);

		exercice8 = new Exercice();
		exercice8.setNom("Mountain climber");
		exercice8.setDescription("desc");
		entityManager.persist(exercice8);

		exercice9 = new Exercice();
		exercice9.setNom("Squat élastique");
		exercice9.setDescription("desc");
		entityManager.persist(exercice9);

		exercice10 = new Exercice();
		exercice10.setNom("Triceps");
		exercice10.setDescription("desc");
		entityManager.persist(exercice10);

		exercice11 = new Exercice();
		exercice11.setNom("Extension jambe avec élastique");
		exercice11.setDescription("desc");
		entityManager.persist(exercice11);

		se = new SeanceExercice();

		se.setExercice(exercice);
		se.setSeance(seance);
		se.setOrdreExercice(1);
		se.setTypeExercice(TypeExercice.PERFORMANCE_CHRONOMETRE);
		se.setOrdreSeance(1);
		entityManager.persist(se);

		se2 = new SeanceExercice();

		se2.setExercice(exercice2);
		se2.setSeance(seance);
		se2.setOrdreExercice(2);
		se2.setOrdreSeance(1);
		se2.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se2);

		se3 = new SeanceExercice();

		se3.setExercice(exercice);
		se3.setSeance(seance2);
		se3.setOrdreSeance(1);
		se3.setOrdreExercice(1);
		se3.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se3);

		se4 = new SeanceExercice();

		se4.setExercice(exercice2);
		se4.setSeance(seance2);
		se4.setOrdreSeance(2);
		se4.setOrdreExercice(1);
		se4.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se4);
	}

	private void createPeriodes() {
		// Periode periode = new Periode();
		//
		// Periode periode2 = new Periode();
		//
		// entityManager.persist(programme);
		// entityManager.persist(programme1);
		//
		// PeriodeProgramme pp = new PeriodeProgramme();
		// pp.setPeriode(periode);
		// pp.setProgramme(programme);
		// pp.setOrdrePeriode(1);
		// pp.setUser(users.get(1));
		//
		// entityManager.persist(periode);
		// entityManager.persist(pp);
		//
		// PeriodeProgramme pp2 = new PeriodeProgramme();
		// pp2.setPeriode(periode);
		// pp2.setProgramme(programme1);
		// pp2.setOrdrePeriode(1);
		// pp2.setUser(users.get(2));
		//
		// entityManager.persist(periode);
		// entityManager.persist(pp2);
		//
		// PeriodeProgramme pp3 = new PeriodeProgramme();
		// pp3.setPeriode(periode2);
		// pp3.setProgramme(programme1);
		// pp3.setOrdrePeriode(2);
		// pp3.setUser(users.get(2));
		//
		// entityManager.persist(periode2);
		// entityManager.persist(pp3);
		// SeancePeriode spe = new SeancePeriode();
		// spe.setOrdreSeance(1);
		// // spe.setPeriode(periode);
		// spe.setSeance(seance);
		//
		// entityManager.persist(spe);
		//
		// SeancePeriode spe2 = new SeancePeriode();
		// spe2.setOrdreSeance(2);
		// // spe2.setPeriode(periode2);
		// spe2.setSeance(seance2);
		//
		// entityManager.persist(spe2);

	}

	// Bilan bilan = new Bilan();
	// bilan.setFreqCardiaqueRepos(10.);
	// bilan.setFreqCardiaqueCible(10.);
	// bilan.setFreqCardiaqueMax(10.);
	// bilan.setPoid(10.);
	// bilan.setIndiceDickson(10.);
	// bilan.setFreqCardiaque5minAllonge(10.);
	// bilan.setFreqCardiaque30Flex(10.);
	// bilan.setFreqCardiaque1min(10.);
	//
	// bilan.setSeanceClient(sc);

	void createNotifications() {

		// Notification notification = new Notification();
		// notification.setEmetteur(users.get(0));
		// notification.setRecepteur(users.get(2));
		//
		// entityManager.persist(notification);
		//
		// Notification notification2 = new Notification();
		// notification2.setEmetteur(users.get(0));
		// notification2.setRecepteur(users.get(2));
		//
		// entityManager.persist(notification2);
		//
		// Notification notification3 = new Notification();
		// notification3.setEmetteur(users.get(1));
		// notification3.setRecepteur(users.get(2));
		//
		// entityManager.persist(notification3);

	}

	@Transactional
	public void createUsers() {

		if (!userRepo.usernameExists("admin")) {
			admin = new User("admin", "admin", "admin@admin", "admin", "usadminer", new Date(634815155L),
					Arrays.asList(RoleEnum.values()));
			entityManager.persist(admin);
		}

		if (!userRepo.usernameExists("chleo")) {
			u1 = new User("chleo", "chleo", "chleo@chleo", "chleo", "chleo", new Date(634815155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u1);
		}

		if (!userRepo.usernameExists("georges")) {
			u2 = new User("georges", "georges", "georges@georges", "georges", "georges", new Date(697887155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u2);
		}

		if (!userRepo.usernameExists("jd")) {
			u3 = new User("jd", "jd", "jd@jd", "jd", "jd", new Date(697887155L), Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u3);
		}
	}

	Profil profil;
	Profil profil1;
	Profil profil2;

	void createProfiles() {

		profil = new Profil();
		profil.setPoitrine(10.);
		profil.setTaille(10.);
		profil.setHanche(10.);
		profil.setCuisse(10.);
		profil.setBras(10.);
		profil.setObj("cest quoi");
		profil.setClient(u1);

		entityManager.persist(profil);

		profil1 = new Profil();
		profil1.setPoitrine(20.);
		profil1.setTaille(20.);
		profil1.setHanche(20.);
		profil1.setCuisse(20.);
		profil1.setBras(20.);
		profil1.setObj("cest quoi");
		profil1.setClient(u2);

		entityManager.persist(profil1);

		profil2 = new Profil();
		profil2.setPoitrine(30.);
		profil2.setTaille(30.);
		profil2.setHanche(30.);
		profil2.setCuisse(30.);
		profil2.setBras(30.);
		profil2.setObj("cest quoi");
		profil2.setClient(u3);

		entityManager.persist(profil2);

	}

	Programme programme;
	Programme programme1;
	Programme programme2;

	void createProgrammes() {

		programme = new Programme();
		programme.setNom("prog1");
		programme.setType(TypeProgramme.NORMAL);

		programme1 = new Programme();
		programme1.setNom("prog2");
		programme1.setType(TypeProgramme.PERSONNALISE);

		programme2 = new Programme();
		programme2.setNom("prog3");
		programme2.setType(TypeProgramme.NORMAL);

		entityManager.persist(programme);
		entityManager.persist(programme1);
		entityManager.persist(programme2);

	}

	Seance seance;
	Seance seance2;
	SeanceProgramme sp11;
	SeanceProgramme sp12;
	SeanceProgramme sp21;
	SeanceProgramme sp32;
	SeanceProgramme sp32_;

	SeanceProgramme sp2;
	SeanceProgramme sp3;
	SeanceProgramme sp4;
	SeanceProgramme sp5;

	void createSeances() {

		seance = new Seance();
		seance2 = new Seance();
		seance.setType(TypeSeance.BILAN);
		seance2.setType(TypeSeance.NORMAL);

		sp11 = new SeanceProgramme();
		sp12 = new SeanceProgramme();
		sp21 = new SeanceProgramme();
		sp32 = new SeanceProgramme();
		sp32_ = new SeanceProgramme();

		sp11.setProgramme(programme);
		sp11.setSeance(seance);
		sp11.setOrdreSeance(1);

		sp12.setProgramme(programme);
		sp12.setSeance(seance2);
		sp12.setOrdreSeance(2);

		sp21.setProgramme(programme1);
		sp21.setSeance(seance);
		sp21.setOrdreSeance(1);

		sp32.setProgramme(programme2);
		sp32.setSeance(seance2);
		sp32.setOrdreSeance(1);

		sp32_.setProgramme(programme2);
		sp32_.setSeance(seance2);
		sp32_.setOrdreSeance(2);

		entityManager.persist(seance);
		entityManager.persist(seance2);
		entityManager.persist(sp11);
		entityManager.persist(sp12);
		entityManager.persist(sp21);
		entityManager.persist(sp32);
		entityManager.persist(sp32_);

	}

}