package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhKind;
import com.ajh.aijihui.service.AjhKindService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajhKind")
@CrossOrigin(origins = {"*","null"})
public class AjhKindController {

    @Autowired
    private AjhKindService ajhKindService;
     @RequestMapping("getAjhKind")
        public ResponseVO getAjhKind(AjhKind ajhKind){
            AjhKind ajhKind1 = ajhKindService.getAjhKind(ajhKind);
            return new ResponseVO(ajhKind1);
        }
       @RequestMapping("listAjhKind")
        public ResponseVO listAjhKind(AjhKind ajhKind, Integer pageNo, Integer pageSize ){
            Object object =  ajhKindService.listAjhKind(ajhKind,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertAjhKind")
        public ResponseVO insertAjhKind(AjhKind ajhKind){
            ajhKindService.addAjhKind(ajhKind);
            return new ResponseVO(true);
        }
       @RequestMapping("insertAjhKinds")
       public ResponseVO insertAjhKinds(@RequestBody List<AjhKind> ajhKinds){
           for (AjhKind ajhKind : ajhKinds) {
               ajhKindService.addAjhKind(ajhKind);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteAjhKind")
          public Object deleteAjhKind(AjhKind ajhKind){
              ajhKindService.deleteAjhKind(ajhKind);
              return new ResponseVO(true);
          }
           @RequestMapping("updateAjhKind")
           public Object updateAjhKind(AjhKind ajhKind){
               ajhKindService.updateAjhKind(ajhKind);
               return new ResponseVO(true);
           }
}