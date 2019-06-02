package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.Cities;
import com.ajh.aijihui.service.CitiesService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cities")
@CrossOrigin(origins = {"*","null"})
public class CitiesController {

    @Autowired
    private CitiesService citiesService;
     @RequestMapping("getCities")
        public ResponseVO getCities(Cities cities){
            Cities cities1 = citiesService.getCities(cities);
            return new ResponseVO(cities1);
        }
       @RequestMapping("listCities")
        public ResponseVO listCities(Cities cities, Integer pageNo, Integer pageSize ){
            Object object =  citiesService.listCities(cities,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertCities")
        public ResponseVO insertCities(Cities cities){
            citiesService.addCities(cities);
            return new ResponseVO(true);
        }
       @RequestMapping("insertCitiess")
       public ResponseVO insertCitiess(@RequestBody List<Cities> citiess){
           for (Cities cities : citiess) {
               citiesService.addCities(cities);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteCities")
          public Object deleteCities(Cities cities){
              citiesService.deleteCities(cities);
              return new ResponseVO(true);
          }
           @RequestMapping("updateCities")
           public Object updateCities(Cities cities){
               citiesService.updateCities(cities);
               return new ResponseVO(true);
           }
}