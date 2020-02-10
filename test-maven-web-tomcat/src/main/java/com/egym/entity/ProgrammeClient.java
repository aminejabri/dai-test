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
@Table(name = "AFFECT_UTIL_PROGRA")
public class ProgrammeClient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUP_ID")
    private Integer idUser;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= User.class)
    @JoinColumn(name="AUP_UTIL_ID")
	User user;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Programme.class)
    @JoinColumn(name="AUP_PROG_ID")
	Programme programme;
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
}
