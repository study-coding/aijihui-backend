package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhPri;
import com.ajh.aijihui.service.AjhPriService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajhPri")
@CrossOrigin(origins = {"*","null"})
public class AjhPriController {

    @Autowired
    private AjhPriService ajhPriService;
     @RequestMapping("getAjhPri")
        public ResponseVO getAjhPri(AjhPri ajhPri){
            AjhPri ajhPri1 = ajhPriService.getAjhPri(ajhPri);
            return new ResponseVO(ajhPri1);
        }
       @RequestMapping("listAjhPri")
        public ResponseVO listAjhPri(AjhPri ajhPri, Integer pageNo, Integer pageSize ){
            Object object =  ajhPriService.listAjhPri(ajhPri,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertAjhPri")
        public ResponseVO insertAjhPri(AjhPri ajhPri){
            ajhPriService.addAjhPri(ajhPri);
            return new ResponseVO(true);
        }
       @RequestMapping("insertAjhPris")
       public ResponseVO insertAjhPris(@RequestBody List<AjhPri> ajhPris){
           for (AjhPri ajhPri : ajhPris) {
               ajhPriService.addAjhPri(ajhPri);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteAjhPri")
          public Object deleteAjhPri(AjhPri ajhPri){
              ajhPriService.deleteAjhPri(ajhPri);
              return new ResponseVO(true);
          }



           @RequestMapping("updateAjhPri")
           public Object updateAjhPri(AjhPri ajhPri){
               ajhPriService.updateAjhPri(ajhPri);
               return new ResponseVO(true);
           }
}