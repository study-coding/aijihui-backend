package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_order")
public class AjhOrder {

	@Id
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "order_type")
	private String orderType;

	@Transient
	private String userName;
	@Transient
	private String url;
	@Transient
	private String productName;
	@Transient
	private String nowPrice;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderType() {
		return orderType;
	}

}