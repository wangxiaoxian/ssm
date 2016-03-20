/**  
 * 
 * cn.springmvc.store.service  
 * UserService.java  
 * wangxiaoxian
 * 2015��12��15��-����5:49:10
 */
package cn.springmvc.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.store.dao.UserDao;
import cn.springmvc.store.model.User;

/**  
 *   
 * UserService  
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    /** 
     * 
     * @param loginUser
     * @return 
     * User 
     */
    public User getUser(User user) {
        User result = userDao.getUser(user);
        return result;
    }

}
