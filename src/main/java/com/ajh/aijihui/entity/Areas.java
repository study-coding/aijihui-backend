package com.ajh.aijihui.entity;

import javax.persistence.*;

@Table(name = "areas")
public class Areas {

        @Id
        private Integer id;
        @Column(name = "area_id")
        private String areaId;
        private String area;
        @Column(name = "city_id")
        private String cityId;

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
    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityId() {
        return cityId;
    }

}