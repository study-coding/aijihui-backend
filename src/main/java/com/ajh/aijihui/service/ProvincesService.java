package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.Provinces;
import com.ajh.aijihui.mapper.ProvincesMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;

    public boolean addProvinces(Provinces provinces) {
        provincesMapper.insert(provinces);
        return true;
    }

   public boolean deleteProvinces(Provinces provinces) {
           provincesMapper.delete(provinces);
           return true;
       }

    public boolean updateProvinces(Provinces provinces) {
        provincesMapper.updateByPrimaryKeySelective(provinces);
        return true;
    }

    public Provinces getProvinces(Provinces provinces) {
        return  provincesMapper.selectOne(provinces);
    }

    public List<Provinces> listProvinces() {
        return provincesMapper.selectAll();
    }
     public Object listProvinces(Provinces provinces, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<Provinces> provincess= provincesMapper.select(provinces);
                PageInfo<Provinces> pageInfo = new PageInfo<>(provincess);
                Long total = pageInfo.getTotal();
                List<Provinces> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<Provinces> provincess = provincesMapper.select(provinces);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(provincess);
            }
            return paginationInfo;
        }
}