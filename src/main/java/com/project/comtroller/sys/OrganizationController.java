package com.project.comtroller.sys;

import java.util.List;
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
import com.project.entity.TbOrganization;
import com.project.service.OrganizationService;

@Controller
@RequestMapping(value="/sys/org")
public class OrganizationController extends BasicController{
	
	@Autowired
	private OrganizationService organizationService;
	
	@ResponseBody
	@RequestMapping(value="/tree",method=RequestMethod.POST)
	public Map<String,Object> listTree(Map<String,Object> map){

		List<TbOrganization> tree = organizationService.listUserOrgTree(null);
		return R.ok().put("tree", tree);
	}
	
	@RequestMapping(value="/index")
	public String index(Map<String,Object> map){
		
		return html("sys/org/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listGroup(Pageable pageable){

		PageInfo<TbOrganization> pageInfo = new PageInfo<TbOrganization>();
		pageInfo.setRows(organizationService.listOrgByPage(pageable.getPage(),pageable.getPagesize()));
		return R.ok().put("pageInfo", pageInfo);
	}
}
