package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhUserinfo;
import com.ajh.aijihui.service.AjhUserinfoService;
import com.ajh.aijihui.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("ajhUserinfo")
@CrossOrigin(origins = {"*","null"})
public class AjhUserinfoController {

	@Autowired
	private AjhUserinfoService ajhUserinfoService;

	/**
	 * 获取用户个人信息
	 * @param ajhUserinfo
	 * @return
	 */
	@RequestMapping("getAjhUserInfo")
	public AjhUserinfo getAjhUserinfo(@RequestBody  AjhUserinfo ajhUserinfo) {
		System.out.println(ajhUserinfo.getUserId());
		return ajhUserinfoService.getAjhUserinfo(ajhUserinfo);
	}

	/**
	 * 修改个人信息
	 * @param reqMap
	 * @return
	 */
	@RequestMapping("updateAjhUserinfo")
	public Object updateAjhUserinfo(@RequestBody Map<String,Object> reqMap) {
		String userName = reqMap.get("userName").toString();
		String email = reqMap.get("email").toString();
		String birthday = reqMap.get("birthday").toString();
		String address = reqMap.get("address").toString();
		Integer userId = Integer.parseInt(reqMap.get("userId").toString());
		return ajhUserinfoService.updateAjhUserinfo(userId,userName,email,birthday,address);
	}

}