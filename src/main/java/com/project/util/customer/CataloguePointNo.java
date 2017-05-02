package com.project.util.customer;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Element;

/**
 * 
 * @projectNam hisdb
 * @classname  BuildPointNo
 * @<p>description: 建筑楼层电表统计</p>
 * @email     2327542415@qq.com
 * @date       2017年3月1日:下午12:58:18
 * @version    0.0.1
 *
 */
public class CataloguePointNo {
	
	List<Integer> lightPointNo; //照明
	List<Integer> airConditionerPointNo; //空调
	List<Integer> transformerPointNo; //变压器
	List<Integer> computerRoomPointNo; //电脑房
	List<Integer> otherPointNo; //其他
	
	List<Integer> allCataloguePointNo; //所用用电
	//除了变压器所有
	List<Integer> exceptTransformer = new LinkedList<>();
	
	List<Integer> exceptOtherForOther;
	
	List<Integer> otherForOther;
	//排除其他的其他
	public List<Integer> getExceptOtherForOther(){
		if(exceptOtherForOther == null){
			exceptOtherForOther = new LinkedList<>();
			Element rootElement = XmlUtil.getRootElement("property/detail.xml");
			Element otherElement = rootElement.element("其他");
			exceptOtherForOther.addAll(XmlUtil.getChildElementPointNos(otherElement, "电梯"));
			exceptOtherForOther.addAll(XmlUtil.getChildElementPointNos(otherElement, "消防"));
			
		}
		return exceptOtherForOther;
	}
	
	public List<Integer> getOtherForOther(){
		
		if(otherForOther == null){
			otherForOther = new LinkedList<>();
			Element rootElement = XmlUtil.getRootElement("property/detail.xml");
			Element otherElement = rootElement.element("其他");
			otherForOther.addAll(XmlUtil.getChildElementPointNos(otherElement, "其他"));
			
		}
		
		return otherForOther;
	}
	
	public CataloguePointNo() {
		
		System.out.println("********初始化分类信息*************");
		
		lightPointNo = getCatalogueNo("照明插座");
		airConditionerPointNo = getCatalogueNo("空调");
		transformerPointNo = getCatalogueNo("变压器");
		computerRoomPointNo = getCatalogueNo("机房");
		otherPointNo = getCatalogueNo("其他");
		
		allCataloguePointNo = new LinkedList<>();
		
		allCataloguePointNo.addAll(lightPointNo); exceptTransformer.addAll(lightPointNo);
		allCataloguePointNo.addAll(airConditionerPointNo);exceptTransformer.addAll(airConditionerPointNo);
		allCataloguePointNo.addAll(transformerPointNo);
		allCataloguePointNo.addAll(computerRoomPointNo);exceptTransformer.addAll(computerRoomPointNo);
		allCataloguePointNo.addAll(otherPointNo);exceptTransformer.addAll(otherPointNo);
	}
	
	public static String filename = "property/catalogue.xml" ;
	
	public static Element getRootElement(){
		
		return XmlUtil.getRootElement(filename);
	}
	
	
	
	static List<Integer> getCatalogueNo(String buildName){

		Element rootElement = getRootElement();
		return XmlUtil.getChildElementPointNos(rootElement, buildName);
	}
	
	

	public List<Integer> getExceptTransformer() {
		return exceptTransformer;
	}



	public void setExceptTransformer(List<Integer> exceptTransformer) {
		this.exceptTransformer = exceptTransformer;
	}



	public List<Integer> getLightPointNo() {
		return lightPointNo;
	}


	public void setLightPointNo(List<Integer> lightPointNo) {
		this.lightPointNo = lightPointNo;
	}


	public List<Integer> getAirConditionerPointNo() {
		return airConditionerPointNo;
	}


	public void setAirConditionerPointNo(List<Integer> airConditionerPointNo) {
		this.airConditionerPointNo = airConditionerPointNo;
	}


	public List<Integer> getTransformerPointNo() {
		return transformerPointNo;
	}


	public void setTransformerPointNo(List<Integer> transformerPointNo) {
		this.transformerPointNo = transformerPointNo;
	}


	public List<Integer> getComputerRoomPointNo() {
		return computerRoomPointNo;
	}


	public void setComputerRoomPointNo(List<Integer> computerRoomPointNo) {
		this.computerRoomPointNo = computerRoomPointNo;
	}


	public List<Integer> getOtherPointNo() {
		return otherPointNo;
	}


	public void setOtherPointNo(List<Integer> otherPointNo) {
		this.otherPointNo = otherPointNo;
	}


	public List<Integer> getAllCataloguePointNo() {
		return allCataloguePointNo;
	}


	public void setAllCataloguePointNo(List<Integer> allCataloguePointNo) {
		this.allCataloguePointNo = allCataloguePointNo;
	}
	
	
	
}
