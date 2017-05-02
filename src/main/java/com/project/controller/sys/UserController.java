package com.project.controller.sys;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.myproject.util.CusAccessObjectUtil;
import com.project.controller.BasicController;
import com.project.entity.TbOrganization;
import com.project.entity.TbUser;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;
import com.project.service.OrganizationService;
import com.project.service.UserService;

@Controller
@RequestMapping(value="/sys/user")
public class UserController extends BasicController{
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private OrganizationService orgService;
	
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
	public Map<String,Object> add(TbUser user,String roles,String rights,HttpServletRequest request){
		user.setLoginIp(CusAccessObjectUtil.getIpAddress(request));
		userService.addUser(user,roles,rights);
		return R.ok("添加成功").put("userId", 1);
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Map<String, Object> map){
		
		return html("sys/user/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String, Object> list(Pageable pageable,Integer orgId){

		PageInfo<TbUser> pageInfo = userService.listUsers(pageable,orgId);
		return R.ok().put("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="/orgTree",method=RequestMethod.POST)
	public Map<String,Object> orgTree(Integer orgId){
		List<TbOrganization> tree = orgService.listUserOrgTree(orgId);
		return R.ok().put("tree", tree);
	}
	
	@ResponseBody
	@RequestMapping(value="/roleTree",method=RequestMethod.POST)
	public Map<String,Object> RoleTree(Integer userId){
		Set<Role> tree = userService.listUserRoleTree(userId);
		return R.ok().put("tree",tree);
	}
	
	@ResponseBody
	@RequestMapping(value="/rightTree",method=RequestMethod.POST)
	public Map<String,Object> rightTree(Integer userId){

		List<Right> tree = userService.listUserRightTree(userId);
		return R.ok().put("tree",tree);
	}
	
	@ResponseBody
	@RequestMapping(value="/userData",method=RequestMethod.POST)
	public Map<String,Object> userData(Integer userId){
		User user = userService.selectUserById(userId);
		return R.ok().put("user",user);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete/{userid}",method=RequestMethod.POST)
	public Map<String,Object> deleteUser(@PathVariable("userid") Integer userid){
		int flag = userService.deleteUser(userid);
		return R.ok("删除成功");
	}
}
