package com.project.comtroller.sys;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.project.comtroller.BasicController;
import com.project.entity.TbRole;
import com.project.entity.project.Right;
import com.project.entity.project.Role;
import com.project.entity.project.User;
import com.project.service.RoleService;
import com.project.service.UserService;

/**
 * 
 * @projectNam project
 * @classname  RoleController
 * @<p>description:显示用户角色</p
 * @author     yl
 * @date       2017年1月29日:下午10:17:35
 * @version    0.0.1
 *
 */
@Controller
@RequestMapping(value="/sys/role")
public class RoleController extends BasicController{
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		return html("/sys/role/index", map);
	}
	
	//得到角色树
	@ResponseBody
	@RequestMapping(value="/tree",method=RequestMethod.POST)
	public Map<String,Object> listTree(){
		Set<Role> roleTree = userService.listUserRoleTree(null);
		return R.ok().put("tree", roleTree);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listRole(Pageable pageable,Integer roleId){
		if(roleId == null){
			return null;
		}
		PageInfo<TbRole> pageInfo = roleService.findRoleListByPage(pageable,roleId);
		return R.ok().put("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete/{roleId}",method=RequestMethod.POST)
	public Map<String,Object> deleteRole(@PathVariable("roleId") Integer roleId){
		if(roleId == null){
			return null;
		}
		roleService.deleteRolde(roleId);
		return R.ok("删除成功");
	}
	
	//添加或保存
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Integer roleId,Map<String,Object> map){
		
		map.put("roleId", roleId);
		return html("/sys/role/add", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Map<String,Object> saveRole(TbRole role,String rights){
		int roleId = roleService.saveRole(role,rights);
		return R.ok("保存成功!").put("roleId", roleId);
	}
	
	@ResponseBody
	@RequestMapping(value="/roleData",method=RequestMethod.POST)
	public Map<String,Object> roleData(Integer roleId){
		if(roleId == null){
			return R.error("查询出错");
		}
		TbRole role = roleService.findRoleById(roleId);
		TbRole parentRole = roleService.findRoleById(role.getRoleParentId());
		return R.ok().put("role", role).put("parentRole", parentRole);
	}
	
	@ResponseBody
	@RequestMapping(value="/rightTree",method=RequestMethod.POST)
	public Map<String,Object> rightTree(Integer roleId){
		List<Right> rightTree = roleService.findRightTree(roleId);
		return R.ok().put("tree", rightTree);
	}
	
	@ResponseBody
	@RequestMapping(value="/userList",method=RequestMethod.POST)
	public Map<String,Object> userList(Pageable pageable,Integer roleId){
		if(roleId == null){
			return null;
		}
		//得到用户列表
		PageInfo<User> pageInfo = roleService.findUserByRoleid(pageable,roleId);
		return R.ok().put("pageInfo", pageable);
	}
}
