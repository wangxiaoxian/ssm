/**  
 * 
 * cn.springmvc.store.dao  
 * GoodsDao.java  
 * wangxiaoxian
 * 2015��12��15��-����5:51:23
 */
package cn.springmvc.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.springmvc.store.model.Goods;

/**  
 *   
 * GoodsDao  
 */
public interface GoodsDao {

	List<Goods> queryPage(@Param("param")Goods param);

	List<Goods> queryGoodsName(String goodsName);
	
	int insert(Goods goods);
}
