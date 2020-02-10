package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.egym.entity.enums.TypeSeance;

@Entity
@Table(name = "SEANCE")
public class Seance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEA_ID")
	Integer id;
	
	
	@Column(name = "SEA_TYPE")
	@Enumerated(EnumType.ORDINAL)
	TypeSeance type;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public TypeSeance getType() {
		return type;
	}


	public void setType(TypeSeance type) {
		this.type = type;
	}
	
	
}
