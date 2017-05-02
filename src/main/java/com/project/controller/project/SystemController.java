package com.project.controller.project;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.R;
import com.project.entity.project.StartEndTime;
import com.project.service.SystemService;
import com.project.util.customer.DateUtile;

/**
 * 
 * @projectNam hisdb
 * @classname  SystemController
 * @<p>description: 查看系统功能消耗的</p>
 * @email     2327542415@qq.com
 * @date       2017年3月14日:下午6:55:53
 * @version    0.0.1
 *
 */
@Controller
@RequestMapping(value="/system")
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	//当天系统用电量统计
	@ResponseBody
	@RequestMapping(value="/currentSystem",method=RequestMethod.POST)
	public Map<String, Object> currentSystemConsume(){
		StartEndTime time = DateUtile.getCurrentDayTime();
		List<Double> systemConsume = systemService.systemByTime(time);
		return R.ok().put("detailData", systemConsume);
	}
	
	//统计这一年的数据
	@ResponseBody
	@RequestMapping(value="/systemAll",method=RequestMethod.POST)
	public Map<String,Object> allSystemYear(){
		Long start = DateUtile.getFirstDataTime();
		Long end = DateUtile.getCurrentTimeMillis();
		DateUtile.formate(start, end);
		
		List<StartEndTime> yearList = DateUtile.yearSplite(start,end);
		StartEndTime time = new StartEndTime(start, end);
		
		List<Double> timeData = systemService.allConsume(yearList);
		//detail数据表示
		List<Double> detailData = systemService.systemByTime(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
	
	//某一年
	@ResponseBody
	@RequestMapping(value="/systemYear",method=RequestMethod.POST)
	public Map<String,Object> systemYear(int year){
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		//得到这一年的列表
		Long start = DateUtile.getFirDayOfYear(year);
		Long end = DateUtile.getEndDayOfYear(year);
		List<StartEndTime> monthList = DateUtile.monthSplite(start, end);
		StartEndTime time = new StartEndTime(start, end);
		
		List<Double> timeData = systemService.allConsume(monthList);
		//detail数据表示
		List<Double> detailData = systemService.systemByTime(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
	
	@ResponseBody
	@RequestMapping(value="/systemMonth",method=RequestMethod.POST)
	public Map<String,Object> systemMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		if(month < 1 || month > 12){
			return null;
		}
		Long start = DateUtile.getFirstMonDayOfMonth(year, month);
		Long end = DateUtile.getEndSundayOfMonth(start, year, month);
		
		List<StartEndTime> weekList = DateUtile.weekSplite(start,end);
		StartEndTime time = new StartEndTime(start, end);
		
		List<Double> timeData = systemService.allConsume(weekList);
		//detail数据表示
		List<Double> detailData = systemService.systemByTime(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
	
	@ResponseBody
	@RequestMapping(value="/systemWeek",method=RequestMethod.POST)
	public Map<String,Object> systemWeek(int year,int month,int week){
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		if(month < 1 || month > 12){
			return null;
		}
		Long start = DateUtile.getFirstDayOfWeek(year,month,week);
		Long end = DateUtile.getEndDayOfWeek(year, month, week);
		
		List<StartEndTime> dayList = DateUtile.daySplite(start, end);
		StartEndTime time = new StartEndTime(start, end);
		
		List<Double> timeData = systemService.allConsume(dayList);
		//detail数据表示
		List<Double> detailData = systemService.systemByTime(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
	
	@ResponseBody
	@RequestMapping(value="/systemDay",method=RequestMethod.POST)
	public Map<String,Object> systemDay(int year,int month,int week,int day){
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		if(month < 1 || month > 12){
			return null;
		}
		Long start = DateUtile.getFirstTimeOfDay(year, month, week, day);
		Long end = DateUtile.getEndTimeOfDay(year, month, week, day);
		
		List<StartEndTime> hourList = DateUtile.hourSplite(start, end);
		StartEndTime time = new StartEndTime(start, end);
		
		List<Double> timeData = systemService.allConsume(hourList);
		//detail数据表示
		List<Double> detailData = systemService.systemByTime(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
} 
