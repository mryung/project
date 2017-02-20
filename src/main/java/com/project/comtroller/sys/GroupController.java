package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.project.comtroller.BasicController;
import com.project.entity.TbGroup;
import com.project.service.GroupService;

/**
 * @projectNam project
 * @classname  GroupController
 * @<p>description:分组权限模块</p>
 * @author     yl
 * @date       2017年1月30日:下午8:21:53
 * @version    0.0.1
 *
 */

@Controller
@RequestMapping(value="/sys/group")
public class GroupController extends BasicController {
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value="/index")
	public String index(Map<String,Object> map){
		
		return html("/sys/group/index", map);
	}
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listGroup(Pageable pageable){

		PageInfo<TbGroup> pageInfo = new PageInfo<TbGroup>();
		pageInfo.setRows(groupService.listGroupByPage(pageable.getPage(),pageable.getPagesize()));
		return R.ok().put("pageInfo", pageInfo);
	}
	
}
