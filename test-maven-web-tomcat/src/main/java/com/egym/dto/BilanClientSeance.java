package com.egym.dto;

import java.io.Serializable;
import java.util.List;

import com.egym.entity.Bilan;
import com.egym.entity.ExerciceClient;

public class BilanClientSeance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Bilan bilan;

	List<ExerciceClient> exercicesClient;

	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
	}

	public List<ExerciceClient> getExercicesClient() {
		return exercicesClient;
	}

	public void setExercicesClient(List<ExerciceClient> exercicesClient) {
		this.exercicesClient = exercicesClient;
	}

}
