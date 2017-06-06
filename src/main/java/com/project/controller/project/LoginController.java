package com.project.controller.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.message.R;
import com.project.security.shiro.CustomFormAuthenticationFilter;


@Controller
public class LoginController{
	
	@Autowired
	@Qualifier(value="formAuthenticationFilter")
	private CustomFormAuthenticationFilter formFilter;
	
	@ResponseBody
	@RequestMapping(value="/login.html",method=RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response){
		R r = null;
		Integer flag = (Integer) request.getAttribute("through");
		if(flag != null && flag == 1){
			
			r =  R.ok("登录成功,即将跳转页面").put("url", formFilter.getSuccessUrl());
		}else{
			//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
			String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
			//根据shiro返回的异常类路径判断，抛出指定异常信息
			if(exceptionClassName!=null){
				
				r = R.error("用户名或者密码错误");
			}else{
				
				r = R.ok("登录成功,即将跳转页面").put("url", "index.html");
			}
		}
		//返回 json用 response
		ObjectMapper objectMapper = new ObjectMapper();
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
	    PrintWriter out = null; 
	    try {  
	        out = response.getWriter();  
	        out.append(objectMapper.writeValueAsString(r)); 
	        System.err.println("返回是\n");
	        System.err.println(objectMapper.writeValueAsString(r));
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
	}
	
	
}
