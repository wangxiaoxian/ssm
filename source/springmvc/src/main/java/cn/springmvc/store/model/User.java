/**  
 * 
 * cn.springmvc.store.model  
 * User.java  
 * wangxiaoxian
 * 2015年12月15日-下午5:48:35
 */
package cn.springmvc.store.model;

/**  
 *   
 * User  
 * 2015年12月15日 下午5:48:35  
 */
public class User {

	private String userId;
	private String username;
	private String password;
	private String nickname;
	private String createTime;
	private String updateTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
}
