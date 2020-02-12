package com.egym.repositories;


import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
import com.egym.entity.enums.TypeSeance;

@Transactional
@Repository
public class TestRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	UserRepository userRepo;
	
	@Transactional
	public void createUser() {
		
		User admin;
		if(!userRepo.usernameExists("admin")) {
			admin = new User("admin", "admin", "admin@admin", "admin", "usadminer", Arrays.asList(RoleEnum.values()));
			entityManager.persist(admin);
		}
		
		User u1;
		if(!userRepo.usernameExists("user")) {
			u1 = new User("user", "user", "user@user", "user", "user", Arrays.asList(RoleEnum.ROLE_USER));
			entityManager.persist(u1);
		}
	}
	

	
	@Transactional(rollbackFor= Exception.class)
	public void createInstance(User u1,User u2) {
		

		Profil profil = new Profil();
		profil.setPoitrine(10.);
		profil.setTaille(10.);
		profil.setHanche(10.);
		profil.setCuisse(10.);
		profil.setBras(10.);
		profil.setObj("cest quoi");
		profil.setClient(u1);

		entityManager.persist(profil);

		Programme programme = new Programme("p2", 1);
		
		entityManager.persist(programme);

		ProgrammeClient pg  = new ProgrammeClient();
		
		pg.setProgramme(programme);
		pg.setUser(u1);
		
		
		pg.setProgramme(programme);
		pg.setUser(u1);
		
		entityManager.persist(pg);
		
		SeanceProgramme sp  = new SeanceProgramme();
		Seance seance  = new Seance();
		
		sp.setProgramme(programme);
		sp.setSeance(seance);
		sp.setOrdreSeance(1);
		
		entityManager.persist(programme);
		entityManager.persist(seance);
		entityManager.persist( sp);
		
		seance.setType(TypeSeance.BILAN);
		
		SeanceClient sc = new SeanceClient();

		sc.setProgramme(programme);
		sc.setSeance(seance);
		sc.setOrdreSeance(1);
		sc.setClient(u1);
		
		entityManager.persist(programme);
		entityManager.persist( sc);
		
		
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
		
		entityManager.persist(periode);
		entityManager.persist(pp);
		
		SeancePeriode spe = new SeancePeriode();
		spe.setOrdreSeance(1);
		spe.setPeriode(periode);
		spe.setSeance(seance);
		
		entityManager.persist(spe);
		
		Exercice exercice = new Exercice();
		exercice.setDescription("desc");
		entityManager.persist(exercice);

		ExerciceClient ec = new ExerciceClient();
		ec.setClient(u1);
		ec.setExercice(exercice);
		ec.setOrdreSeance(1);
		ec.setOrdreExercice(1);
		ec.setSeance(seance);
		ec.setProgramme(programme);
		entityManager.persist(ec);
		
		SeanceExercice se = new SeanceExercice();

		se.setExercice(exercice);
		se.setSeance(seance);
		se.setOrdreExercice(1);
		se.setChrono(10);
		entityManager.persist(se);

		Notification notification = new Notification();
		notification.setEmetteur(u1);
		notification.setRecepteur(u2);
		
		entityManager.persist(notification);

	}
}