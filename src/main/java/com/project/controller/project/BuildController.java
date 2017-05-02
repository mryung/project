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
import com.project.util.customer.DateUtile;

/**
 * 
 * @projectNam hisdb
 * @classname  BuildController
 * @<p>description:统计控制器</p>
 * @email     2327542415@qq.com
 * @date       2017年2月14日:下午6:24:32
 * @version    0.0.1
 *
 */
@Controller
@RequestMapping("/build")
public class BuildController {
	
	@Autowired
	private BuildService buildConsumeService;
	
	/**
	 * @description 楼层电联统计（分时间段）。
	 * 2017
	 * @return
	 * Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value="/currentBuild",method=RequestMethod.POST)
	public Map<String, Object> currentBuildConsume(){
		StartEndTime time = DateUtile.getCurrentDayTime();
		List<Double> buildConsume = buildConsumeService.allBuildConsumeList(time);
		return R.ok().put("detailData", buildConsume);
	}
	
	//根据楼程来查询需要的楼 按年来查询
	@ResponseBody
	@RequestMapping(value="/buildAll",method=RequestMethod.POST)
	public Map<String,Object> buildAll(int elementname){
		
		//得到系统的数据所有的时间
		Long start = DateUtile.getFirstDataTime();
		Long end = DateUtile.getCurrentTimeMillis();

		List<StartEndTime> yearList = DateUtile.yearSplite(start,end);
		StartEndTime time = new StartEndTime(start, end);
		
		//这栋楼几年的消耗
		List<Double> timeData = buildConsumeService.buildByTime(yearList, elementname);
		//所有楼层的消耗
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		
		return R.ok().put("timeData", timeData).put("detailData", detailData);
	}
	
	
	//某一年的电量消耗
	@ResponseBody
	@RequestMapping(value="/buildYear",method=RequestMethod.POST)
	public Map<String,Object> buildYear(int year,int elementname){
		//得到业务判断
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		//得到这一年的列表
		Long start = DateUtile.getFirDayOfYear(year);
		Long end = DateUtile.getEndDayOfYear(year);
		
		StartEndTime time = new StartEndTime(start, end);
		List<StartEndTime> monthList = DateUtile.monthSplite(start, end);
		
		//得到楼这一年每个月的楼层消耗
		List<Double> timeData = buildConsumeService.buildByTime(monthList, elementname);
		//所有楼层这一年的消耗
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		
		return R.ok().put("timeData", timeData).put("detailData", detailData);
	}
	
	@ResponseBody
	@RequestMapping(value="/buildMonth",method=RequestMethod.POST)
	public Map<String,Object> buildMonth(int year,int month,int elementname){
		
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

		//得到这栋这一月每个星期的消耗
		List<Double> timeData = buildConsumeService.buildByTime(weekList, elementname);
		//所有楼层这个月的消耗比
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		
		return R.ok().put("timeData", timeData).put("detailData", detailData);
	}
	
	@ResponseBody
	@RequestMapping(value="/buildWeek",method=RequestMethod.POST)
	public Map<String,Object> buildWeek(int year,int month,int week,int elementname){
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
		StartEndTime time = new StartEndTime(start,end);

		//得到楼层这一周每天的消耗
		List<Double> timeData = buildConsumeService.buildByTime(dayList, elementname);
		//得到每栋楼这周的消耗
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		return R.ok().put("timeData", timeData).put("detailData", detailData);
	}
	
	//得到某一天的消耗
	@ResponseBody
	@RequestMapping(value="/buildDay",method=RequestMethod.POST)
	public Map<String,Object> buildDay(int year,int month,int week,int day,int elementname){
		Calendar calendar = Calendar.getInstance();
		if( year < 2012 || year > calendar.get(Calendar.YEAR)){
			return null;
		}
		if(month < 1 || month > 12){
			return null;
		}
		Long start = DateUtile.getFirstTimeOfDay(year, month, week, day);
		Long end = DateUtile.getEndTimeOfDay(year, month, week, day);
		
		StartEndTime time =  new StartEndTime(start,end);
		List<StartEndTime> hourList = DateUtile.hourSplite(start, end);

		//得到系统的年消耗
		List<Double> timeData = buildConsumeService.buildByTime(hourList, elementname);
		//系统年消耗
		List<Double> detailData = buildConsumeService.allBuildConsumeList(time);
		return R.ok().put("timeData", timeData).put("detailData", detailData);
	}
}
