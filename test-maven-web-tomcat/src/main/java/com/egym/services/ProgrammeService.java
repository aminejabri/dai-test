package com.egym.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egym.entity.Bilan;
import com.egym.entity.ExerciceClient;
import com.egym.entity.PeriodeProgramme;
import com.egym.entity.Programme;
import com.egym.entity.ProgrammeClient;
import com.egym.entity.SeanceClient;
import com.egym.entity.SeanceExercice;
import com.egym.entity.SeanceProgramme;
import com.egym.entity.User;
import com.egym.entity.enums.StatutExercice;
import com.egym.entity.enums.StatutSeance;
import com.egym.entity.enums.TypeSeance;
import com.egym.repositories.PeriodeRepository;
import com.egym.repositories.SeanceRepository;

@Service
public class ProgrammeService {

	@Autowired
	SeanceRepository seanceRepo;

	@Autowired
	PeriodeRepository periodeRepository;

	@PersistenceContext
	EntityManager entityManager;

	public void affecterProgrammeClient(User client, Programme programme) {

		ProgrammeClient programmeClient = new ProgrammeClient();
		programmeClient.setProgramme(programme);
		programmeClient.setUser(client);
		entityManager.persist(programmeClient);

		List<SeanceProgramme> seanceProgrammes = seanceRepo.getSeanceProgrammeByProgrammeId(programme.getId());

		createSeancesClient(seanceProgrammes, client);

		List<PeriodeProgramme> periodesProgramme = periodeRepository.getPeriodesByProgrammeId(programme.getId());

		createPeriodesProgramme(periodesProgramme, client);

		List<Integer> idSeances = seanceProgrammes.stream().map(x -> x.getSeance().getId())
				.collect(Collectors.toList());

		List<SeanceExercice> seanceExercices = seanceRepo.getSeanceExercicesBySeanceIds(idSeances);

		createExercicesClient(seanceExercices, programme, client);
	}

	/**
	 * création des périodes d'un programme pour un client
	 * 
	 * @param periodesProgramme
	 * @param client
	 */
	private void createPeriodesProgramme(List<PeriodeProgramme> periodesProgramme, User client) {

	}

	private void createPeriodes() {

	}

	/**
	 * création des séances d'un programme pour un client
	 * 
	 * @param seanceProgrammes
	 * @param client
	 */
	private void createSeancesClient(List<SeanceProgramme> seanceProgrammes, User client) {

		for (SeanceProgramme seanceProgramme : seanceProgrammes) {

			SeanceClient seanceClient = new SeanceClient();
			seanceClient.setClient(client);
			seanceClient.setOrdreSeance(seanceProgramme.getOrdreSeance());
			seanceClient.setProgramme(seanceClient.getProgramme());
			seanceClient.setSeance(seanceProgramme.getSeance());
			if (TypeSeance.BILAN.equals(seanceProgramme.getSeance().getType())) {
				Bilan bilan = new Bilan();
				bilan.setSeanceClient(seanceClient);
				seanceClient.setBilan(bilan);
				entityManager.persist(bilan);
			}
			seanceClient.setStatus(StatutSeance.A_COMMENCER);
			entityManager.persist(seanceClient);
		}
	}

	/**
	 * création des exercices d'une seance pour un client
	 * 
	 * @param seanceExercices
	 * @param client
	 */
	private void createExercicesClient(List<SeanceExercice> seanceExercices, Programme programme, User client) {

		for (SeanceExercice seanceExercice : seanceExercices) {

			ExerciceClient exerciceClient = new ExerciceClient();
			exerciceClient.setClient(client);
			exerciceClient.setExercice(seanceExercice.getExercice());
			exerciceClient.setSeance(seanceExercice.getSeance());
			exerciceClient.setOrdreExercice(seanceExercice.getOrdreExercice());
			exerciceClient.setOrdreSeance(seanceExercice.getOrdreSeance());
			exerciceClient.setStatut(StatutExercice.A_COMMENCER);
			exerciceClient.setProgramme(programme);
			entityManager.persist(exerciceClient);

		}
	}

}
