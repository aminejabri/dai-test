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
@Table(name = "COMPOSER_PER_PRO")
public class PeriodeProgramme {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPP_ID")
	Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Programme.class)
    @JoinColumn(name="CPP_PROG_ID")
	Programme programme;
    

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= User.class)
    @JoinColumn(name="CPP_UTIL_ID")
	User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Periode.class)
    @JoinColumn(name="CPP_PER_ID")
    Periode periode;

    @Column(name="CPP_ORDRE_PER")
    Integer ordrePeriode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Integer getOrdrePeriode() {
		return ordrePeriode;
	}

	public void setOrdrePeriode(Integer ordrePeriode) {
		this.ordrePeriode = ordrePeriode;
	}

    

}
