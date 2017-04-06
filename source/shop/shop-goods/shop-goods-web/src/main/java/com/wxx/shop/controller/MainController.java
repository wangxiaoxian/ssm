package com.wxx.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping("index")
	public String index(){
		System.out.println(111);
		return "index.jsp";
	}
	
}
