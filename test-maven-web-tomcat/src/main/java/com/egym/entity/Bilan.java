package com.egym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@Column(name = "BIL_FC_5MIN_ALLONGE", nullable = false, unique = true)
	Double freqCardiaque5minAllonge;

	@Column(name = "BIL_FC_30_FLEX", nullable = false, unique = true)
	Double freqCardiaque30Flex;

	@Column(name = "BIL_FC_1_MIN_EXO_ALLONGE", nullable = false, unique = true)
	Double freqCardiaque1min;

	public void setSeanceClient(SeanceClient seanceClient) {
		this.seanceClient = seanceClient;
	}

	@OneToOne(mappedBy = "bilan", fetch = FetchType.LAZY)
	SeanceClient seanceClient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void calculateFreqCardiaqueCible() {

		// acalculrr
		// freqCardiaqueCible = freqCardiaqueRepos + ( freqCardiaqueMax -
		// freqCardiaqueRepos );
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

	public Double getFreqCardiaque5minAllonge() {
		return freqCardiaque5minAllonge;
	}

	public void setFreqCardiaque5minAllonge(Double freqCardiaque5minAllonge) {
		this.freqCardiaque5minAllonge = freqCardiaque5minAllonge;
	}

	public Double getFreqCardiaque30Flex() {
		return freqCardiaque30Flex;
	}

	public void setFreqCardiaque30Flex(Double freqCardiaque30Flex) {
		this.freqCardiaque30Flex = freqCardiaque30Flex;
	}

	public Double getFreqCardiaque1min() {
		return freqCardiaque1min;
	}

	public void setFreqCardiaque1min(Double freqCardiaque1min) {
		this.freqCardiaque1min = freqCardiaque1min;
	}

	public SeanceClient getSeanceClient() {
		return seanceClient;
	}

}
