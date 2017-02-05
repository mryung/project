package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.myproject.message.Message;
import com.myproject.message.Pageable;
import com.project.comtroller.BasicController;
import com.project.entity.TbUser;
import com.project.mapper.TbRightMapper;
import com.project.service.UserService;

@Controller
@RequestMapping(value="/sys/user")
public class UserController extends BasicController{
	
	@Autowired
	private TbRightMapper rightDao;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Map<String, Object> map){
		PageHelper.startPage(1, 1);
		System.out.println(rightDao.selectByExample(null));
		return html("sys/user/add", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,Object> add(TbUser user){
		Message message = Message.newMessage();
		
		userService.addUser(user);
		message.put("userId", 1);
		return json(1, "添加成功", message);
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Map<String, Object> map){
		
		return html("sys/user/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String, Object> list(Map<String, Object> map,Pageable pageable,Integer orgId){
		Message message = Message.newMessage();
		message.put("pageInfo", userService.listUser(1, 10,orgId));
		return json(0, "", message);
	}
	
}
