package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "provinces")
public class Provinces {

        @Id
        private Integer id;
        @Column(name = "province_id")
        private String provinceId;
        private String province;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceId() {
        return provinceId;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

}