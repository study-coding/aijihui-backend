package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhCar;
import com.ajh.aijihui.service.AjhCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ajhCar")
@CrossOrigin(origins = {"*","null"})
public class AihCarController {

	@Autowired
	private AjhCarService ajhCarService;

	/**
	 * 加入购物车
	 * @param ajhCar
	 * @return
	 */
	@RequestMapping("addShopCar")
	public boolean addShopCar(@RequestBody AjhCar ajhCar){
		return ajhCarService.addShopCar(ajhCar);
	}

	/**
	 * 获取用户购物车信息
	 * @return
	 */
	@RequestMapping("listUserShopCar")
	public List<AjhCar> listUserShopCar(@RequestBody AjhCar ajhCar){
		return ajhCarService.listUserShopCar(ajhCar.getUserId());
	}

	/**
	 * 批量删除购物车（付款）
	 * @param reqMap
	 * @return
	 */
	@RequestMapping("payment")
	public boolean payment(@RequestBody Map<String,Object> reqMap){
		List<String> carIdlist = (List<String>) reqMap.get("carIds");
		Integer userId = Integer.parseInt(reqMap.get("userId").toString());
		return ajhCarService.payment(carIdlist, userId);
	}

	/**
	 * 删除购物车的一条记录
	 * @param ajhCar
	 * @return
	 */
	@RequestMapping("deleteShopInfo")
	public boolean deleteShopInfo(@RequestBody AjhCar ajhCar){
		return ajhCarService.deleteShopInfo(ajhCar.getId());
	}

}
