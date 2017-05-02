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

public class XmlUtil {
	
	public static Element getRootElement(String filename){
		try {
			SAXReader saxReader = new SAXReader();
			ClassPathResource classPathResource = new ClassPathResource(filename);
			Document read = saxReader.read(classPathResource.getFile());
			Element rootElement = read.getRootElement();
			
			return rootElement;
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Integer> getChildElementPointNos(Element rootElement,String childName){
		List<Integer> listPoint = new LinkedList<>();
		Element node = rootElement.element(childName);
		Iterator<Element> iterator = node.elementIterator();
		while(iterator.hasNext()){
			Element next = iterator.next();
			listPoint.add(Integer.parseInt(next.attributeValue("No")));
		}
		return listPoint;
	}
	
	public static List<Integer> getChildElementPointNos(Element rootElement){
		List<Integer> listPoint = new LinkedList<>();
		Iterator<Element> iterator = rootElement.elementIterator();
		while(iterator.hasNext()){
			Element next = iterator.next();
			listPoint.add(Integer.parseInt(next.attributeValue("No")));
		}
		return listPoint;
	}
}
