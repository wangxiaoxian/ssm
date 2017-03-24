/**  
 * 
 * cn.springmvc.store.service  
 * GoodsService.java  
 * wangxiaoxian
 * 2015��12��15��-����5:53:03
 */
package cn.springmvc.store.service;

import java.util.List;

import cn.springmvc.store.model.Goods;


/**  
 *   
 * GoodsService  
 */
public interface GoodsService {

	List<Goods> queryPage(Goods condition);

	

}
