package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.Areas;
import com.ajh.aijihui.service.AreasService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("areas")
@CrossOrigin(origins = {"*","null"})
public class AreasController {

    @Autowired
    private AreasService areasService;
     @RequestMapping("getAreas")
        public ResponseVO getAreas(Areas areas){
            Areas areas1 = areasService.getAreas(areas);
            return new ResponseVO(areas1);
        }
       @RequestMapping("listAreas")
        public ResponseVO listAreas(Areas areas, Integer pageNo, Integer pageSize ){
            Object object =  areasService.listAreas(areas,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertAreas")
        public ResponseVO insertAreas(Areas areas){
            areasService.addAreas(areas);
            return new ResponseVO(true);
        }
       @RequestMapping("insertAreass")
       public ResponseVO insertAreass(@RequestBody List<Areas> areass){
           for (Areas areas : areass) {
               areasService.addAreas(areas);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteAreas")
          public Object deleteAreas(Areas areas){
              areasService.deleteAreas(areas);
              return new ResponseVO(true);
          }
           @RequestMapping("updateAreas")
           public Object updateAreas(Areas areas){
               areasService.updateAreas(areas);
               return new ResponseVO(true);
           }
}