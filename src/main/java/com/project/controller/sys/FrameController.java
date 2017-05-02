package com.project.controller.sys;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.R;
import com.project.controller.BasicController;
import com.project.entity.TbRight;
import com.project.security.shiro.SessionUtil;
import com.project.service.MenuService;

@Controller
@RequestMapping(value="/frame")
public class FrameController extends BasicController {
	
	@Autowired
	private MenuService menuService;
	
	@RequiresRoles(value="sys:admin")
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String frame(Map<String,Object> map){
		
		//用户名和传到前台
		map.put("username", SessionUtil.getUsername());
		return html("/sys/frame/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/menu",method=RequestMethod.POST)
	public Map<String,Object> menu(){
		int userid = SessionUtil.getUserid();
		List<TbRight> menu = menuService.findMenu(userid);
		return R.ok().put("tree", menu);
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome(Map<String,Object> map){
		return html("welcome", map);
	}
}
