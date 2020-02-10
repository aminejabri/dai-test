package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCICE")
public class Exercice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXE_ID")
	Integer id;

	@Column(name = "EXE_IMG")
	String imageUrl;

	@Column(name = "EXE_DESCRI")
	String description;
	
}
