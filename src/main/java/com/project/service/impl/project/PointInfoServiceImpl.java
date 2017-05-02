package com.project.service.impl.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.PointInfo;
import com.project.mapper.PointInfoDao;
import com.project.service.PointInfoService;

@Service
public class PointInfoServiceImpl implements PointInfoService{
	
	@Autowired
	private PointInfoDao pointInfoDao;
	
	@Override
	public PageInfo<PointInfo> queryList(Pageable pageable) {
		int total = pointInfoDao.queryTotal();
//		PageHelper.startPage(pageable.getPage(), pageable.getPagesize());
		List<PointInfo> list = pointInfoDao.queryList();
		PageInfo<PointInfo> pageinfo = new PageInfo<PointInfo>(total, list);
		return pageinfo;
	}

	@Override
	public Integer savePointInfo(PointInfo pointInfo) {
		
		PointInfo point = pointInfoDao.queryPoint(pointInfo.getPointCode());
		
		if(pointInfo.getPointId() == null){
			//保存
			if(point != null){
				return 0;
			}
			pointInfoDao.save(pointInfo);
		}else{
			//更新
			if(point != null && !point.getPointId().equals(pointInfo.getPointId())){
				return 0;
			}
			pointInfoDao.update(pointInfo);
		}
		return pointInfo.getPointId();
	}

	@Override
	public PointInfo findPoint(Long pointId) {
		
		return pointInfoDao.queryObject(pointId);
	}


}
