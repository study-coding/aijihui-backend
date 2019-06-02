package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "cities")
public class Cities {

        @Id
        private Integer id;
        @Column(name = "city_id")
        private String cityId;
        private String city;
        @Column(name = "province_id")
        private String provinceId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceId() {
        return provinceId;
    }

}