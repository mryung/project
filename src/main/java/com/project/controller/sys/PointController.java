package com.project.controller.sys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.project.entity.PointInfo;
import com.project.service.PointInfoService;

@Controller
@RequestMapping(value="point")
public class PointController {
	
	@Autowired
	private PointInfoService pointInfoService;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "sys/point/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String, Object> list(Pageable pageable){
		PageInfo<PointInfo> list = pointInfoService.queryList(pageable);
		
		return R.ok().put("pageInfo",list);
	}
	
	@RequestMapping(value="/add")
	public String add(Long pointId,Map<String,Object> map){
		map.put("pointId", pointId);
		return "sys/point/add";
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Map<String, Object> save(PointInfo pointInfo,String pointTime1){
		
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = formate.parse(pointTime1);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			pointInfo.setPointTime(calendar.getTimeInMillis()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return R.error("格式化日期出错");
		}
		
		Integer pointId = pointInfoService.savePointInfo(pointInfo);
		if(pointId == 0){
			return R.error("节点编号已经存在！");
		}
		return R.ok("保存成功").put("pointId", pointId);
	}
	
	@ResponseBody
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public Map<String, Object> data(Long pointId){
		PointInfo point = pointInfoService.findPoint(pointId);
		return R.ok().put("point", point);
	}
}
