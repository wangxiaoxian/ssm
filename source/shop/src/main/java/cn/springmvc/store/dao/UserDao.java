/**  
 * 
 * cn.springmvc.store.dao  
 * UserDao.java  
 * wangxiaoxian
 * 2015��12��15��-����5:48:44
 */
package cn.springmvc.store.dao;

import org.apache.ibatis.annotations.Param;

import cn.springmvc.store.model.User;

/**  
 *   
 * UserDao  
 */
public interface UserDao {

    /** 
     * 
     * @param user
     * @return 
     * User 
     */
    User getUser(@Param("userInfo") User userInfo);

}
