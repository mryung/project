package com.project.comtroller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.R;
import com.project.comtroller.BasicController;
import com.project.security.shiro.CustomFormAuthenticationFilter;

import net.sf.json.JSONObject;


@Controller
public class LoginController extends BasicController {
	
	@Autowired
	@Qualifier(value="formAuthenticationFilter")
	private CustomFormAuthenticationFilter formFilter;
	
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
				r = R.ok("登录成功,即将跳转页面").put("url", formFilter.getSuccessUrl());
			}
		}
		
		//返回 json用 response
		JSONObject responseJSONObject = JSONObject.fromObject(r);
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");
	    PrintWriter out = null; 
	    try {  
	        out = response.getWriter();  
	        out.append(responseJSONObject.toString()); 
	        System.err.println("返回是\n");
	        System.err.println(responseJSONObject.toString());
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
	}
	
	
	
}
