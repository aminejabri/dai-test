package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.egym.entity.enums.NoteExercice;
import com.egym.entity.enums.StatutExercice;

@Entity
@Table(name = "UTIL_EXERCICE")
public class ExerciceClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UEX_ID")
	Integer id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Seance.class)
	@JoinColumn(name = "UEX_SEA_ID")
	Seance seance;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Programme.class)
	@JoinColumn(name = "UEX_PROG_ID")
	Programme programme;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "UEX_UTIL_ID")
	User client;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Exercice.class)
	@JoinColumn(name = "UEX_EXE_ID")
	Exercice exercice;

	@Column(name = "UEX_ORDRE_SEA", nullable = false)
	Integer ordreSeance;

	@Column(name = "UEX_ORDRE_EXER", nullable = false)
	Integer ordreExercice;

	@Column(name = "UEX_TYPE_EXE", nullable = true)
	Integer performance;

	@Column(name = "UEX_NOTE", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	NoteExercice note;

	@Column(name = "UEX_COMMENTAIRE", nullable = false)
	String commentaire;

	@Column(name = "UEX_STATUT", nullable = false)
	StatutExercice statut;

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

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Integer getOrdreSeance() {
		return ordreSeance;
	}

	public void setOrdreSeance(Integer ordreSeance) {
		this.ordreSeance = ordreSeance;
	}

	public Integer getOrdreExercice() {
		return ordreExercice;
	}

	public void setOrdreExercice(Integer ordreExercice) {
		this.ordreExercice = ordreExercice;
	}

	public NoteExercice getNote() {
		return note;
	}

	public void setNote(NoteExercice note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public StatutExercice getStatut() {
		return statut;
	}

	public void setStatut(StatutExercice statut) {
		this.statut = statut;
	}

	public Integer getPerformance() {
		return performance;
	}

	public void setPerformance(Integer performance) {
		this.performance = performance;
	}

}
