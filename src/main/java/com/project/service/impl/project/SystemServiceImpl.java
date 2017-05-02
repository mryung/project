package com.project.service.impl.project;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BasicDao;
import com.project.entity.project.StartEndTime;
import com.project.service.CommonService;
import com.project.service.SystemService;
import com.project.util.customer.CataloguePointNo;
import com.project.util.customer.PointDataUtil;
import com.project.util.customer.XmlUtil;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private CataloguePointNo cataloguePointNo;
	
	@Autowired
	private BasicDao basicDao;
	
	@Autowired
	private CommonService commonService;
	
	@Override
	public List<Double> systemByTime(StartEndTime time) {
		List<Double> consume = new LinkedList<>();
		// 得到系统的给个模块的统计
		Element root = CataloguePointNo.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> elements = root.elements();
		double inLight = basicDao.selectPointSum(time, PointDataUtil.intoNos);// 进线消耗
		for (Element element : elements) {
			List<Integer> pointNos = XmlUtil.getChildElementPointNos(element);
			Double total = null;
			if ("变压器".equals(element.getName())) {
				// 变压器的量：
				double transfomer = basicDao.selectPointSum(time, pointNos);
				// 每个变压要减去相应的进线既为自己的用量(改为所有变压器的减去进线为电量)
				total = transfomer - inLight;
			} else if ("其他".equals(element.getName())) {
				/// 其他的其他 += （进线 - 系统除开变压器） 改为全部其他+(进线-开出变压器的其他变量)
				double other = basicDao.selectPointSum(time, cataloguePointNo.getOtherForOther());
				double excTran = basicDao.selectPointSum(time, cataloguePointNo.getExceptTransformer());
				total = basicDao.selectPointSum(time, cataloguePointNo.getExceptOtherForOther());
				total += other + (inLight - excTran);
			} else {
				total = basicDao.selectPointSum(time, pointNos);
			}
			consume.add(total);
		}
		return consume;
	}

	@Override
	public List<Double> allConsume(List<StartEndTime> timelist) {
		//根据变压器得到所有的消耗
		List<Double> timeDate = new LinkedList<>();
		for (StartEndTime time : timelist) {
			//得到变压器的数据
			Double total = commonService.totalTransfomer(time);
			timeDate.add(total);
		}
		return timeDate;
	}
	
	
}
