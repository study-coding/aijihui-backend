package com.ajh.aijihui.service;

import com.ajh.aijihui.common.DateUtil;
import com.ajh.aijihui.entity.AjhAddr;
import com.ajh.aijihui.entity.AjhUser;
import com.ajh.aijihui.entity.AjhUserinfo;
import com.ajh.aijihui.mapper.AjhAddrMapper;
import com.ajh.aijihui.mapper.AjhUserMapper;
import com.ajh.aijihui.mapper.AjhUserinfoMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AjhUserService {

	@Autowired
	private AjhUserMapper ajhUserMapper;
	@Autowired
	private AjhUserinfoMapper ajhUserinfoMapper;
	@Autowired
	private AjhAddrMapper ajhAddrMapper;

	/**
	 * 登录
	 * @param phone
	 * @return
	 */
	public AjhUser login(String phone) {
		return ajhUserMapper.login(phone);
	}

	public AjhUser getUser(Integer id) {
		return ajhUserMapper.getUser(id);
	}

	/**
	 * 注册会员
	 * @param ajhUser
	 * @return
	 */
	public boolean addAjhUser(AjhUser ajhUser) {
		//初始化会员数据
		ajhUser.setRoleId("1");
		ajhUser.setRegisterDate(DateUtil.format(new Date()));
		ajhUser.setStatus("0");
		int row = ajhUserMapper.insert(ajhUser);
		if(row == 1){
			//获取自增id
			Integer id = ajhUserMapper.selectOne(ajhUser).getId();
			System.out.println(id);
			//新增用户信息
			AjhUserinfo ajhUserinfo = new AjhUserinfo();
			ajhUserinfo.setUserId(id);
			ajhUserinfo.setUserName(ajhUser.getPhone());
			ajhUserinfoMapper.insert(ajhUserinfo);
			//新增用户地址
			AjhAddr ajhAddr = new AjhAddr();
			ajhAddr.setUserId(id);
			ajhAddrMapper.insert(ajhAddr);
		}
		return row == 1;
	}

	/**
	 * 会员失效（禁用）
	 * @param id
	 * @return
	 */
	public boolean deleteAjhUser(Integer id) {
		return ajhUserMapper.deleteUser(id) == 1;
	}

	/**
	 * 修改会员（基本）信息
	 * @param ajhUser
	 * @return
	 */
	public boolean updateAjhUser(AjhUser ajhUser) {
		return ajhUserMapper.updateByPrimaryKeySelective(ajhUser) == 1;
	}



	public Object listAjhUser(AjhUser ajhUser, Integer pageNo, Integer pageSize) {
		PaginationInfo paginationInfo = new PaginationInfo();
		if (pageNo != null && pageNo != -1 && pageSize != null && pageSize != -1) {
			PageHelper.startPage(pageNo, pageSize);
			List<AjhUser> ajhUsers = ajhUserMapper.select(ajhUser);
			PageInfo<AjhUser> pageInfo = new PageInfo<>(ajhUsers);
			Long total = pageInfo.getTotal();
			List<AjhUser> list = pageInfo.getList();
			paginationInfo.setPagination(list);
			paginationInfo.setTotal(total.intValue());
		} else {
			List<AjhUser> ajhUsers = ajhUserMapper.select(ajhUser);
			paginationInfo.setTotal(0);
			paginationInfo.setPagination(ajhUsers);
		}
		return paginationInfo;
	}


}