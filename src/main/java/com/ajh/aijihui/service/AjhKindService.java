package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.AjhKind;
import com.ajh.aijihui.mapper.AjhKindMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjhKindService {

    @Autowired
    private AjhKindMapper ajhKindMapper;

    public boolean addAjhKind(AjhKind ajhKind) {
        ajhKindMapper.insert(ajhKind);
        return true;
    }

   public boolean deleteAjhKind(AjhKind ajhKind) {
           ajhKindMapper.delete(ajhKind);
           return true;
       }

    public boolean updateAjhKind(AjhKind ajhKind) {
        ajhKindMapper.updateByPrimaryKeySelective(ajhKind);
        return true;
    }

    public AjhKind getAjhKind(AjhKind ajhKind) {
        return  ajhKindMapper.selectOne(ajhKind);
    }

    public List<AjhKind> listAjhKind() {
        return ajhKindMapper.selectAll();
    }
     public Object listAjhKind(AjhKind ajhKind, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<AjhKind> ajhKinds= ajhKindMapper.select(ajhKind);
                PageInfo<AjhKind> pageInfo = new PageInfo<>(ajhKinds);
                Long total = pageInfo.getTotal();
                List<AjhKind> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<AjhKind> ajhKinds = ajhKindMapper.select(ajhKind);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(ajhKinds);
            }
            return paginationInfo;
        }
}