package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.Provinces;
import com.ajh.aijihui.service.ProvincesService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("provinces")
@CrossOrigin(origins = {"*","null"})
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;
     @RequestMapping("getProvinces")
        public ResponseVO getProvinces(Provinces provinces){
            Provinces provinces1 = provincesService.getProvinces(provinces);
            return new ResponseVO(provinces1);
        }
       @RequestMapping("listProvinces")
        public ResponseVO listProvinces(Provinces provinces, Integer pageNo, Integer pageSize ){
            Object object =  provincesService.listProvinces(provinces,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertProvinces")
        public ResponseVO insertProvinces(Provinces provinces){
            provincesService.addProvinces(provinces);
            return new ResponseVO(true);
        }
       @RequestMapping("insertProvincess")
       public ResponseVO insertProvincess(@RequestBody List<Provinces> provincess){
           for (Provinces provinces : provincess) {
               provincesService.addProvinces(provinces);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteProvinces")
          public Object deleteProvinces(Provinces provinces){
              provincesService.deleteProvinces(provinces);
              return new ResponseVO(true);
          }
           @RequestMapping("updateProvinces")
           public Object updateProvinces(Provinces provinces){
               provincesService.updateProvinces(provinces);
               return new ResponseVO(true);
           }
}