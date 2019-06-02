package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.AjhRole;
import com.ajh.aijihui.mapper.AjhRoleMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjhRoleService {

    @Autowired
    private AjhRoleMapper ajhRoleMapper;

    public boolean addAjhRole(AjhRole ajhRole) {
        ajhRoleMapper.insert(ajhRole);
        return true;
    }

   public boolean deleteAjhRole(AjhRole ajhRole) {
           ajhRoleMapper.delete(ajhRole);
           return true;
       }

    public boolean updateAjhRole(AjhRole ajhRole) {
        ajhRoleMapper.updateByPrimaryKeySelective(ajhRole);
        return true;
    }

    public AjhRole getAjhRole(AjhRole ajhRole) {
        return  ajhRoleMapper.selectOne(ajhRole);
    }

    public List<AjhRole> listAjhRole() {
        return ajhRoleMapper.selectAll();
    }
     public Object listAjhRole(AjhRole ajhRole, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<AjhRole> ajhRoles= ajhRoleMapper.select(ajhRole);
                PageInfo<AjhRole> pageInfo = new PageInfo<>(ajhRoles);
                Long total = pageInfo.getTotal();
                List<AjhRole> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<AjhRole> ajhRoles = ajhRoleMapper.select(ajhRole);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(ajhRoles);
            }
            return paginationInfo;
        }
}