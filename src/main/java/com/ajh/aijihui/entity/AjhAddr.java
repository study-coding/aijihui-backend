package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_addr")
public class AjhAddr {

	@Id
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	private String zip;
	@Column(name = "province_id")
	private String provinceId;
	@Column(name = "city_id")
	private String cityId;
	@Column(name = "area_id")
	private String areaId;
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}