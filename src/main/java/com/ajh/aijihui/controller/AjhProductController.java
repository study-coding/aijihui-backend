package com.ajh.aijihui.controller;

import com.ajh.aijihui.entity.AjhBand;
import com.ajh.aijihui.entity.AjhKind;
import com.ajh.aijihui.entity.AjhProduct;
import com.ajh.aijihui.service.AjhBandService;
import com.ajh.aijihui.service.AjhKindService;
import com.ajh.aijihui.service.AjhProductService;
import com.ajh.aijihui.vo.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ajhProduct")
@CrossOrigin(origins = {"*","null"})
public class AjhProductController {

	@Autowired
	private AjhProductService ajhProductService;
	@Autowired
	private AjhBandService ajhBandService;
	@Autowired
	private AjhKindService ajhKindService;

	/**
	 * 初始化商品发布界面
	 * @return
	 */
	@RequestMapping("initProduct")
	public Object initProduct(){
		List<AjhBand> ajhBands = ajhBandService.listAjhBand();
		List<AjhKind> ajhKinds = ajhKindService.listAjhKind();
		Map<String,Object> map = new HashMap<>();
		map.put("band",ajhBands);
		map.put("kind",ajhKinds);
		return map;
	}

	/**
	 * 根据分类重置品牌数据
	 * @param ajhBand
	 * @return
	 */
	@RequestMapping("changeBandList")
	public List<AjhBand> changeBandList(@RequestBody AjhBand ajhBand){
		return ajhBandService.changeBandList(ajhBand.getFatherId());
	}

	/**
	 * 发布商品
	 * @param ajhProduct
	 * @return
	 */
	@RequestMapping("insertAjhProduct")
	public boolean insertAjhProduct(@RequestBody AjhProduct ajhProduct) {
		return ajhProductService.addAjhProduct(ajhProduct);
	}

	/**
	 * 获取单个商品信息
	 * @param ajhProduct
	 * @return
	 */
	@RequestMapping("getAjhProduct")
	public AjhProduct getAjhProduct(@RequestBody AjhProduct ajhProduct) {
		return ajhProductService.getAjhProduct(ajhProduct.getId());
	}

	/**
	 * 获取所有商品的信息
	 * @param reqMap
	 * @return
	 */
	@RequestMapping("listAjhProduct")
	public PaginationInfo listAjhProduct(@RequestBody Map<String,Object> reqMap) {
		System.out.println(reqMap);
		String productName = reqMap.get("productName").toString();
		String kindId = reqMap.get("kindId").toString();
		Integer kindId1 = 0;
		if(kindId != null && kindId.length() != 0){
			kindId1 = Integer.parseInt(kindId);
		}
		Integer bandId1 = 0;
		String bandId = reqMap.get("bandId").toString();
		if(bandId != null && bandId.length() != 0){
			bandId1 = Integer.parseInt(bandId);
		}
		String degree = reqMap.get("degree").toString();
		Integer pageNo = Integer.parseInt(reqMap.get("pageNo").toString());
		Integer pageSize = Integer.parseInt(reqMap.get("pageSize").toString());
		return ajhProductService.listAjhProduct(productName,kindId1,bandId1,degree,pageNo,pageSize);
	}
}