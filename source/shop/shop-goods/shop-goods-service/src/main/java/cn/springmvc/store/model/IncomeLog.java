/**  
 * 
 * cn.springmvc.store.model  
 * IncomeLog.java  
 * wangxiaoxian
 * 2015��12��15��-����5:52:33
 */
package cn.springmvc.store.model;

/**  
 *   
 * IncomeLog  
 */
public class IncomeLog {
	
	private String incomeLogId;
	private String goodsId;
	private String incomeTime;
	private String incomeQuantity;
	private String quantityUnit;
	private String productTime;
	private String expireTime;
	private String suplierId;
	private String createTime;
	private String updateTime;
	private String remark;
	
	public String getIncomeLogId() {
		return incomeLogId;
	}
	public void setIncomeLogId(String incomeLogId) {
		this.incomeLogId = incomeLogId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getIncomeTime() {
		return incomeTime;
	}
	public void setIncomeTime(String incomeTime) {
		this.incomeTime = incomeTime;
	}
	public String getIncomeQuantity() {
		return incomeQuantity;
	}
	public void setIncomeQuantity(String incomeQuantity) {
		this.incomeQuantity = incomeQuantity;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public String getProductTime() {
		return productTime;
	}
	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}
	public String getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	public String getSuplierId() {
		return suplierId;
	}
	public void setSuplierId(String suplierId) {
		this.suplierId = suplierId;
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
