package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROFIL")
public class Profil {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
	Integer id;

    @Column(name = "PRO_MES_POITRINE")
	Double poitrine;

    @Column(name = "PRO_MES_TAILLE")
	Double taille;

    @Column(name = "PRO_MES_HANCHE")
	Double hanche;

    @Column(name = "PRO_MES_CUISSEG")
	Double cuisse;
    
    // c'est quoi ?????
    @Column(name = "PRO_OBJ")
	String obj;

	@Column(name = "PRO_MES_BRASG")
	Double bras;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = User.class)
    @JoinColumn(name = "PRO_UTIL_ID")
	User client;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPoitrine() {
		return poitrine;
	}

	public void setPoitrine(Double poitrine) {
		this.poitrine = poitrine;
	}

	public Double getTaille() {
		return taille;
	}

	public void setTaille(Double taille) {
		this.taille = taille;
	}

	public Double getHanche() {
		return hanche;
	}

	public void setHanche(Double hanche) {
		this.hanche = hanche;
	}

	public Double getCuisse() {
		return cuisse;
	}

	public void setCuisse(Double cuisse) {
		this.cuisse = cuisse;
	}

	public Double getBras() {
		return bras;
	}

	public void setBras(Double bras) {
		this.bras = bras;
	}
    
    public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
}
