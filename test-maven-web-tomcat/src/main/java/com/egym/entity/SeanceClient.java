package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.egym.entity.enums.StatutSeance;

@Entity
@Table(name = "UTIL_SEANCE")
public class SeanceClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTS_ID")
	Integer id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Seance.class)
	@JoinColumn(name = "UTS_SEA_ID")
	Seance seance;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Programme.class)
	@JoinColumn(name = "UTS_PROG_ID")
	Programme programme;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "UTS_UTIL_ID")
	User client;

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Bilan.class)
	@JoinColumn(name = "UTS_BIL_ID")
	Bilan bilan;

	@Column(name = "UTS_ORDRE", nullable = false)
	Integer ordreSeance;

	@Column(name = "UTS_STATUT", nullable = false)
	StatutSeance status;

	@Column(name = "UTS_EVALUATION", nullable = false)
	Integer evaluation;

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public StatutSeance getStatus() {
		return status;
	}

	public void setStatus(StatutSeance status) {
		this.status = status;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
	}

	public Integer getOrdreSeance() {
		return ordreSeance;
	}

	public void setOrdreSeance(Integer ordreSeance) {
		this.ordreSeance = ordreSeance;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

}
