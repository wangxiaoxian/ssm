/**  
 * 
 * cn.springmvc.store.model  
 * PriceChangeLog.java  
 * wangxiaoxian
 * 2015年12月15日-下午5:52:43
 */
package cn.springmvc.store.model;

/**  
 *   
 * PriceChangeLog  
 * 2015年12月15日 下午5:52:43  
 */
public class PriceChangeLog {

	private String priceChangeLogId;
	private String goodsId;
	private String price;
	private String createTime;
	private String updateTime;
	private String remark;
	
	public String getPriceChangeLogId() {
		return priceChangeLogId;
	}
	public void setPriceChangeLogId(String priceChangeLogId) {
		this.priceChangeLogId = priceChangeLogId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
