package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.R;
import com.project.comtroller.BasicController;
import com.project.entity.TbRole;
import com.project.service.RoleService;

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
	
	@RequestMapping(value="/index")
	public String index(Map<String, Object> map){
		return html("/sys/role/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listRole(){
		
		PageInfo<TbRole> pageInfo = new PageInfo<TbRole>();
		pageInfo.setRows(roleService.findRoleList());
		return R.ok().put("pageInfo", pageInfo);
	}
}
