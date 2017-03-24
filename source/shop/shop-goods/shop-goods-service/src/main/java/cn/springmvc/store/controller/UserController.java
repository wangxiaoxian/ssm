package cn.springmvc.store.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.store.model.User;
import cn.springmvc.store.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
    @Autowired
    private UserService userService;
    
	@RequestMapping("index")
	public @ResponseBody String index(){
		System.out.println(111);
		return "hello";
	}
	
	/**
	 * 登录验证
	 * @param session
	 * @param username
	 * @param password
	 * @return 
	 * Map<String,Object>
	 */
	@RequestMapping("login.ajax")
	public @ResponseBody Map<String, Object> login(
	        HttpSession session,
	        String username, 
	        String password){
	    
	    User loginUser = new User();
	    loginUser.setUsername(username);
	    
	    User user = userService.getUser(loginUser);
	    Map<String, Object> result = new HashMap<String, Object>();
	    if (user == null) {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
            return result;
        }
	    
	    user.setPassword(null);
	    session.setAttribute("user", user);
	    result.put("success", true);
        result.put("message", "登录成功");
	    return result;
	}
}
