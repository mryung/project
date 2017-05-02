package com.project.util.customer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

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
public class DetailPointNo {
	
	Map<String,List<Integer>> lightPointNo = new HashMap<>(); //照明
	Map<String,List<Integer>> airConditionerPointNo; //空调
	Map<String,List<Integer>> transformerPointNo; //变压器
	Map<String,List<Integer>> computerRoomPointNo; //电脑房
	Map<String,List<Integer>> otherPointNo; //其他
	
	List<Integer> allCataloguePointNo; //所用用电
	
	public DetailPointNo() {
		
		
	}
	public static void main(String[] args) {
		System.err.println(getCatalogueNo("一号楼"));
		System.err.println(getCatalogueNo("照明插座").size());
		
	}
	
	static List<Integer> getCatalogueNo(String buildName){
		try {
			LinkedList<Integer> listPoint = new LinkedList<>();
			SAXReader saxReader = new SAXReader();
//			ClassPathResource classPathResource = new ClassPathResource("property/catalogue.xml");
			Document read = saxReader.read(new File("detail.xml"));
//			Document read = saxReader.read(classPathResource.getFile());
			Element rootElement = read.getRootElement();
			Element element = rootElement.element(buildName);
			Iterator<Element> iterator = element.elementIterator();
			while(iterator.hasNext()){
				Element next = iterator.next();
				listPoint.add(Integer.parseInt(next.attributeValue("No")));
			}
			return listPoint;
		} catch (NumberFormatException | DocumentException e) {
			e.printStackTrace();
			return null;
		} 
	}
}
