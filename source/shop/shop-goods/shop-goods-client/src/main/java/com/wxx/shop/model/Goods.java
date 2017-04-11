/**  
 * 
 * cn.springmvc.store.model  
 * Goods.java  
 * wangxiaoxian
 * 2015年12月15日-����5:52:20
 */
package com.wxx.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
 *   
 * Goods  
 */
public class Goods implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer goodsId;
	private BigDecimal price;
	private String goodsNo;
	private String goodsName;
	private String goodsPyName;


	private String goodsShortPyName;
	private Date createTime;
	private Date updateTime;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getGoodsPyName() {
		return goodsPyName;
	}

	public void setGoodsPyName(String goodsPyName) {
		this.goodsPyName = goodsPyName;
	}


	public String getGoodsShortPyName() {
		return goodsShortPyName;
	}

	public void setGoodsShortPyName(String goodsShortPyName) {
		this.goodsShortPyName = goodsShortPyName;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
}
