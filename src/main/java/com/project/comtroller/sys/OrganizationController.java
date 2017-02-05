package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.Message;
import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
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
		Message message = Message.newMessage();
		message.put("tree", organizationService.listTree());
		return message;
	}
	
	@RequestMapping(value="/index")
	public String index(Map<String,Object> map){
		
		return html("sys/org/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listGroup(Pageable pageable){
		Message message = Message.newMessage();
		PageInfo<TbOrganization> pageInfo = new PageInfo<TbOrganization>();
		pageInfo.setRows(organizationService.listOrgByPage(pageable.getPage(),pageable.getPagesize()));
		message.put("pageInfo", pageInfo);
		return json(0, "", message);
	}
}
