package cn.springmvc.model;

import java.sql.Date;

/**
 * 用户表
 * @author fenghaifeng
 * 2014年2月11日
 */
public class User {

	private int userId;
	private Date createTime;
	private String nickname;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
