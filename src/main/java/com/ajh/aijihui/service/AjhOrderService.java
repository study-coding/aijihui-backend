package com.ajh.aijihui.service;

import com.ajh.aijihui.entity.AjhOrder;
import com.ajh.aijihui.mapper.AjhOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjhOrderService {

    @Autowired
    private AjhOrderMapper ajhOrderMapper;

    /**
     * 获取用户所有订单信息
     * @return
     */
    public List<AjhOrder> listUserOrders(Integer userId) {
		return ajhOrderMapper.listUserOrders(userId);
    }

	/**
	 * 管理员获取所有订单信息
	 * @return
	 */
	public List<AjhOrder> listAllOrders() {
    	return ajhOrderMapper.listAllOrders();
	}

	/**
	 * 管理员删除订单信息（只删除记录）
	 * @param orderList
	 * @return
	 */
	public boolean deleteOrder(List<String> orderList) {
		Integer id = 0;
		int row = 0;
		Boolean flag = true;
		for (String s : orderList) {
			id = Integer.parseInt(s);
			row = ajhOrderMapper.deleteOrder(id);
			if(row != 1){
				flag = false;
				break;
			}
		}
		return flag;
	}
}