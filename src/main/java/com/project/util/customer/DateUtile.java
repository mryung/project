package com.project.util.customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.project.entity.project.StartEndTime;

public class DateUtile {
	
	public static Long getCurrentTimeMillis(){
		return 1487145600L*1000;
//		return System.currentTimeMillis();
	}
	public static Long getFirstDataTime(){
		//得到数据库中存在的 最早数据的时间
//		return 1330531200000L; // 2012 3 1
		return 1331514900000L;
	}
	
	public static Long getDayStartMillis(Long millis){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 000);
		return calendar.getTimeInMillis();
	}
	//得到某一月初始的日
	public static Long getFirstDayOfYear(int year){
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR,year);
	    calendar.set(Calendar.MONTH, Calendar.JANUARY);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 000);
	    return calendar.getTimeInMillis() ;
	}
	//得到某一月初始的日
	public static Long getEndDayOfMonth(long millis){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		calendar.add(Calendar.MONTH, 1);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 000);
	    return calendar.getTimeInMillis();
	}
	
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	public static void formate(Long starttime,Long endTime){
		System.err.println(dateFormat.format(new Date(starttime))+"************"+dateFormat.format(new Date(endTime)));
	}
	
	public static List<StartEndTime> monthSplite(Long startTime,Long endTime){
		
		List<StartEndTime> times = new LinkedList<>();
		Long endDayOfMonth = getEndDayOfMonth(startTime); //方法中减了一毫秒
		while(endDayOfMonth < endTime){
			times.add(new StartEndTime(startTime, endDayOfMonth));
			startTime = endDayOfMonth;
			endDayOfMonth = getEndDayOfMonth(startTime);
		}
		times.add(new StartEndTime(startTime, endTime));
		return times;
	}
	
	public static List<StartEndTime> yearSplite(Long startTime,Long endTime){
		List<StartEndTime> times = new LinkedList<>();
		Long beforeOneYear = addYears(startTime, 1);
		while (beforeOneYear < endTime) {
			times.add(new StartEndTime(startTime, beforeOneYear));
			startTime = beforeOneYear ;
			beforeOneYear = addYears(startTime, 1);
		}
		times.add(new StartEndTime(startTime, endTime));
		return times;
	}
	
	public static List<StartEndTime> weekSplite(Long startTime,Long endTime){
		List<StartEndTime> times = new LinkedList<>();
		Long beforeOneYear = addDays(startTime, 7);
		while (beforeOneYear < endTime) {
			times.add(new StartEndTime(startTime, beforeOneYear));
			startTime = beforeOneYear;
			beforeOneYear = addDays(startTime, 7);
		}
		times.add(new StartEndTime(startTime, endTime));
		return times;
	}
	
	public static List<StartEndTime> daySplite(Long startTime, Long endTime) {
		List<StartEndTime> times = new LinkedList<>();
		Long beforeOneYear = addDays(startTime, 1);
		while (beforeOneYear < endTime) {
			times.add(new StartEndTime(startTime, beforeOneYear));
			startTime = beforeOneYear  ;
			beforeOneYear = addDays(startTime, 1);
		}
		times.add(new StartEndTime(startTime, endTime));
		return times;
	}
	
	public static List<StartEndTime> hourSplite(Long startTime, Long endTime) {
		System.out.println("********************************************");
		List<StartEndTime> times = new LinkedList<>();
		Long beforeOneYear = addHours(startTime, 1) ;
		while (beforeOneYear < endTime) {
			times.add(new StartEndTime(startTime, beforeOneYear));
			startTime = beforeOneYear ;
			beforeOneYear = addHours(startTime, 1);
		}
		times.add(new StartEndTime(startTime, endTime));
		return times;
	}
	
	public static Long addHours(Long startTime,int hour){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTimeInMillis();
	}
	
	public static Long addYears(Long startTime,int year){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		calendar.add(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 000);
		return calendar.getTimeInMillis();
	}
	
	public static Long addDays(Long startTime,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startTime);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTimeInMillis();
	}
	
	public static Long getFirDayOfYear(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, Calendar.JANUARY, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Long startTime = calendar.getTimeInMillis();
		
		return startTime;
	}
	
	public static Long getEndDayOfYear(int year){
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		Long endTime;
		if(currentYear == year){
			endTime = getCurrentTimeMillis();
		}else{
//			calendar.set(year+1, Calendar.DECEMBER, 31, 23, 59, 59);
//			calendar.set(Calendar.MILLISECOND, 999);
			endTime = getFirDayOfYear(year+1);
		}
		return endTime;
	}
	
	public static List<StartEndTime> getMonthList(int year){
		Long start = getFirstDayOfYear(year);
		Long end = getEndDayOfYear(year);
		List<StartEndTime> time = monthSplite(start, end);
		return time;
	}
	
	public static Long getFirstMonDayOfMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month-1, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		//这个月第一天的时间
		long firstDayOfMonth = calendar.getTimeInMillis();
		//得到这个月第一个星期一
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		long firstMonOfMonth = calendar.getTimeInMillis();
		
		long startTime;
		if(firstMonOfMonth <= firstDayOfMonth){
			startTime = firstMonOfMonth;
		}else{
			startTime = addDays(firstMonOfMonth, -7);
		}
		return startTime;
	}
	
	public static Long getEndSundayOfMonth(Long start,int year,int month){
		Calendar calendar = Calendar.getInstance();
		//得到下个月的第一天
		calendar.set(year, month, 1,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);
		Long currentTime = getCurrentTimeMillis();
		Long endTimeOfMonth = calendar.getTimeInMillis();
		if(endTimeOfMonth > currentTime){
			endTimeOfMonth = currentTime;
		}
		
		while(start < endTimeOfMonth){
			start = addDays(start, 7);
		}
		return start;
	}
	
	public static List<StartEndTime> getWeekList(int year,int month){
		Long start = getFirstMonDayOfMonth(year, month);
		//开始计算endDay
		//得到这个月最后一天
		Long end  = getEndSundayOfMonth(start, year, month);
		
		List<StartEndTime> time = new LinkedList<>();
		Long beforeOnWeek = addDays(start, 7);
		while(beforeOnWeek < end){
			time.add(new StartEndTime(start, beforeOnWeek));
			start = beforeOnWeek;
			beforeOnWeek = addDays(start, 7);
		}
		time.add(new StartEndTime(start,beforeOnWeek));
		return time;
	}
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015,7, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
	}
	
	//***************得到一周的所有天
	public static Long getFirstDayOfWeek(int year, int month, int week) {
		Long firstMonDayOfMonth = getFirstMonDayOfMonth(year, month);
		Long start = addDays(firstMonDayOfMonth, (week-1)*7);
		return start;
	}
	public static Long getEndDayOfWeek(int year, int month, int week){
		Long firstMonDayOfMonth = getFirstMonDayOfMonth(year, month);
		Long end = addDays(firstMonDayOfMonth, week*7);
		return end;
	}
	public static StartEndTime getWeekTime(int year, int month, int week){
		Long firstMonDayOfMonth = getFirstMonDayOfMonth(year, month);
		Long start = addDays(firstMonDayOfMonth, (week-1)*7);
		Long end = addDays(start, week*7);
		return new StartEndTime(start,end);
	}
	public static List<StartEndTime> getWeekDayList(int year,int month,int week){
		long startTime = DateUtile.getFirstDayOfWeek(year, month, week);
		long endTime = addDays(startTime, 7);
		List<StartEndTime> time = daySplite(startTime, endTime);
		return time;
	}
	
	//*******************具体某一天
	public static Long getFirstTimeOfDay(int year, int month, int week, int day){
		Long firstDayOfWeek = getFirstDayOfWeek(year, month, week);
		Long start = addDays(firstDayOfWeek, day);
		return start;
	}
	public static Long getEndTimeOfDay(int year, int month, int week, int day){
		Long firstDayOfWeek = getFirstDayOfWeek(year, month, week);
		Long end = addDays(firstDayOfWeek, day+1);
		return end;
	}
	
	public static List<StartEndTime> getHourList(int year, int month, int week, int day) {
		long startTime = getFirstDayOfWeek(year, month, week);
		startTime = addDays(startTime, (week-1)*7+day);
		long endTime = addDays(startTime, 1);
		List<StartEndTime> time = hourSplite(startTime, endTime);
		return time;
	}
	public static StartEndTime getCurrentDayTime() {
		Long end = getCurrentTimeMillis();
		Long start = getDayStartMillis(end);
		
		return new StartEndTime(start, end);
	}
	
}
