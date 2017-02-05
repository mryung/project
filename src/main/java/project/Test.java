package project;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test {
	public static void main(String[] args) {
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("test.ini");
		SecurityManager securityManager = factory.getInstance();
		
		//注入到系统中包securityManager
		SecurityUtils.setSecurityManager(securityManager);
		
		//创建一个 主体
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("yulang","123");
		
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(subject.isAuthenticated());
		System.out.println("认证成功");
	}
}
