package com.ajh.aijihui.service;

import com.ajh.aijihui.entity.AjhUserinfo;
import com.ajh.aijihui.mapper.AjhAddrMapper;
import com.ajh.aijihui.mapper.AjhUserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AjhUserinfoService {

    @Autowired
    private AjhUserinfoMapper ajhUserinfoMapper;
    @Autowired
	private AjhAddrMapper ajhAddrMapper;

	/**
	 * 修改个人信息
	 * @param userName
	 * @param email
	 * @param birthday
	 * @param address
	 * @return
	 */
    public Object updateAjhUserinfo(Integer userId,String userName,String email,String birthday,String address) {
        int row1 = ajhUserinfoMapper.changeUserInfo(userId,userName,email,birthday);
        int row2 = ajhAddrMapper.changeAddress(userId,address);
		Map<String,Object> map = new HashMap<>();
		if(row1 !=1 && row2 != 1){
			map.put("flag",false);
			map.put("info","修改失败!");
		}else{
			map.put("flag",true);
			map.put("info","修改成功!");
		}
		return map;
    }

	/**
	 * 获取用户个人信息
	 * @param ajhUserinfo
	 * @return
	 */
	public AjhUserinfo getAjhUserinfo(AjhUserinfo ajhUserinfo) {
        return  ajhUserinfoMapper.selectUserInfo(ajhUserinfo.getUserId());
    }

}