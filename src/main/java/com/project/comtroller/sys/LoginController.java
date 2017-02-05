package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.comtroller.BasicController;


@Controller
public class LoginController extends BasicController {
	
	@RequestMapping(value="login")
	public String login(Map<String, Object> map){
		
		return html("/login", map);
	}
	
	public Map<String, Object> login(){
		
		return successAjax("登录成功");
	}
	
//	public String 
	
	
}
