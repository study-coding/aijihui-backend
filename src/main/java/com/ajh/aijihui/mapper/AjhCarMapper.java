package com.ajh.aijihui.mapper;


import com.ajh.aijihui.entity.AjhAddr;
import com.ajh.aijihui.entity.AjhCar;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AjhCarMapper extends Mapper<AjhCar> {

	List<AjhCar> listUserShopCar(Integer userId);

	int deleteShopInfo(Integer id);

	int updateProductStatus(Integer productId);

}