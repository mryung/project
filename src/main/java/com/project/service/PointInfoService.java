package com.project.service;

import com.myproject.message.PageInfo;
import com.myproject.message.Pageable;
import com.project.entity.PointInfo;

public interface PointInfoService {

	PageInfo<PointInfo> queryList(Pageable pageable);

	Integer savePointInfo(PointInfo pointInfo);

	PointInfo findPoint(Long pointId);


}
