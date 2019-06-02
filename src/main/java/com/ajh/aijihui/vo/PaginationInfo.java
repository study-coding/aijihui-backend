package com.ajh.aijihui.vo;

public class PaginationInfo {

	private Integer total ;
	private Object  pagination ;
	
	public PaginationInfo() {
	}

	public PaginationInfo(Integer total, Object data) {
		this.total = total;
		this.pagination = data;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getPagination() {
		return pagination;
	}
	public void setPagination(Object pagination) {
		this.pagination = pagination;
	}
	
	
}
