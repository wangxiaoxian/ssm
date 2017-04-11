/**  
 * 
 * cn.springmvc.store.dao  
 * GoodsDao.java  
 * wangxiaoxian
 * 2015��12��15��-����5:51:23
 */
package com.wxx.shop.dao;

import java.util.List;

import com.wxx.shop.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**  
 *   
 * GoodsDao  
 */
@Repository
public interface GoodsDao {

	List<Goods> queryPage(@Param("param") Goods param);

	List<Goods> queryByName(@Param("goodsSearchName")String goodsSearchName);
	
	int insert(Goods goods);
}
