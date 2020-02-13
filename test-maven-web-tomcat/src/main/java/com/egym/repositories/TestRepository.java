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
	Exercice exercice12;
	Exercice exercice13;
	Exercice exercice14;
	Exercice exercice15;
	Exercice exercice16;
	Exercice exercice17;

	SeanceExercice se;
	SeanceExercice se2;
	SeanceExercice se3;
	SeanceExercice se4;
	SeanceExercice se5;
	SeanceExercice se6;
	SeanceExercice se7;
	SeanceExercice se8;
	SeanceExercice se9;
	SeanceExercice se10;
	SeanceExercice se11;
	SeanceExercice se12;
	SeanceExercice se13;
	SeanceExercice se14;
	SeanceExercice se15;
	SeanceExercice se16;
	SeanceExercice se17;

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
		exercice8.setNom("Pompes à genoux");
		exercice8.setDescription("desc");
		entityManager.persist(exercice8);

		exercice9 = new Exercice();
		exercice9.setNom("Mountain climber");
		exercice9.setDescription("desc");
		entityManager.persist(exercice9);

		exercice10 = new Exercice();
		exercice10.setNom("Squat élastique");
		exercice10.setDescription("desc");
		entityManager.persist(exercice10);

		exercice11 = new Exercice();
		exercice11.setNom("Triceps");
		exercice11.setDescription("desc");
		entityManager.persist(exercice11);

		exercice12 = new Exercice();
		exercice12.setNom("Extension jambe avec élastique");
		exercice12.setDescription("desc");
		entityManager.persist(exercice12);

		exercice13 = new Exercice();
		exercice13.setNom("Etirement1");
		exercice13.setDescription("desc");
		entityManager.persist(exercice13);

		exercice14 = new Exercice();
		exercice14.setNom("Etirement2");
		exercice14.setDescription("desc");
		entityManager.persist(exercice14);

		exercice15 = new Exercice();
		exercice15.setNom("Etirement3");
		exercice15.setDescription("desc");
		entityManager.persist(exercice15);

		exercice16 = new Exercice();
		exercice16.setNom("Etirement4");
		exercice16.setDescription("desc");
		entityManager.persist(exercice16);

		exercice17 = new Exercice();
		exercice17.setNom("Etirement5");
		exercice17.setDescription("desc");
		entityManager.persist(exercice17);

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

		se3.setExercice(exercice3);
		se3.setSeance(seance);
		se3.setOrdreSeance(1);
		se3.setOrdreExercice(3);
		se3.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se3);

		se4 = new SeanceExercice();

		se4.setExercice(exercice4);
		se4.setSeance(seance);
		se4.setOrdreSeance(1);
		se4.setOrdreExercice(4);
		se4.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se4);

		se5 = new SeanceExercice();

		se5.setExercice(exercice5);
		se5.setSeance(seance);
		se5.setOrdreSeance(1);
		se5.setOrdreExercice(5);
		se5.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se5);

		se6 = new SeanceExercice();

		se6.setExercice(exercice6);
		se6.setSeance(seance);
		se6.setOrdreSeance(1);
		se6.setOrdreExercice(6);
		se6.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se6);

		se7 = new SeanceExercice();

		se7.setExercice(exercice7);
		se7.setSeance(seance2);
		se7.setOrdreSeance(2);
		se7.setOrdreExercice(1);
		se7.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se7);

		se8 = new SeanceExercice();

		se8.setExercice(exercice8);
		se8.setSeance(seance2);
		se8.setOrdreSeance(2);
		se8.setOrdreExercice(2);
		se8.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se8);

		se9 = new SeanceExercice();

		se9.setExercice(exercice9);
		se9.setSeance(seance2);
		se9.setOrdreSeance(2);
		se9.setOrdreExercice(3);
		se9.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se9);

		se10 = new SeanceExercice();

		se10.setExercice(exercice10);
		se10.setSeance(seance2);
		se10.setOrdreSeance(2);
		se10.setOrdreExercice(4);
		se10.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se10);

		se11 = new SeanceExercice();

		se11.setExercice(exercice11);
		se11.setSeance(seance2);
		se11.setOrdreSeance(2);
		se11.setOrdreExercice(5);
		se11.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se11);

		se12 = new SeanceExercice();

		se12.setExercice(exercice12);
		se12.setSeance(seance2);
		se12.setOrdreSeance(2);
		se12.setOrdreExercice(6);
		se12.setTypeExercice(TypeExercice.PREDEFINI_REPETITION);
		entityManager.persist(se12);

		se13 = new SeanceExercice();

		se13.setExercice(exercice8);
		se13.setSeance(seance2);
		se13.setOrdreSeance(2);
		se13.setOrdreExercice(7);
		se13.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se13);

		se14 = new SeanceExercice();

		se14.setExercice(exercice9);
		se14.setSeance(seance2);
		se14.setOrdreSeance(2);
		se14.setOrdreExercice(8);
		se14.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se14);

		se15 = new SeanceExercice();

		se15.setExercice(exercice10);
		se15.setSeance(seance2);
		se15.setOrdreSeance(2);
		se15.setOrdreExercice(9);
		se15.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se15);

		se16 = new SeanceExercice();

		se16.setExercice(exercice11);
		se16.setSeance(seance2);
		se16.setOrdreSeance(2);
		se16.setOrdreExercice(10);
		se16.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se16);

		se17 = new SeanceExercice();

		se17.setExercice(exercice12);
		se17.setSeance(seance2);
		se17.setOrdreSeance(2);
		se17.setOrdreExercice(11);
		se17.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se17);
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
		} else {
			admin = userRepo.getUserByUsername("admin");
		}

		if (!userRepo.usernameExists("chleo")) {
			u1 = new User("chleo", "chleo", "chleo@chleo", "chleo", "chleo", new Date(634815155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u1);
		} else {
			u1 = userRepo.getUserByUsername("chleo");
		}

		if (!userRepo.usernameExists("georges")) {
			u2 = new User("georges", "georges", "georges@georges", "georges", "georges", new Date(697887155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u2);
		} else {
			u2 = userRepo.getUserByUsername("georges");
		}

		if (!userRepo.usernameExists("jd")) {
			u3 = new User("jd", "jd", "jd@jd", "jd", "jd", new Date(697887155L), Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u3);
		} else {
			u3 = userRepo.getUserByUsername("jd");
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