package com.project.service.impl.project;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BasicDao;
import com.project.entity.project.StartEndTime;
import com.project.service.BuildService;
import com.project.service.CommonService;
import com.project.util.customer.BuildPointNo;

@Service
public class BuildServiceImpl implements BuildService {

	
	@Autowired
	private BuildPointNo buildPointNo;
	
	@Autowired
	private BasicDao basicDao;
	
	@Autowired
	private CommonService commonService;
	
	/**
	 *  所有楼 在这段时间内的 消耗
	 */
	@Override
	public List<Double> allBuildConsumeList(StartEndTime time) {
		List<Double> totalList = new LinkedList<>();
		List<List<Integer>> allList = buildPointNo.getAllList();
		
		//公共消耗 （变压器的用电 - 所有楼层的用电）
		double average = (commonService.totalTransfomer(time) - commonService.totalBuild(time)) / allList.size();
		for (List<Integer> list : allList) {
			// 每栋楼的消耗,加上平均消耗(平均消耗为： (交换器 - 所有楼层消耗) / 楼层数 )
			Double total = basicDao.selectPointSum(time, list);
			total += average;
			if (total < 0) {
				totalList.add(0.0);
			} else {
				totalList.add(total);
			}
		}
		return totalList;
	}
	/**
	 * 计算一栋楼在 每段时间类的消耗
	 */
	@Override
	public List<Double> buildByTime(List<StartEndTime> timeList,int elementname) {
		List<Double> timeData = new LinkedList<>();
		List<Integer> buildNo = buildPointNo.getBuildNo(elementname);
		for (StartEndTime time : timeList) {
			double average = (commonService.totalTransfomer(time) - commonService.totalBuild(time)) / 6;
			Double total = basicDao.selectPointSum(time, buildNo);
			timeData.add(total+average);
		}
		return timeData;
	}

}
