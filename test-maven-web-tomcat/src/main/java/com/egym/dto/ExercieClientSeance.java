package com.egym.dto;

import java.io.Serializable;

import com.egym.entity.ExerciceClient;
import com.egym.entity.SeanceClient;

public class ExercieClientSeance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ExerciceClient exerciceClient;

	SeanceClient seanceClient;

	public ExercieClientSeance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExercieClientSeance(ExerciceClient exerciceClient, SeanceClient seanceClient) {
		super();
		this.exerciceClient = exerciceClient;
		this.seanceClient = seanceClient;
	}

	public ExerciceClient getExerciceClient() {
		return exerciceClient;
	}

	public void setExerciceClient(ExerciceClient exerciceClient) {
		this.exerciceClient = exerciceClient;
	}

	public SeanceClient getSeanceClient() {
		return seanceClient;
	}

	public void setSeanceClient(SeanceClient seanceClient) {
		this.seanceClient = seanceClient;
	}
}
