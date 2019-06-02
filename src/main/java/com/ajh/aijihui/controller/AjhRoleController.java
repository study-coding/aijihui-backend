package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhRole;
import com.ajh.aijihui.service.AjhRoleService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajhRole")
@CrossOrigin(origins = {"*","null"})
public class AjhRoleController {

    @Autowired
    private AjhRoleService ajhRoleService;
     @RequestMapping("getAjhRole")
        public ResponseVO getAjhRole(AjhRole ajhRole){
            AjhRole ajhRole1 = ajhRoleService.getAjhRole(ajhRole);
            return new ResponseVO(ajhRole1);
        }
       @RequestMapping("listAjhRole")
        public ResponseVO listAjhRole(AjhRole ajhRole, Integer pageNo, Integer pageSize ){
            Object object =  ajhRoleService.listAjhRole(ajhRole,pageNo,pageSize);
            return new ResponseVO(object);
       }
        @RequestMapping("insertAjhRole")
        public ResponseVO insertAjhRole(AjhRole ajhRole){
            ajhRoleService.addAjhRole(ajhRole);
            return new ResponseVO(true);
        }
       @RequestMapping("insertAjhRoles")
       public ResponseVO insertAjhRoles(@RequestBody List<AjhRole> ajhRoles){
           for (AjhRole ajhRole : ajhRoles) {
               ajhRoleService.addAjhRole(ajhRole);
           }
           return new ResponseVO(true);
       }
        @RequestMapping("deleteAjhRole")
          public Object deleteAjhRole(AjhRole ajhRole){
              ajhRoleService.deleteAjhRole(ajhRole);
              return new ResponseVO(true);
          }
           @RequestMapping("updateAjhRole")
           public Object updateAjhRole(AjhRole ajhRole){
               ajhRoleService.updateAjhRole(ajhRole);
               return new ResponseVO(true);
           }
}