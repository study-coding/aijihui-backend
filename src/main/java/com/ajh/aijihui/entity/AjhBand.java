package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_band")
public class AjhBand {

	@Id
	private Integer id;
	@Column(name = "band_name")
	private String bandName;
	@Column(name = "father_id")
	private Integer fatherId;

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBandName() {
		return bandName;
	}

}