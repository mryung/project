package com.project.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ehcache.CustomerCacheUtil;
import com.project.entity.project.StartEndTime;
import com.project.mapper.BasicMapper;
import com.project.util.customer.DateUtile;
import com.project.util.customer.TableNameUtil;

@Repository
public class BasicDao {
	
	@Autowired
	private CustomerCacheUtil cacheUtile;
	
	@Autowired
	private BasicMapper basicMapper;

	//得到一个月的用电量
	public Double selectPointSum(StartEndTime startEndTime,List<Integer> pointNos){
		Double total = 0.0;
		String key = getKey(startEndTime, pointNos);
		Double value = (Double) cacheUtile.getValue(key);
		if(value != null){
			total = value;
		}else{
			//进行时间的判断
			if(startEndTime.getEndTime() <= DateUtile.getFirstDataTime()/1000){
				total = 0.0;
			}else{
				String tableName1 = TableNameUtil.getTableName(startEndTime.getStartTime()); //因为在前面除了1000
				String tableName2 = TableNameUtil.getTableName(startEndTime.getEndTime());
				total = basicMapper.basicSelect1(tableName1,tableName2,
						startEndTime.getStartTime(), startEndTime.getEndTime(),
						pointNos);
				if(total < 0){
					total = 0.0;
				}
			}
			//设置缓存
			cacheUtile.writeValue(key, value);
		}
		return total;
	}
	
	//方法同上，只是把节点列表改为了字符串
	public Double selectPointSum(StartEndTime startEndTime,String pointNos){
		double total = 0.0;
		String key = getKey(startEndTime, pointNos);
		Double value = (Double) cacheUtile.getValue(key);
		if(value != null){
			total = value;
		}else{
			//进行时间的判断
			if(startEndTime.getEndTime() <= DateUtile.getFirstDataTime()/1000){
				total = 0.0;
			}else{
				String tableName1 = TableNameUtil.getTableName(startEndTime.getStartTime());
				String tableName2 = TableNameUtil.getTableName(startEndTime.getEndTime());
				total = basicMapper.basicSelectByPoint1(tableName1,tableName2,
						startEndTime.getStartTime(), startEndTime.getEndTime(),
						pointNos);
				if(total < 0){
					total = 0.0;
				}
			}
			//设置缓存
			cacheUtile.writeValue(key, total);
		}
		return total;
	}
	
	
	public String getKey(StartEndTime time,String pointNos){
		StringBuffer string = new StringBuffer();
		string.append(time.getStartTime());
		string.append(time.getEndTime());	
		string.append(pointNos);
		return string.toString();
	}
	public String getKey(StartEndTime time,List<Integer> pointNos){
		StringBuffer string = new StringBuffer();
		string.append(time.getStartTime());
		string.append(time.getEndTime());
		Iterator<Integer> iterator = pointNos.iterator();
		while (iterator.hasNext()) {
			string.append(iterator.next());
			
		}
		return string.toString();
	}
}
