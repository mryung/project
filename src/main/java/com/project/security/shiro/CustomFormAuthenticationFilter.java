package com.project.security.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @projectNam hisdb
 * @classname  CustomFormAuthenticationFilter
 * @<p>description: 自定义 customeForm 验证</p>
 * @email     2327542415@qq.com
 * @date       2017年2月15日:下午5:29:20
 * @version    0.0.1
 *
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	
	private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);
	
	//原FormAuthenticationFilter的认证方法
	/**
	 * 直接考的源码
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                
                // 在这里进行 验证码的认证，验证码错误返回
                
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
	}
	
     @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
    		ServletResponse response) throws Exception {
    	//正确通过
    	 request.setAttribute("through", 1);
    	return true;
    }
     
     protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
             ServletRequest request, ServletResponse response) {
		if (log.isDebugEnabled()) {
			log.debug( "Authentication exception", e );
		}
		//设置 requet里面的变量
		request.setAttribute("shiroLoginFailure", "用户名或则密码错误");
//		setFailureAttribute(request, e);
		//login failed, let request continue back to the login page:
		return true;
	}
}
