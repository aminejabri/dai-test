package com.egym.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMME")
public class Programme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROG_ID")
	Integer id;

	@Column(name = "PROG_NOM", nullable = false, unique = true)
	String nom;

	@Column(name = "PROG_TYPE", nullable = false, unique = true)
	Integer type;

	@OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, orphanRemoval = true)
	List<ProgrammeClient> programmesClients = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<ProgrammeClient> getProgrammesClients() {
		return programmesClients;
	}

	public void setProgrammesClients(List<ProgrammeClient> programmesClients) {
		this.programmesClients = programmesClients;
	}

}
