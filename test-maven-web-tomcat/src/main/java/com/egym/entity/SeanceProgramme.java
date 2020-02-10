package com.egym.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROG_SEANCE")
public class SeanceProgramme {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRS_ID")
	Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Seance.class)
    @JoinColumn(name="PRS_SEA_ID")
	Seance seance;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Programme.class)
    @JoinColumn(name="PRS_PROG_ID")
    Programme programme;
	
    @Column(name="PRS_ORDRE_SEANCE")
    Integer ordreSeance;
    
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

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public Integer getOrdreSeance() {
		return ordreSeance;
	}

	public void setOrdreSeance(Integer ordreSeance) {
		this.ordreSeance = ordreSeance;
	}
    
    
}
