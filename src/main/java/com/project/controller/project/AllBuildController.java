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
import com.project.service.BuildService;
import com.project.service.SystemService;
import com.project.util.customer.DateUtile;

/**
 * 
 * @projectNam hisdb
 * @classname  AllController
 * @<p>description: 系统所有消耗</p>
 * @email     2327542415@qq.com
 * @date       2017年3月14日:下午9:30:25
 * @version    0.0.1
 *
 */
@Controller
@RequestMapping(value="/allBuild")
public class AllBuildController {
	
	@Autowired
	private SystemService systemService;
	@Autowired
	private BuildService buildConsumeService;
	
	//统计这一年的数据
	@ResponseBody
	@RequestMapping(value="/allBuildAll",method=RequestMethod.POST)
	public Map<String,Object> allBuildYear(){
		Long start = DateUtile.getFirstDataTime();
		Long end = DateUtile.getCurrentTimeMillis();

		StartEndTime time = new StartEndTime(start, end);
		List<StartEndTime> yearList = DateUtile.yearSplite(start,end);
		
		//条形显示
		List<Double> timeData = systemService.allConsume(yearList);
		//detail数据表示 拼图显示
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		return R.ok().put("detailData", detailData).put("timeData", timeData);
	}
	
	//某一年
		@ResponseBody
		@RequestMapping(value="/allBuildYear",method=RequestMethod.POST)
		public Map<String,Object> allBuildYear(int year){
			Calendar calendar = Calendar.getInstance();
			if( year < 2012 || year > calendar.get(Calendar.YEAR)){
				return null;
			}
			//得到这一年的列表
			Long start = DateUtile.getFirDayOfYear(year);
			Long end = DateUtile.getEndDayOfYear(year);
			
			StartEndTime time = new StartEndTime(start, end);
			List<StartEndTime> monthList = DateUtile.monthSplite(start, end);

			List<Double> timeData = systemService.allConsume(monthList);
			List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
			
			return R.ok().put("detailData", detailData).put("timeData", timeData);
		}
		
		@ResponseBody
		@RequestMapping(value="/allBuildMonth",method=RequestMethod.POST)
		public Map<String,Object> allBuildMonth(int year,int month){
			Calendar calendar = Calendar.getInstance();
			if( year < 2012 || year > calendar.get(Calendar.YEAR)){
				return null;
			}
			if(month < 1 || month > 12){
				return null;
			}
			Long start = DateUtile.getFirstMonDayOfMonth(year, month);
			Long end = DateUtile.getEndSundayOfMonth(start, year, month);
			
			StartEndTime time = new StartEndTime(start, end);
			List<StartEndTime> weekList = DateUtile.weekSplite(start,end);
			
			List<Double> timeData = systemService.allConsume(weekList);
			List<Double> detailData = buildConsumeService.allBuildConsumeList(time);

			return R.ok().put("detailData", detailData).put("timeData", timeData);
		}
		
		@ResponseBody
		@RequestMapping(value="/allBuildWeek",method=RequestMethod.POST)
		public Map<String,Object> allBuildWeek(int year,int month,int week){
			Calendar calendar = Calendar.getInstance();
			if( year < 2012 || year > calendar.get(Calendar.YEAR)){
				return null;
			}
			if(month < 1 || month > 12){
				return null;
			}
			Long start = DateUtile.getFirstDayOfWeek(year,month,week);
			Long end = DateUtile.getEndDayOfWeek(year, month, week);
			
			StartEndTime time = new StartEndTime(start, end);
			List<StartEndTime> dayList = DateUtile.daySplite(start, end);
			
			//detail数据表示
			List<Double> timeData = systemService.allConsume(dayList);
			List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
			
			return R.ok().put("detailData", detailData).put("timeData", timeData);
		}
		
		@ResponseBody
		@RequestMapping(value="/allBuildDay",method=RequestMethod.POST)
		public Map<String,Object> allBuildDay(int year,int month,int week,int day){
			Calendar calendar = Calendar.getInstance();
			if( year < 2012 || year > calendar.get(Calendar.YEAR)){
				return null;
			}
			if(month < 1 || month > 12){
				return null;
			}
			Long start = DateUtile.getFirstTimeOfDay(year, month, week, day);
			Long end = DateUtile.getEndTimeOfDay(year, month, week, day);
			
			StartEndTime time = new StartEndTime(start, end);
			List<StartEndTime> hourList = DateUtile.hourSplite(start, end);
			
			//detail数据表示
			List<Double> timeData = systemService.allConsume(hourList);
			List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
			
			return R.ok().put("detailData", detailData).put("timeData", timeData);
		}
}
