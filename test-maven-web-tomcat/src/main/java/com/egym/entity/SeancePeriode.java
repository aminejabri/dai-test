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
@Table(name = "SEANCE_PERIODE")
public class SeancePeriode {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPE_ID")
	Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Periode.class)
    @JoinColumn(name="SPE_PER_ID")
    Periode periode;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity= Seance.class)
    @JoinColumn(name="SPE_SEA_ID")
	Seance seance;
	
    @Column(name="SPE_ORDRE_SEA")
    Integer ordreSeance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Integer getOrdreSeance() {
		return ordreSeance;
	}

	public void setOrdreSeance(Integer ordreSeance) {
		this.ordreSeance = ordreSeance;
	}



}
