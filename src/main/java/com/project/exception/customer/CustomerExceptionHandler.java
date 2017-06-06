package com.project.exception.customer;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.message.R;

/**
 * 
 * @projectNam hisdb
 * @classname  CustomerExceptionHandler
 * @<p>description: 用于全局异常处理，返回json</p>
 * @email     2327542415@qq.com
 * @date       2017年3月4日:下午5:05:55
 * @version    0.0.1
 *
 */
@Component
public class CustomerExceptionHandler implements HandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ObjectMapper mapper = new ObjectMapper();
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//先判断请求类型   		现在系统默认只支持 post 和 get 请求
		String method = request.getMethod();
		if("POST".equals(method)){
			R r = null;
			try {
				response.setContentType("application/json;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				
				if(ex instanceof CustomerException){
					r = R.error(((CustomerException)ex).getMessage());
				}
				else if(ex instanceof DuplicateKeyException){
					r = R.error("数据库中已存在该记录");
				}else if(ex instanceof AuthorizationException){
					r = R.error("没有权限，请联系管理员授权");
				}else{
					r = R.error("出现了内部错误，请联系管理员");
				}
				//记录异常日志
				logger.error(ex.getMessage(), ex);
				mapper.writeValueAsString(r);
				PrintWriter writer = response.getWriter();
				writer.print(mapper.writeValueAsString(r));
				writer.flush();
			} catch (Exception e) {
				logger.error("RRExceptionHandler 异常处理失败", e);
			}
			return new ModelAndView();
		}else{
			//打印出错信息
			ex.printStackTrace();
			//返回一个错误页面
			return new ModelAndView("/error");
		}
		
	}

}
