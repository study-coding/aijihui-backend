package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhOrder;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AjhOrderMapper extends Mapper<AjhOrder> {

	List<AjhOrder> listUserOrders(Integer userId);

	List<AjhOrder> listAllOrders();

	int deleteOrder(Integer id);
}