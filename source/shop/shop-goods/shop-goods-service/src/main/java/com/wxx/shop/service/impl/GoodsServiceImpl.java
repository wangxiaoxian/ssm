package com.wxx.shop.service.impl;

import java.util.List;

import com.wxx.shop.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxx.shop.dao.GoodsDao;
import com.wxx.shop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> queryPage(Goods condition) {
		
		List<Goods> list = goodsDao.queryPage(condition);
		return list;
	}
}
