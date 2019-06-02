package com.ajh.aijihui.service;

import com.ajh.aijihui.common.DateUtil;
import com.ajh.aijihui.entity.AjhCar;
import com.ajh.aijihui.entity.AjhOrder;
import com.ajh.aijihui.entity.AjhProduct;
import com.ajh.aijihui.mapper.AjhCarMapper;
import com.ajh.aijihui.mapper.AjhOrderMapper;
import com.ajh.aijihui.mapper.AjhProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AjhCarService {

	@Autowired
	private AjhCarMapper ajhCarMapper;
	@Autowired
	private AjhOrderMapper ajhOrderMapper;
	@Autowired
	private AjhProductMapper ajhProductMapper;

	/**
	 * 加入购物车
	 * @param ajhCar
	 * @return
	 */
	public boolean addShopCar(AjhCar ajhCar) {
		return ajhCarMapper.insert(ajhCar) == 1;
	}

	/**
	 * 获取用户购物车信息
	 * @return
	 */
	public List<AjhCar> listUserShopCar(Integer userId) {
		return ajhCarMapper.listUserShopCar(userId);
	}

	/**
	 * 删除购物车的一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteShopInfo(Integer id) {
		return ajhCarMapper.deleteShopInfo(id) == 1;
	}

	/**
	 * 批量删除购物车（付款）
	 * @param carIdlist
	 * @return
	 */
	public boolean payment(List<String> carIdlist,Integer userId) {
		int row;
		Integer id = 0;
		Boolean flag = true;
		for (String s : carIdlist) {
			id = Integer.parseInt(s);
			//获取商品信息
			AjhProduct ajhProduct = ajhProductMapper.getAjhProductByCarId(id);
			//商品状态改变为（下架）
			row = ajhCarMapper.updateProductStatus(ajhProduct.getId());
			if(row == 1){
				//清除购物车的记录
				ajhCarMapper.deleteShopInfo(id);
				//生成买订单
				AjhOrder order = new AjhOrder();
				order.setProductId(ajhProduct.getId());
				order.setOrderDate(DateUtil.format(new Date()));
				order.setOrderType("1");
				order.setUserId(userId);
				ajhOrderMapper.insert(order);
				//生成卖订单
				order.setUserId(ajhProduct.getUserId());
				order.setOrderType("2");
				ajhOrderMapper.insert(order);
			}else{
				flag = false;
				break;
			}
		}
		return flag;
	}
}
