package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhUserinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AjhUserinfoMapper extends Mapper<AjhUserinfo> {

	int changeUserInfo(@Param("id")Integer id, @Param("username")String username, @Param("email")String email, @Param("birthday")String birthday);

	AjhUserinfo selectUserInfo(Integer userId);
}