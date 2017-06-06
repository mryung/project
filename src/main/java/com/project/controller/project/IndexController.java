package com.project.controller.project;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.R;
import com.project.entity.project.StartEndTime;
import com.project.security.shiro.SessionUtil;
import com.project.util.customer.DateUtile;


/**
 * 
 * @projectNam hisdb
 * @classname  IndexController
 * @<p>description: 用来显示catagory列表</p>
 * @email     2327542415@qq.com
 * @date       2017年3月10日:下午4:21:03
 * @version    0.0.1
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index.html")
	public String index(Map<String,Object> map){
		
		//用户名和传到前台
		map.put("username", SessionUtil.getUsername());
		return "index";
	}
	
	/**
	 * 
	 * @description  得到年中月份的 catagory
	 * @param year
	 * @return
	 * Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value="/month",method=RequestMethod.POST)
	public Map<String,Object> month(int year){
		Calendar calendar = Calendar.getInstance();
		List<StartEndTime> monthList = null;
		if( year >= 2012 && year <= calendar.get(Calendar.YEAR)){
			monthList = DateUtile.getMonthList(year);
		}
		return R.ok().put("month", monthList);
	}
	
	/**
	 * 
	 * @description 得到这年中月的周数 
	 * @param year
	 * @param month
	 * @return
	 * Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value="/week",method=RequestMethod.POST)
	public Map<String,Object> week(int year,int month){
		List<StartEndTime> weekList = DateUtile.getWeekList(year, month);
		return R.ok().put("week", weekList);
	}
	
	@ResponseBody
	@RequestMapping(value="/day",method=RequestMethod.POST)
	public Map<String,Object> day(int year,int month,int week){
		//得到天数
		List<StartEndTime> dayList = DateUtile.getWeekDayList(year,month,week);
		return R.ok().put("day", dayList);
	}
}
