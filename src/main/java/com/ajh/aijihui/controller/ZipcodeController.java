package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.Zipcode;
import com.ajh.aijihui.service.ZipcodeService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zipcode")
@CrossOrigin(origins = {"*","null"})
public class ZipcodeController {

    @Autowired
    private ZipcodeService zipcodeService;
     @RequestMapping("getZipcode")
        public ResponseVO getZipcode(Zipcode zipcode){
            Zipcode zipcode1 = zipcodeService.getZipcode(zipcode);
            return new ResponseVO(zipcode1);
        }
       @RequestMapping("listZipcode")
        public ResponseVO listZipcode(Zipcode zipcode, Integer pageNo, Integer pageSize ){
            Object object =  zipcodeService.listZipcode(zipcode,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertZipcode")
        public ResponseVO insertZipcode(Zipcode zipcode){
            zipcodeService.addZipcode(zipcode);
            return new ResponseVO(true);
        }
       @RequestMapping("insertZipcodes")
       public ResponseVO insertZipcodes(@RequestBody List<Zipcode> zipcodes){
           for (Zipcode zipcode : zipcodes) {
               zipcodeService.addZipcode(zipcode);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteZipcode")
          public Object deleteZipcode(Zipcode zipcode){
              zipcodeService.deleteZipcode(zipcode);
              return new ResponseVO(true);
          }
           @RequestMapping("updateZipcode")
           public Object updateZipcode(Zipcode zipcode){
               zipcodeService.updateZipcode(zipcode);
               return new ResponseVO(true);
           }
}