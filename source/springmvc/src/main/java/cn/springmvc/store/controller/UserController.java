/**  
 * 
 * cn.springmvc.store.controller  
 * UserController.java  
 * wangxiaoxian
 * 2015��12��15��-����5:49:01
 */
package cn.springmvc.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
 *   
 * UserController  
 * 2015��12��15�� ����5:49:01  
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("login")
	public @ResponseBody String index(){
		System.out.println(111);
		return "hello";
	}
}
