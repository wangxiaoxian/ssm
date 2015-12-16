/**  
 * 
 * cn.springmvc.store.model  
 * Goods.java  
 * wangxiaoxian
 * 2015年12月15日-����5:52:20
 */
package cn.springmvc.store.model;

import java.util.Date;

/**  
 *   
 * Goods  
 * 2015年12月15日 ����5:52:20  
 */
public class Goods {
	
	private String goodsId;
	private int price;
	private String goodsNo;
	private String goodsName;
	private String brand;
	private String remark;
	private Date createTime;
	private Date updateTime;
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
