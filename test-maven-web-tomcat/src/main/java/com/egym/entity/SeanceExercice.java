package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPOSER_SEA_EXE")
public class SeanceExercice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSE_ID")
	Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity= Seance.class)
    @JoinColumn(name="CSE_SEA_ID")
	Seance seance;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity= Exercice.class)
    @JoinColumn(name="CSE_EXE_ID")
	Exercice exercice;

	@Column(name = "CSE_ORDRE",nullable = false)
    Integer ordreExercice;

	@Column(name = "CSE_CHRONO",nullable = false)
    Integer chrono;

	@Column(name = "CSE_REPETITION",nullable = false)
    Integer repetition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Integer getOrdreExercice() {
		return ordreExercice;
	}

	public void setOrdreExercice(Integer ordreExercice) {
		this.ordreExercice = ordreExercice;
	}

	public Integer getChrono() {
		return chrono;
	}

	public void setChrono(Integer chrono) {
		this.chrono = chrono;
	}

	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

}
