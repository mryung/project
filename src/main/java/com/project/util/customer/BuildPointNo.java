package com.project.util.customer;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
public class BuildPointNo {
	
	private List<Integer> firstBuildPointNo;
	private List<Integer> secondBuildPointNo;
	private List<Integer> thirdBuildPointNo;
	private List<Integer> fourthBuildPointNo;
	private List<Integer> fifthBuildPointNo;
	private List<Integer> sixthBuildPointNo;
	
	private List<Integer> allBuildPointNo;
	
	private List<List<Integer>> allList = new LinkedList<>();
	
	public BuildPointNo() {
		
		System.out.println("********初始化楼层信息*************");
		
		firstBuildPointNo = getBuildNo("一号楼");
		secondBuildPointNo = getBuildNo("二号楼");
		thirdBuildPointNo = getBuildNo("三号楼");
		fourthBuildPointNo = getBuildNo("四号楼");
		fifthBuildPointNo = getBuildNo("五号楼");
		sixthBuildPointNo = getBuildNo("六号楼");
		allBuildPointNo = new LinkedList<>();
		allBuildPointNo.addAll(firstBuildPointNo);allList.add(firstBuildPointNo);
		allBuildPointNo.addAll(secondBuildPointNo);allList.add(secondBuildPointNo);
		allBuildPointNo.addAll(thirdBuildPointNo);allList.add(thirdBuildPointNo);
		allBuildPointNo.addAll(fourthBuildPointNo);allList.add(fourthBuildPointNo);
		allBuildPointNo.addAll(fifthBuildPointNo);allList.add(fifthBuildPointNo);
		allBuildPointNo.addAll(sixthBuildPointNo);allList.add(sixthBuildPointNo);
	}
	
	public List<Integer> getBuildNo(int elementname){
		switch (elementname) {
		case 1:
			return firstBuildPointNo;
		case 2:
			return secondBuildPointNo;
		case 3:
			return thirdBuildPointNo;
		case 4:
			return fourthBuildPointNo;
		case 5:
			return fifthBuildPointNo;
		case 6:
			return sixthBuildPointNo;
		default:
			break;
		}
		
		return null;
	}
	
	public static Element getRootNode(){
		try {
			SAXReader saxReader = new SAXReader();
			ClassPathResource classPathResource = new ClassPathResource("property/build.xml");
			Document read = saxReader.read(classPathResource.getFile());
			Element rootElement = read.getRootElement();

			return rootElement;
			
		} catch (NumberFormatException | DocumentException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static List<Integer> getBuildNo(String buildName){
		try {
			LinkedList<Integer> listPoint = new LinkedList<>();
			Element rootElement = getRootNode();
			
			if(rootElement == null){
				return null;
			}
			Element element = rootElement.element(buildName);
			Iterator<Element> iterator = element.elementIterator();
			
			while(iterator.hasNext()){
				Element next = iterator.next();
				listPoint.add(Integer.parseInt(next.attributeValue("No")));
			}
			return listPoint;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	public List<List<Integer>> getAllList() {
		return allList;
	}

	public void setAllList(List<List<Integer>> allList) {
		this.allList = allList;
	}

	public List<Integer> getFirstBuildPointNo() {
		return firstBuildPointNo;
	}
	public void setFirstBuildPointNo(List<Integer> firstBuildPointNo) {
		this.firstBuildPointNo = firstBuildPointNo;
	}
	public List<Integer> getSecondBuildPointNo() {
		return secondBuildPointNo;
	}
	public void setSecondBuildPointNo(List<Integer> secondBuildPointNo) {
		this.secondBuildPointNo = secondBuildPointNo;
	}
	public List<Integer> getThirdBuildPointNo() {
		return thirdBuildPointNo;
	}
	public void setThirdBuildPointNo(List<Integer> thirdBuildPointNo) {
		this.thirdBuildPointNo = thirdBuildPointNo;
	}
	public List<Integer> getFourthBuildPointNo() {
		return fourthBuildPointNo;
	}
	public void setFourthBuildPointNo(List<Integer> fourthBuildPointNo) {
		this.fourthBuildPointNo = fourthBuildPointNo;
	}
	public List<Integer> getFifthBuildPointNo() {
		return fifthBuildPointNo;
	}
	public void setFifthBuildPointNo(List<Integer> fifthBuildPointNo) {
		this.fifthBuildPointNo = fifthBuildPointNo;
	}
	public List<Integer> getSixthBuildPointNo() {
		return sixthBuildPointNo;
	}
	public void setSixthBuildPointNo(List<Integer> sixthBuildPointNo) {
		this.sixthBuildPointNo = sixthBuildPointNo;
	}

	public List<Integer> getAllBuildPointNo() {
		return allBuildPointNo;
	}
	public void setAllBuildPointNo(List<Integer> allBuildPointNo) {
		this.allBuildPointNo = allBuildPointNo;
	}
	
	public static void main(String[] args) throws IOException, DocumentException {
		System.out.println(BuildPointNo.getBuildNo("一号楼"));
	}
}
