/**  
 * 
 * cn.springmvc.store.controller  
 * GoodsController.java  
 * wangxiaoxian
 * 2015��12��15��-����5:49:53
 */
package com.wxx.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxx.shop.WebResult;
import com.wxx.shop.model.Goods;
import com.wxx.shop.service.GoodsService;

/**  
 *   
 * GoodsController  
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@RequestMapping("/queryPage.ajax")
	@ResponseBody
	public PageInfo<Goods> queryPage(String goodsName, Integer pageNum, Integer pageSize) {
		Goods param = new Goods();
		param.setGoodsName(goodsName);
		
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsService.queryPage(param);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
	    
	    return page;
	}

	@RequestMapping("/queryByName.ajax")
	@ResponseBody
	public WebResult queryByName(String goodsSearchName) {
		WebResult wr = new WebResult();
		try {
			List<Goods> goods = goodsService.queryByName(goodsSearchName);
			wr.setData(goods);
		} catch (Exception e) {
			LOGGER.error("根据名称查询异常", e);
			wr.setCode(500);
		}
		return wr;
	}

	@Autowired
	private GoodsService goodsService;

	private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);
}
