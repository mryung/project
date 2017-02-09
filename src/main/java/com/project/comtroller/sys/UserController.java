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
import com.project.service.OrganizationService;
import com.project.service.RightService;
import com.project.service.RoleService;
import com.project.service.UserService;

@Controller
@RequestMapping(value="/sys/user")
public class UserController extends BasicController{
	
	@Autowired
	private TbRightMapper rightDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private OrganizationService orgService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RightService rightService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Map<String, Object> map,Integer userId,Integer orgId){

		map.put("userId", userId);
		if(orgId != null){
			//得到部门的详细信息
			map.put("org", orgService.findOrgById(orgId));
		}
		return html("sys/user/add", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
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
	public Map<String, Object> list(Pageable pageable,Integer orgId){
		Message message = Message.newMessage();
		message.put("pageInfo", userService.listUser(pageable.getPage(), pageable.getPagesize(),orgId));
		return json(0, "", message);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/orgTree",method=RequestMethod.POST)
	public Map<String,Object> orgTree(Integer orgId){
		Message message = Message.newMessage();
		message.put("tree", orgService.listUserOrgTree(orgId));
		return json(0, "", message);
	}
	
	@ResponseBody
	@RequestMapping(value="/roleTree",method=RequestMethod.POST)
	public Map<String,Object> RoleTree(Integer userId){
		Message message = Message.newMessage();
		message.put("tree", roleService.listUserRoleTree(userId));
		return json(0, "", message);
	}
	
	@ResponseBody
	@RequestMapping(value="/rightTree",method=RequestMethod.POST)
	public Map<String,Object> rightTree(Integer userId){
		Message message = Message.newMessage();
		message.put("tree", rightService.listUserRightTree(userId));
		return json(0, "", message);
	}
	
	@ResponseBody
	@RequestMapping(value="/userData",method=RequestMethod.POST)
	public Map<String,Object> userData(Integer userId){
		Message message = Message.newMessage();
		message.put("user", userService.selectUserById(userId));
		return json(0, "", message);
	}
}
