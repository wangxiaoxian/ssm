/**  
 * 
 * cn.springmvc.store.service  
 * GoodsService.java  
 * wangxiaoxian
 * 2015��12��15��-����5:53:03
 */
package com.wxx.shop.service;

import com.wxx.shop.model.Goods;

import java.util.List;

/**
 *   
 * GoodsService  
 */
public interface GoodsService {

	List<Goods> queryPage(Goods condition);

	

}
