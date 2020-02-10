package com.egym.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BILAN")
public class Bilan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BIL_ID")
    Integer id;

    
    @Column(name = "BIL_FCREPOS", nullable = false, unique = true)
    Double freqCardiaqueRepos;
    
    @Column(name = "BIL_FCCIBLE", nullable = false, unique = true)
    Double freqCardiaqueCible;
    
    @Column(name = "BIL_FCMAX", nullable = false, unique = true)
    Double freqCardiaqueMax;
    
    @Column(name = "BIL_POIDS", nullable = false, unique = true)
    Double poid;
    
    @Column(name = "BIL_INDICEDICKSON", nullable = false, unique = true)
    Double indiceDickson;
    
    @OneToOne(mappedBy = "bilan", fetch = FetchType.LAZY)
    SeanceClient seanceClient;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public SeanceClient getSeance() {
		return seanceClient;
	}


	public void setSeance(SeanceClient seance) {
		this.seanceClient = seance;
	}


	public Double getFreqCardiaqueRepos() {
		return freqCardiaqueRepos;
	}


	public void setFreqCardiaqueRepos(Double freqCardiaqueRepos) {
		this.freqCardiaqueRepos = freqCardiaqueRepos;
	}


	public Double getFreqCardiaqueCible() {
		return freqCardiaqueCible;
	}


	public void setFreqCardiaqueCible(Double freqCardiaqueCible) {
		this.freqCardiaqueCible = freqCardiaqueCible;
	}


	public Double getFreqCardiaqueMax() {
		return freqCardiaqueMax;
	}


	public void setFreqCardiaqueMax(Double freqCardiaqueMax) {
		this.freqCardiaqueMax = freqCardiaqueMax;
	}


	public Double getPoid() {
		return poid;
	}


	public void setPoid(Double poid) {
		this.poid = poid;
	}


	public Double getIndiceDickson() {
		return indiceDickson;
	}


	public void setIndiceDickson(Double indiceDickson) {
		this.indiceDickson = indiceDickson;
	}

}
