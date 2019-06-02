package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "zipcode")
public class Zipcode {

        @Id
        private Integer id;
        @Column(name = "area_id")
        private String areaId;
        private String zip;
        private String code;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaId() {
        return areaId;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}