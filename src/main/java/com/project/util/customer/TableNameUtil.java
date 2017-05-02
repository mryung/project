package com.project.util.customer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TableNameUtil {
	public static SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	public static String getTableName(Long millis){
		Date date = new Date(millis*1000L);
		return "TMR_WIND_ELCPOWER"+format.format(date);
	}
	public static String getTable(Long millis){
		Date date = new Date(millis);
		return "TMR_WIND_ELCPOWER"+format.format(date);
	}
}
