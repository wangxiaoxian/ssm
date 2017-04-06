package com.wxx.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.wxx.shop.model.User;
import com.wxx.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
