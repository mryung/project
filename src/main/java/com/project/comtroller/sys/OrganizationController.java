package com.project.comtroller.sys;

import java.util.List;
import java.util.Map;

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
import com.project.entity.TbOrganization;
import com.project.entity.TbUser;
import com.project.service.OrganizationService;

@Controller
@RequestMapping(value="/sys/org")
public class OrganizationController extends BasicController{
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value="/index")
	public String index(Map<String,Object> map){
		
		return html("sys/org/index", map);
	}

	
	@ResponseBody
	@RequestMapping(value="/tree",method=RequestMethod.POST)
	public Map<String,Object> listTree(Map<String,Object> map){
		List<TbOrganization> tree = organizationService.listUserOrgTree(null);
		return R.ok().put("tree", tree);
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listOrg(Integer orgid){
		if(orgid == null){
			return null;
		}
		TbOrganization data = organizationService.findOrgById(orgid);
		PageInfo<TbOrganization> pageInfo = new PageInfo<TbOrganization>();
		pageInfo.pustRow(data);
		return R.ok().put("pageInfo",pageInfo);
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Integer orgid,Map<String,Object> map){
		
		map.put("orgid", orgid);
		return html("/sys/org/add", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public Map<String,Object> data(Integer orgid){
		if(orgid == null){
			return null;
		}
		//得到当前组织的信息
		TbOrganization data = organizationService.findOrgById(orgid);
		//得到父组织的数据
		TbOrganization parentdata = organizationService.findOrgById(data.getOrgParentId());
		
		return R.ok().put("data",data).put("parentdata", parentdata);
	}
	
	
	/**
	 * 
	 * @description  列出当前组织所拥有的用户列表
	 * @param pageable
	 * @param orgid
	 * @return
	 * Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public Map<String,Object> OrgUsers(Pageable pageable,Integer orgid){
		if(orgid == null){
			return null;
		}
		PageInfo<TbUser> pageInfo = organizationService.findOrgUsers(pageable,orgid);
		return R.ok().put("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Map<String,Object> saveOrg(TbOrganization org){
		int orgid = organizationService.saveOrg(org);
		return R.ok("保存成功").put("orgid", orgid);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete/{orgid}",method=RequestMethod.POST)
	public Map<String,Object> deleteOrg(@PathVariable("orgid")Integer orgid){
		if(orgid == null){
			return R.error("删除错误");
		}
		organizationService.deleteOrg(orgid);
		return R.ok("删除成功");
	}
}
