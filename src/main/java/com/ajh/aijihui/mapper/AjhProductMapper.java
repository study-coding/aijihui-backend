package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AjhProductMapper extends Mapper<AjhProduct> {

	AjhProduct getAjhProduct(Integer id);

	List<AjhProduct> listAjhProduct(@Param("productName")String productName, @Param("kindId")Integer kindId, @Param("bandId")Integer bandId, @Param("degree")String degree);

	int releaseProduct(Integer id);

	AjhProduct getAjhProductByCarId(Integer id);
}