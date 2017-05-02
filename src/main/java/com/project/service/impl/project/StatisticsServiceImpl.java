package com.project.service.impl.project;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.project.StartEndTime;
import com.project.mapper.BasicMapper;
import com.project.service.StatisticsService;
import com.project.util.customer.CataloguePointNo;
import com.project.util.customer.DateUtile;
import com.project.util.customer.TableNameUtil;


/**
 * 
 * @projectNam hisdb
 * @classname  StatisticsServiceImpl
 * @<p>description: </p>
 * @email     2327542415@qq.com
 * @date       2017年2月14日:下午9:44:58
 * @version    0.0.1
 *
 */

@Service
public class StatisticsServiceImpl implements StatisticsService {
   
	@Autowired
	private CataloguePointNo cataloguePointNo;
	
	@Autowired
	private BasicMapper basicDao;
	
	/**
	 * 根据 flag 来查询
	 */
	//得到当日电脑数据
	@Override
	public List<Double> statisticsThroughFloor(int flag) {
		//得到说有楼层数据按照日期的间隔
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 001);
		long millis = calendar.getTimeInMillis();
		return null;
	}

	@Override
	public List<Double> statisticsThroughSystem(int flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double allStatistics(Long startTime, Long endTime) {
		//TODO 以后添加ehcache缓存
		//划分时间段
		Double total = 0.0;
		List<StartEndTime> timeList = DateUtile.monthSplite(startTime, endTime);
		Iterator<StartEndTime> iterator = timeList.iterator();
		while (iterator.hasNext()) {
			StartEndTime time = iterator.next();
			String tableName = TableNameUtil.getTableName(time.getStartTime());
			total += basicDao.basicSelect(tableName,
					time.getStartTime(), time.getEndTime(),
					cataloguePointNo.getTransformerPointNo());
		}
		return total;
	}

	@Override
	public List<Double> statisticsThroughFloor(Long startTime, Long endTime) {
		//TODO 以后添加ehcache缓存
		//划分时间段
		Double total = 0.0;
		List<StartEndTime> timeList = DateUtile.monthSplite(startTime, endTime);
		Iterator<StartEndTime> iterator = timeList.iterator();
		while (iterator.hasNext()) {
			StartEndTime time = iterator.next();
			String tableName = TableNameUtil.getTableName(time.getStartTime());
			total += basicDao.basicSelect(tableName,
					time.getStartTime(), time.getEndTime(),
					cataloguePointNo.getTransformerPointNo());
		}
		return null;
	}
	
	
	

}
