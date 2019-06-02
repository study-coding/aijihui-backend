package com.ajh.aijihui.service;

import com.ajh.aijihui.common.DateUtil;
import com.ajh.aijihui.entity.AjhProduct;
import com.ajh.aijihui.mapper.AjhProductMapper;
import com.ajh.aijihui.vo.PaginationInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AjhProductService {

	@Autowired
	private AjhProductMapper ajhProductMapper;

	/**
	 * 发布商品
	 * @param ajhProduct
	 * @return
	 */
	public boolean addAjhProduct(AjhProduct ajhProduct) {
		ajhProduct.setPublishStatus("1");
		// 计算现价
		ajhProduct = (getNowPrice(ajhProduct));
		return ajhProductMapper.insert(ajhProduct) == 1;
	}

	/**
	 * 计算现价
	 * @param ajhProduct
	 * @return
	 */
	public static AjhProduct getNowPrice(AjhProduct ajhProduct){
		Date date = DateUtil.parse(ajhProduct.getUseDate());
		int days = (int) (((new Date()).getTime() - date.getTime()) / (1000*3600*24));
		Double a = days > 364 ? 0.6 : 0.8;
		Double b = ajhProduct.getIsWater().equals("0") ? 1 : 0.8;
		Integer degree = Integer.parseInt(ajhProduct.getDegree());
		Double c;
		if(degree < 6){
			c = 0.5;
		}else if(degree >=6 && degree < 8){
			c = 0.7;
		}else{
			c = 0.9;
		}
		BigDecimal a1 = new BigDecimal(a);
		BigDecimal b1 = new BigDecimal(b);
		BigDecimal c1 = new BigDecimal(c);
		ajhProduct.setNowPrice((ajhProduct.getPriPrice().multiply(a1)).multiply(b1).multiply(c1).setScale(2,BigDecimal.ROUND_HALF_UP));
		return ajhProduct;
	}
	/**
	 * 获取单个商品信息
	 * @param id
	 * @return
	 */
	public AjhProduct getAjhProduct(Integer id) {
		return ajhProductMapper.getAjhProduct(id);
	}

	/**
	 * 获取所有商品的信息
	 * @param productName
	 * @param kindId
	 * @param bandId
	 * @param degree
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PaginationInfo listAjhProduct(String productName,Integer kindId,Integer bandId,String degree, Integer pageNo, Integer pageSize) {
		PaginationInfo paginationInfo = new PaginationInfo();
		PageHelper.startPage(pageNo, pageSize);
		List<AjhProduct> ajhProducts = ajhProductMapper.listAjhProduct(productName,kindId,bandId,degree);
		PageInfo<AjhProduct> pageInfo = new PageInfo<>(ajhProducts);
		Long total = pageInfo.getTotal();
		List<AjhProduct> list = pageInfo.getList();
		paginationInfo.setPagination(list);
		paginationInfo.setTotal(total.intValue());
		return paginationInfo;
	}

}