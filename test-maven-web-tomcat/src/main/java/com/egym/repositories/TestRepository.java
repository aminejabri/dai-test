package com.egym.repositories;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egym.entity.Exercice;
import com.egym.entity.ExerciceClient;
import com.egym.entity.Notification;
import com.egym.entity.Profil;
import com.egym.entity.Programme;
import com.egym.entity.Seance;
import com.egym.entity.SeanceExercice;
import com.egym.entity.SeancePeriode;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.entity.enums.TypeExercice;
import com.egym.entity.enums.TypeProgramme;
import com.egym.entity.enums.TypeSeance;

@Transactional
@Repository
public class TestRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserRepository userRepo;

	@Transactional
	public void createUsers() {

		User admin;
		if (!userRepo.usernameExists("admin")) {
			admin = new User("admin", "admin", "admin@admin", "admin", "usadminer", new Date(634815155L),
					Arrays.asList(RoleEnum.values()));
			entityManager.persist(admin);
		}

		User u1;
		if (!userRepo.usernameExists("chleo")) {
			u1 = new User("chleo", "chleo", "chleo@chleo", "chleo", "chleo", new Date(634815155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u1);
		}

		User u2;
		if (!userRepo.usernameExists("georges")) {
			u2 = new User("georges", "georges", "georges@georges", "georges", "georges", new Date(697887155L),
					Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u2);
		}

		User u3;
		if (!userRepo.usernameExists("jd")) {
			u3 = new User("jd", "jd", "jd@jd", "jd", "jd", new Date(697887155L), Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u3);
		}
	}

	Programme programme;
	Programme programme1;
	Programme programme2;

	void createProgrammes() {

		programme = new Programme();
		programme.setNom("prog1");
		programme.setType(TypeProgramme.NORMAL);

		entityManager.persist(programme);

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
	SeanceProgramme sp;
	SeanceProgramme sp2;
	SeanceProgramme sp3;

	void createSeances() {

		seance = new Seance();
		seance2 = new Seance();
		seance.setType(TypeSeance.BILAN);
		seance2.setType(TypeSeance.NORMAL);

		sp = new SeanceProgramme();
		sp2 = new SeanceProgramme();
		sp3 = new SeanceProgramme();

		sp.setProgramme(programme);
		sp.setSeance(seance);
		sp.setOrdreSeance(1);

		sp.setProgramme(programme);
		sp.setSeance(seance2);
		sp.setOrdreSeance(2);

		sp2.setProgramme(programme1);
		sp2.setSeance(seance);
		sp2.setOrdreSeance(1);

		sp3.setProgramme(programme2);
		sp3.setSeance(seance2);
		sp3.setOrdreSeance(1);

		sp3.setProgramme(programme2);
		sp3.setSeance(seance2);
		sp3.setOrdreSeance(2);

		entityManager.persist(seance);
		entityManager.persist(seance2);
		entityManager.persist(sp);
		entityManager.persist(sp2);
		entityManager.persist(sp3);

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

	}

	@Transactional(rollbackFor = Exception.class)
	public void createInstance(List<User> users) {

		Profil profil = new Profil();
		profil.setPoitrine(10.);
		profil.setTaille(10.);
		profil.setHanche(10.);
		profil.setCuisse(10.);
		profil.setBras(10.);
		profil.setObj("cest quoi");
		profil.setClient(users.get(0));

		entityManager.persist(profil);

		Profil profil1 = new Profil();
		profil1.setPoitrine(20.);
		profil1.setTaille(20.);
		profil1.setHanche(20.);
		profil1.setCuisse(20.);
		profil1.setBras(20.);
		profil1.setObj("cest quoi");
		profil1.setClient(users.get(1));

		entityManager.persist(profil1);

		Profil profil2 = new Profil();
		profil2.setPoitrine(30.);
		profil2.setTaille(30.);
		profil2.setHanche(30.);
		profil2.setCuisse(30.);
		profil2.setBras(30.);
		profil2.setObj("cest quoi");
		profil2.setClient(users.get(2));

		entityManager.persist(profil2);

		createProgrammes();

		createSeances();

		createPeriodes();
		// ProgrammeClient pg = new ProgrammeClient();
		//
		// pg.setProgramme(programme);
		// pg.setUser(users.get(0));
		//
		// entityManager.persist(pg);
		//
		// ProgrammeClient pg1 = new ProgrammeClient();
		//
		// pg1.setProgramme(programme);
		// pg1.setUser(users.get(0));
		//
		// pg1.setProgramme(programme);
		// pg1.setUser(users.get(1));
		//
		// entityManager.persist(pg1);

		// SeanceClient sc = new SeanceClient();
		// SeanceClient sc2 = new SeanceClient();
		//
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

		// sc.setBilan(bilan);
		// sc.setProgramme(programme);
		// sc.setSeance(seance);
		// sc.setOrdreSeance(1);
		// sc.setClient(users.get(1));
		//
		// sc2.setProgramme(programme2);
		// sc2.setSeance(seance2);
		// sc2.setOrdreSeance(1);
		// sc2.setClient(users.get(2));
		//
		// entityManager.persist(bilan);
		// entityManager.persist(programme);
		// entityManager.persist(sc);
		//
		// entityManager.persist(bilan);
		// entityManager.persist(programme2);
		// entityManager.persist(sc2);

		SeancePeriode spe = new SeancePeriode();
		spe.setOrdreSeance(1);
		// spe.setPeriode(periode);
		spe.setSeance(seance);

		entityManager.persist(spe);

		SeancePeriode spe2 = new SeancePeriode();
		spe2.setOrdreSeance(2);
		// spe2.setPeriode(periode2);
		spe2.setSeance(seance2);

		entityManager.persist(spe2);

		Exercice exercice = new Exercice();
		exercice.setNom("Gainage");
		exercice.setDescription("desc");
		entityManager.persist(exercice);

		Exercice exercice2 = new Exercice();
		exercice2.setNom("Fentes avant");
		exercice2.setDescription("desc");
		entityManager.persist(exercice2);

		Exercice exercice3 = new Exercice();
		exercice3.setNom("Crunch");
		exercice3.setDescription("desc");
		entityManager.persist(exercice3);

		Exercice exercice4 = new Exercice();
		exercice4.setNom("1/2 pompes");
		exercice4.setDescription("desc");
		entityManager.persist(exercice4);

		Exercice exercice5 = new Exercice();
		exercice5.setNom("1/2 squat");
		exercice5.setDescription("desc");
		entityManager.persist(exercice5);

		Exercice exercice6 = new Exercice();
		exercice6.setNom("Dips");
		exercice6.setDescription("desc");
		entityManager.persist(exercice6);

		Exercice exercice7 = new Exercice();
		exercice7.setNom("Burpees");
		exercice7.setDescription("desc");
		entityManager.persist(exercice7);

		Exercice exercice8 = new Exercice();
		exercice8.setNom("Mountain climber");
		exercice8.setDescription("desc");
		entityManager.persist(exercice8);

		Exercice exercice9 = new Exercice();
		exercice9.setNom("Squat élastique");
		exercice9.setDescription("desc");
		entityManager.persist(exercice9);

		Exercice exercice10 = new Exercice();
		exercice10.setNom("Triceps");
		exercice10.setDescription("desc");
		entityManager.persist(exercice10);

		Exercice exercice11 = new Exercice();
		exercice11.setNom("Extension jambe avec élastique");
		exercice11.setDescription("desc");
		entityManager.persist(exercice11);

		ExerciceClient ec = new ExerciceClient();
		ec.setClient(users.get(0));
		ec.setExercice(exercice);
		ec.setOrdreSeance(1);
		ec.setOrdreExercice(1);
		ec.setSeance(seance);
		ec.setProgramme(programme);
		entityManager.persist(ec);

		ExerciceClient ec2 = new ExerciceClient();
		ec2.setClient(users.get(0));
		ec2.setExercice(exercice2);
		ec2.setOrdreSeance(1);
		ec2.setOrdreExercice(1);
		ec2.setSeance(seance);
		ec2.setProgramme(programme);
		entityManager.persist(ec2);

		ExerciceClient ec3 = new ExerciceClient();
		ec3.setClient(users.get(0));
		ec3.setExercice(exercice2);
		ec3.setOrdreSeance(1);
		ec3.setOrdreExercice(1);
		ec3.setSeance(seance2);
		ec3.setProgramme(programme);
		entityManager.persist(ec3);

		ExerciceClient ec4 = new ExerciceClient();
		ec4.setClient(users.get(1));
		ec4.setExercice(exercice2);
		ec4.setOrdreSeance(1);
		ec4.setOrdreExercice(1);
		ec4.setSeance(seance2);
		ec4.setProgramme(programme);
		entityManager.persist(ec4);

		ExerciceClient ec5 = new ExerciceClient();
		ec5.setClient(users.get(2));
		ec5.setExercice(exercice4);
		ec5.setOrdreSeance(1);
		ec5.setOrdreExercice(1);
		ec5.setSeance(seance2);
		ec5.setProgramme(programme2);
		entityManager.persist(ec5);

		ExerciceClient ec6 = new ExerciceClient();
		ec6.setClient(users.get(0));
		ec6.setExercice(exercice2);
		ec6.setOrdreSeance(1);
		ec6.setOrdreExercice(2);
		ec6.setSeance(seance2);
		ec6.setProgramme(programme);
		entityManager.persist(ec6);

		SeanceExercice se = new SeanceExercice();

		se.setExercice(exercice);
		se.setSeance(seance);
		se.setOrdreExercice(1);
		se.setTypeExercice(TypeExercice.PERFORMANCE_CHRONOMETRE);
		se.setOrdreSeance(1);
		entityManager.persist(se);

		SeanceExercice se2 = new SeanceExercice();

		se2.setExercice(exercice2);
		se2.setSeance(seance);
		se2.setOrdreExercice(2);
		se2.setOrdreSeance(1);
		se2.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se2);

		SeanceExercice se3 = new SeanceExercice();

		se3.setExercice(exercice);
		se3.setSeance(seance2);
		se3.setOrdreSeance(1);
		se3.setOrdreExercice(1);
		se3.setTypeExercice(TypeExercice.PREDEFINI_CHRONOMETRE);
		entityManager.persist(se3);

		SeanceExercice se4 = new SeanceExercice();

		se4.setExercice(exercice2);
		se4.setSeance(seance2);
		se4.setOrdreSeance(2);
		se4.setOrdreExercice(1);
		se4.setTypeExercice(TypeExercice.PERFORMANCE_REPETITION);
		entityManager.persist(se4);

		Notification notification = new Notification();
		notification.setEmetteur(users.get(0));
		notification.setRecepteur(users.get(2));

		entityManager.persist(notification);

		Notification notification2 = new Notification();
		notification2.setEmetteur(users.get(0));
		notification2.setRecepteur(users.get(2));

		entityManager.persist(notification2);

		Notification notification3 = new Notification();
		notification3.setEmetteur(users.get(1));
		notification3.setRecepteur(users.get(2));

		entityManager.persist(notification3);

	}

}