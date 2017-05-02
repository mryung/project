package com.myproject.util;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PassWordUtil {
	
	static public String password(String algorithmName, 
			Object source, Object salt, int hashIterations){
		SimpleHash hash = new SimpleHash(algorithmName,source,ByteSource.Util.bytes(salt),2);
		return hash.toString();
	}
	
	public static void main(String[] args) {
		
		String username = "2327542415@qq.com";
		HashedCredentialsMatcher hashq = new HashedCredentialsMatcher("SHA1");
//		hashq.doCredentialsMatch(token, info)
//		new SimpleHash("SHA1",username,ByteSource.Util.bytes(username),2); 
		SimpleHash hash = new SimpleHash("SHA1","111111",ByteSource.Util.bytes(username),2);
		System.out.println(hash.toString());
		
	}
}
