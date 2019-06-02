package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.Cities;
import com.ajh.aijihui.mapper.CitiesMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;

    public boolean addCities(Cities cities) {
        citiesMapper.insert(cities);
        return true;
    }

   public boolean deleteCities(Cities cities) {
           citiesMapper.delete(cities);
           return true;
       }

    public boolean updateCities(Cities cities) {
        citiesMapper.updateByPrimaryKeySelective(cities);
        return true;
    }

    public Cities getCities(Cities cities) {
        return  citiesMapper.selectOne(cities);
    }

    public List<Cities> listCities() {
        return citiesMapper.selectAll();
    }
     public Object listCities(Cities cities, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<Cities> citiess= citiesMapper.select(cities);
                PageInfo<Cities> pageInfo = new PageInfo<>(citiess);
                Long total = pageInfo.getTotal();
                List<Cities> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<Cities> citiess = citiesMapper.select(cities);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(citiess);
            }
            return paginationInfo;
        }
}