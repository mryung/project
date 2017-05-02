package com.project.service.impl.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BasicDao;
import com.project.entity.project.StartEndTime;
import com.project.service.CommonService;
import com.project.util.customer.BuildPointNo;
import com.project.util.customer.CataloguePointNo;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CataloguePointNo cataloguePointNo;

	@Autowired
	private BuildPointNo buildPointNo;
	
	@Autowired
	private BasicDao basicDao;
	
	//得到所有楼层公共消耗
	@Override
	public double totalBuild(StartEndTime time){
		double total =  basicDao.selectPointSum(time, buildPointNo.getAllBuildPointNo());
		return total;
	}
	// 得到所有的 交换机
	@Override
	public double totalTransfomer(StartEndTime time) {
		double total =  basicDao.selectPointSum(time, cataloguePointNo.getTransformerPointNo());
		return total;
	}
	
	
}
