package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.AjhPri;
import com.ajh.aijihui.mapper.AjhPriMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjhPriService {

    @Autowired
    private AjhPriMapper ajhPriMapper;

    public boolean addAjhPri(AjhPri ajhPri) {
        ajhPriMapper.insert(ajhPri);
        return true;
    }

   public boolean deleteAjhPri(AjhPri ajhPri) {
           ajhPriMapper.delete(ajhPri);
           return true;
       }

    public boolean updateAjhPri(AjhPri ajhPri) {
        ajhPriMapper.updateByPrimaryKeySelective(ajhPri);
        return true;
    }

    public AjhPri getAjhPri(AjhPri ajhPri) {
        return  ajhPriMapper.selectOne(ajhPri);
    }

    public List<AjhPri> listAjhPri() {
        return ajhPriMapper.selectAll();
    }
     public Object listAjhPri(AjhPri ajhPri, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<AjhPri> ajhPris= ajhPriMapper.select(ajhPri);
                PageInfo<AjhPri> pageInfo = new PageInfo<>(ajhPris);
                Long total = pageInfo.getTotal();
                List<AjhPri> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<AjhPri> ajhPris = ajhPriMapper.select(ajhPri);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(ajhPris);
            }
            return paginationInfo;
        }
}