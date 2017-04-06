/**  
 * 
 * cn.springmvc.store.controller  
 * GoodsController.java  
 * wangxiaoxian
 * 2015��12��15��-����5:49:53
 */
package com.wxx.shop.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wxx.shop.model.Goods;
import com.wxx.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

/**  
 *   
 * GoodsController  
 */
@Controller
@RequestMapping(value = "/goods")
@Scope("prototype")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/commonSearch.ajax", method=RequestMethod.POST)
	public @ResponseBody PageInfo<Goods> commonSearch(String goodsName, Integer pageNum, Integer pageSize) {
		Goods param = new Goods();
		param.setGoodsName(goodsName);
		
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsService.queryPage(param);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
	    
	    return page;
	}
}
