package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhUser;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AjhUserMapper extends Mapper<AjhUser> {

	AjhUser login(String phone);

	int deleteUser(Integer id);

	AjhUser getUser(Integer id);

}