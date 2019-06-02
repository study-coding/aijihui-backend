package com.ajh.aijihui.service;
import com.ajh.aijihui.entity.AjhBand;
import com.ajh.aijihui.mapper.AjhBandMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjhBandService {

    @Autowired
    private AjhBandMapper ajhBandMapper;

    public List<AjhBand> listAjhBand() {
        return ajhBandMapper.selectAll();
    }
    /**
     * 根据分类重置品牌数据
     * @param kindId
     * @return
     */
    public List<AjhBand> changeBandList(Integer kindId) {
        return ajhBandMapper.changeBandList(kindId);
    }
}