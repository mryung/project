package com.project.controller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.myproject.message.R;
import com.project.entity.ScheduleJobEntity;
import com.project.service.ScheduleJobService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ScheduleJobService scheduleJobService;
	
	@RequestMapping("/index")
	public String index(){
		
		return "sys/task/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> listTask(Pageable pageable){
		PageInfo<ScheduleJobEntity> pageInfo = scheduleJobService.queryList(pageable);
		return R.ok().put("pageInfo", pageInfo);
	}
	
	@RequestMapping("/add")
	public String add(Long jobId,Map<String,Object> map){
		map.put("jobId", jobId);
		return "sys/task/add";
	}
	
	@ResponseBody
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public Map<String,Object> data(Long jobId){
		ScheduleJobEntity scheduleJobEntity = scheduleJobService.queryObject(jobId);
		return R.ok().put("job", scheduleJobEntity);
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Map<String,Object> save(ScheduleJobEntity entity){
		
		if(entity.getJobId() != null){
			//更新
			scheduleJobService.update(entity);
			
		}else{
			scheduleJobService.save(entity);
		}
		return R.ok("保存成功").put("jobId", entity.getJobId());
	}
}
