package com.ajh.aijihui.controller;

import com.ajh.aijihui.common.Constant;
import com.ajh.aijihui.common.EncryptUtil;
import com.ajh.aijihui.entity.AjhUser;
import com.ajh.aijihui.service.AjhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ajhUser")
@CrossOrigin(origins = {"*","null"})
public class AjhUserController {

	@Autowired
	private AjhUserService ajhUserService;

	/**
	 * 登录
	 * @param ajhUser
	 * @return
	 */
	@RequestMapping("login")
	public Object getAjhUser(@RequestBody AjhUser ajhUser) {
		AjhUser ajhUser1 = ajhUserService.login(ajhUser.getPhone());
		Map<String,Object> map = new HashMap<>();
		if(ajhUser1 == null){
			map.put("code",403);
			map.put("info","该账户未注册!");
		}else if(ajhUser1.getStatus().equals('1')){
			map.put("code",403);
			map.put("info","该账户已禁用!");
		}else if(!ajhUser1.getPassword().equals(EncryptUtil.md5(ajhUser.getPassword(), Constant.MD5_TIMES))){
			map.put("code",400);
			map.put("info","密码错误!");
		}else{
			map.put("code",200);
			map.put("info","登录成功!");
			map.put("user",ajhUser1);
		}
		return map;
	}

	/**
	 * 注册会员
	 * @param ajhUser
	 * @return
	 */
	@RequestMapping("insertAjhUser")
	public Object insertAjhUser(@RequestBody AjhUser ajhUser) {
		AjhUser ajhUser1 = ajhUserService.login(ajhUser.getPhone());
		Map<String,Object> map = new HashMap<>();
		if(ajhUser1 != null){
			map.put("flag",false);
			map.put("info","该电话号码已经注册过了!");
		}else{
			ajhUser.setPassword(EncryptUtil.md5(ajhUser.getPassword(),Constant.MD5_TIMES));
			if(ajhUserService.addAjhUser(ajhUser)){
				map.put("flag",true);
				map.put("info","注册成功!");
			}else{
				map.put("flag",false);
				map.put("info","注册失败!");
			}
		}
		return map;
	}

	/**
	 * 会员失效（禁用）
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteAjhUser")
	public boolean deleteAjhUser(Integer id) {
		return ajhUserService.deleteAjhUser(id);
	}

}