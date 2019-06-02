package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhBand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AjhBandMapper extends Mapper<AjhBand> {

	List<AjhBand> changeBandList(Integer fatherId);
}