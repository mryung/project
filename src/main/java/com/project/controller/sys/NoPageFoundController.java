package com.project.controller.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoPageFoundController {
	
	@RequestMapping("*")
	public String onPageFound(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		
		request.getRequestDispatcher("/index.html").forward(request, response);
		return null;
	}
	
}
