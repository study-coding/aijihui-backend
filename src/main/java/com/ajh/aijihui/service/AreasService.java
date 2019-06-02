package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.Areas;
import com.ajh.aijihui.mapper.AreasMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasService {

    @Autowired
    private AreasMapper areasMapper;

    public boolean addAreas(Areas areas) {
        areasMapper.insert(areas);
        return true;
    }

   public boolean deleteAreas(Areas areas) {
           areasMapper.delete(areas);
           return true;
       }

    public boolean updateAreas(Areas areas) {
        areasMapper.updateByPrimaryKeySelective(areas);
        return true;
    }

    public Areas getAreas(Areas areas) {
        return  areasMapper.selectOne(areas);
    }

    public List<Areas> listAreas() {
        return areasMapper.selectAll();
    }
     public Object listAreas(Areas areas, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<Areas> areass= areasMapper.select(areas);
                PageInfo<Areas> pageInfo = new PageInfo<>(areass);
                Long total = pageInfo.getTotal();
                List<Areas> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<Areas> areass = areasMapper.select(areas);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(areass);
            }
            return paginationInfo;
        }
}