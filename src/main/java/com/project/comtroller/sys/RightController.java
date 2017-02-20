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
import com.project.entity.TbRight;
import com.project.service.RightService;

/**
 * 
 * @projectNam project
 * @classname  RightController
 * @author     yl
 * @date       2017年1月14日:上午12:32:18
 * @version    0.0.1
 *
 */
@Controller
@RequestMapping(value="/sys/right")
public class RightController extends BasicController {
	
	@Autowired
	private RightService rightService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Map<String, Object> map,Integer id){
		
		if(id == null){
			map.put("rightid", null);
		}else{
			map.put("rightid", id);
		}
		return html("/sys/right/add", map);
	}
	
	//更新或者添加
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String, Object> add(TbRight righ){
		if(righ.getRightId() != null){
			//更新
			return R.ok("更新成功");
		}else{
			//添加
			return R.ok("添加成功");
		}
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Map<String, Object> map){
		
		return html("/sys/right/index", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/tree",method=RequestMethod.POST)
	public Map<String,Object> listRightTree(){

		List<TbRight> tree = rightService.listRightTree();
		return R.ok().put("tree", tree);
	}
	
	@ResponseBody
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public Map<String, Object> data(Pageable pageable,Integer rightid){
		
		if(rightid == null){
			rightid = 1;
		}		
		PageInfo<TbRight> pageInfo = new PageInfo<TbRight>();
		pageInfo.setRows(rightService.findRights(rightid+""));
		return R.ok().put("pageInfo", pageInfo);
	}
	
	//显示更新页面
	@RequestMapping(value="/update/{rightid}",method=RequestMethod.GET)
	public String update(Map<String, Object> map,@PathVariable("rightid")Integer rightid){
		map.put("rightid", rightid);
		return html("/sys/right/add", map);
	}
	
	//删除
	//显示更新页面
	@RequestMapping(value="/delete/{rightid}",method=RequestMethod.GET)
	public Map<String, Object> delete(Map<String, Object> map,@PathVariable("rightid")Integer rightid){
		
		return R.ok("删除成功");
	}
}
