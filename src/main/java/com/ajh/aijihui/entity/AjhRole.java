package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_role")
public class AjhRole {

        @Id
        private String id;
        @Column(name = "role_name")
        private String roleName;
        private String comment;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}