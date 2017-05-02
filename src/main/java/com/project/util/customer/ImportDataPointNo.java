package com.project.util.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.dom4j.Element;

public class ImportDataPointNo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hisdb"
				, "sa", "oracle");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		long millis = calendar.getTimeInMillis()/1000;
		//得到文件
		Element rootElement = XmlUtil.getRootElement("property/catalogue.xml");
		List<Element> elements = rootElement.elements();
		String sql = "insert into point_info(point_code,point_description,point_time,point_error)"
				+ " VALUES(?,?,?,?)";
		int i = 1;
		for (Element element: elements) {
			List<Element> elements2 = element.elements();
			for (Element element1:elements2) {

				System.err.println("插入了："+i++);
				//插入数据
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setInt(1, Integer.parseInt(element1.attribute("No").getValue()));
				prepareStatement.setString(2, element.getName()+"-->"+element1.attributeValue("Description"));
				prepareStatement.setLong(3, millis);
				prepareStatement.setInt(4, 0);
				
				prepareStatement.execute();
				
			}
		}
		
	}
	
}
