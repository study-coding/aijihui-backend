package com.ajh.aijihui.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "ajh_product")
public class AjhProduct {

	@Id
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "pri_price")
	private BigDecimal priPrice;
	@Column(name = "now_price")
	private BigDecimal nowPrice;
	@Column(name = "kind_id")
	private Integer kindId;
	@Column(name = "band_id")
	private Integer bandId;
	@Column(name = "publish_status")
	private String publishStatus;
	private String degree;
	@Column(name = "use_date")
	private String useDate;
	@Column(name = "is_repair")
	private String isRepair;
	@Column(name = "is_water")
	private String isWater;
	@Column(name = "pic_url")
	private String picUrl;
	private String color;

	@Transient
	private String kindName;

	@Transient
	private String bandName;

	@Transient
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setPriPrice(BigDecimal priPrice) {
		this.priPrice = priPrice;
	}

	public BigDecimal getPriPrice() {
		return priPrice;
	}

	public void setNowPrice(BigDecimal nowPrice) {
		this.nowPrice = nowPrice;
	}

	public BigDecimal getNowPrice() {
		return nowPrice;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public Integer getKindId() {
		return kindId;
	}

	public void setBandId(Integer bandId) {
		this.bandId = bandId;
	}

	public Integer getBandId() {
		return bandId;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getPublishStatus() {
		return publishStatus;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setIsRepair(String isRepair) {
		this.isRepair = isRepair;
	}

	public String getIsRepair() {
		return isRepair;
	}

	public void setIsWater(String isWater) {
		this.isWater = isWater;
	}

	public String getIsWater() {
		return isWater;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}