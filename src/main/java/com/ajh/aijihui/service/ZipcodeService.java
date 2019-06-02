package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.Zipcode;
import com.ajh.aijihui.mapper.ZipcodeMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipcodeService {

    @Autowired
    private ZipcodeMapper zipcodeMapper;

    public boolean addZipcode(Zipcode zipcode) {
        zipcodeMapper.insert(zipcode);
        return true;
    }

   public boolean deleteZipcode(Zipcode zipcode) {
           zipcodeMapper.delete(zipcode);
           return true;
       }

    public boolean updateZipcode(Zipcode zipcode) {
        zipcodeMapper.updateByPrimaryKeySelective(zipcode);
        return true;
    }

    public Zipcode getZipcode(Zipcode zipcode) {
        return  zipcodeMapper.selectOne(zipcode);
    }

    public List<Zipcode> listZipcode() {
        return zipcodeMapper.selectAll();
    }
     public Object listZipcode(Zipcode zipcode, Integer pageNo, Integer pageSize) {
            PaginationInfo paginationInfo = new PaginationInfo();
            if(pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1){
                PageHelper.startPage(pageNo, pageSize);
                List<Zipcode> zipcodes= zipcodeMapper.select(zipcode);
                PageInfo<Zipcode> pageInfo = new PageInfo<>(zipcodes);
                Long total = pageInfo.getTotal();
                List<Zipcode> list = pageInfo.getList();
                paginationInfo.setPagination(list);
                paginationInfo.setTotal(total.intValue());
            }else{
                List<Zipcode> zipcodes = zipcodeMapper.select(zipcode);
                paginationInfo.setTotal(0);
                paginationInfo.setPagination(zipcodes);
            }
            return paginationInfo;
        }
}