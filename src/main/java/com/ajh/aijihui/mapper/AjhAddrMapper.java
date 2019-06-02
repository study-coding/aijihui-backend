package com.ajh.aijihui.mapper;

import com.ajh.aijihui.entity.AjhAddr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AjhAddrMapper extends Mapper<AjhAddr> {

	int changeAddress(@Param("id")Integer id, @Param("address")String address);
}