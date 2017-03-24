package cn.springmvc.store.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import cn.springmvc.store.dao.GoodsDao;
import cn.springmvc.store.model.Goods;

@Repository
public class GoodsRedisDao {

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
    private RedisTemplate<String, Goods> redisTemplate;
	
	public Goods queryGoodsName(String goodsName) {
		ValueOperations<String, Goods> valueOper = redisTemplate.opsForValue();
		valueOper.get("");
		return null;
	}
	
	public int insert(Goods goods) {
		int result = goodsDao.insert(goods);
		
		ValueOperations<String, Goods> valueOper = redisTemplate.opsForValue();
		valueOper.set(goods.getGoodsId().toString(), goods);
		System.out.println("-->>" + valueOper.get(goods.getGoodsId().toString()));
		return result;
	}
}
