package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "ajh_kind")
public class AjhKind {

        @Id
        private Integer id;
        @Column(name = "kind_name")
        private String kindName;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindName() {
        return kindName;
    }

}