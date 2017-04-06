/**  
 * 
 * cn.springmvc.store.dao  
 * UserDao.java  
 * wangxiaoxian
 * 2015��12��15��-����5:48:44
 */
package com.wxx.shop.dao;

import com.wxx.shop.model.User;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

/**  
 *   
 * UserDao  
 */
@Repository
public interface UserDao {

    /** 
     * 
     * @param userInfo
     * @return 
     * User 
     */
    User getUser(@Param("userInfo") User userInfo);

}
