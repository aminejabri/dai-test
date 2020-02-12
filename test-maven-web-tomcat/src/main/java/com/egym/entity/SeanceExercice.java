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

import com.egym.entity.enums.TypeExercice;

@Entity
@Table(name = "COMPOSER_SEA_EXE")
public class SeanceExercice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CSE_ID")
	Integer id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Seance.class)
	@JoinColumn(name = "CSE_SEA_ID")
	Seance seance;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Exercice.class)
	@JoinColumn(name = "CSE_EXE_ID")
	Exercice exercice;

	@Column(name = "CSE_ORDRE_EXE", nullable = false)
	Integer ordreExercice;

	@Column(name = "CSE_ORDRE_SEANCE", nullable = false)
	Integer ordreSeance;

	@Column(name = "CSE_TYPE_EXER", nullable = false)
	TypeExercice typeExercice;

	@Column(name = "CSE_PERF_PRED", nullable = true)
	Integer perfPredefini;

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

	public TypeExercice getTypeExercice() {
		return typeExercice;
	}

	public void setTypeExercice(TypeExercice typeExercice) {
		this.typeExercice = typeExercice;
	}

	public Integer getPerfPredefini() {
		return perfPredefini;
	}

	public void setPerfPredefini(Integer perfPredefini) {
		this.perfPredefini = perfPredefini;
	}

	public Integer getOrdreSeance() {
		return ordreSeance;
	}

	public void setOrdreSeance(Integer ordreSeance) {
		this.ordreSeance = ordreSeance;
	}

}
