package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhOrder;
import com.ajh.aijihui.service.AjhOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ajhOrder")
@CrossOrigin(origins = {"*","null"})
public class AjhOrderController {

    @Autowired
    private AjhOrderService ajhOrderService;

	/**
	 * 获取用户所有订单信息
	 * @return
	 */
	@RequestMapping("listUserOrders")
    public List<AjhOrder> listUserOrders(@RequestBody AjhOrder ajhOrder){
        return ajhOrderService.listUserOrders(ajhOrder.getUserId());
    }

	/**
	 * 管理员获取所有订单信息
	 * @return
	 */
	@RequestMapping("listAllOrders")
    public List<AjhOrder> listAllOrders(){
        return ajhOrderService.listAllOrders();
    }

	/**
	 * 管理员删除订单信息（只删除记录）
	 * @return
	 */
	@RequestMapping("deleteOrder")
    public boolean deleteOrder(@RequestBody Map<String,Object> reqMap){
		List<String> orderIdlist = (List<String>) reqMap.get("orderIds");
        return ajhOrderService.deleteOrder(orderIdlist);
    }
}