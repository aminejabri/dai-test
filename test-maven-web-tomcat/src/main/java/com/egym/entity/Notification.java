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
@Table(name = "NOTIFICATIONS")
public class Notification {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOT_ID")
	Integer id;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity= User.class)
    @JoinColumn(name="NOT_UTIL_ID_OUT")
	User emetteur;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity= User.class)
    @JoinColumn(name="NOT_UTIL_ID_IN")
	User recepteur;
	
    @Column(name="NOT_MESSAGE")
    String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(User emetteur) {
		this.emetteur = emetteur;
	}

	public User getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(User recepteur) {
		this.recepteur = recepteur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
