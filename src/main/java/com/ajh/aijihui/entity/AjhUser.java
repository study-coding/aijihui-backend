package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_user")
public class AjhUser {

	@Id
	private Integer id;
	private String phone;
	private String password;
	@Column(name = "role_id")
	private String roleId;
	@Column(name = "register_date")
	private String registerDate;
	private String status;

	/**
	 * 记录角色名
	 */
	@Transient
	private String roleName;

	@Transient
	private String username;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}