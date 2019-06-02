package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_pri")
public class AjhPri {

        @Id
        private Integer id;
        @Column(name = "role_id")
        private Integer roleId;
        private Integer privilege;
        private String comment;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Integer getPrivilege() {
        return privilege;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}