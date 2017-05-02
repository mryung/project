package com.myproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * @projectNam project
 * @classname  ImportData
 * @<p>description: 导入数据 </p>
 * @email     2327542415@qq.com
 * @date       2017年4月16日:下午9:01:04
 * @version    0.0.1
 *
 */
public class ImportData {
	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hisdb"
					, "sa", "oracle");
			Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/permission?useUnicode=true&characterEncoding=utf8&useSSL=false"
					, "root", "oracle");
			
			Calendar instance = Calendar.getInstance();
			instance.set(2014, 3, 1);
			long start = instance.getTimeInMillis();
			Calendar instance2 = Calendar.getInstance();
			instance2.set(2017, 1, 24);
			long end = instance2.getTimeInMillis();
			
			
			while(start < end){
				//得到数据
				 String table = getTable(start);
				 StringBuilder sql1 = new StringBuilder();
				 sql1.append("select * from ").append(table);
				 String sql = "insert into "+table+"(Meterpointno, CLECTTIME, WHPCODE) values(?,?,?)";
				 StringBuilder str = new StringBuilder();
				 str.append("insert into "+table+"(Meterpointno, CLECTTIME, WHPCODE) values");
				 Statement createStatement = connection.createStatement();
				 ResultSet executeQuery = createStatement.executeQuery(sql1.toString());
			
				
//				 executeQuery.next();
				 while (executeQuery.next()) {
					 System.out.println("insert into "+table);
					 str.append("(").append(executeQuery.getInt(1)).append(",")
					 .append(executeQuery.getInt(2)).append(",").append(executeQuery.getInt(3)).append("),");
										
				}
				 System.out.println(str.toString());
				 PreparedStatement prepareStatement = connection2.prepareStatement(str.substring(0, str.length()-1));
				 prepareStatement.executeUpdate();
				instance.add(Calendar.MONTH, 1);
				start = instance.getTimeInMillis();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	
	public static String getTable(Long millis){
		Date date = new Date(millis);
		return "TMR_WIND_ELCPOWER"+format.format(date);
	}
//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	Class.forName("com.mysql.jdbc.Driver");
//	
////	Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=hisdb"
////			, "sa", "oracle");
//	Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/permission?useUnicode=true&characterEncoding=utf8&useSSL=false"
//			, "root", "oracle");
//	
//	Calendar instance = Calendar.getInstance();
//	instance.set(2012, 2, 1);
//	long start = instance.getTimeInMillis();
//	Calendar instance2 = Calendar.getInstance();
//	instance2.set(2017, 1, 24);
//	long end = instance2.getTimeInMillis();
//	
//	while(start < end){
//		StringBuilder sql = new StringBuilder();
//		sql.append("create table " + getTable(start))
//                    .append(" ( Meterpointno int NOT NULL ,")
//                    .append("   CLECTTIME int NOT NULL ,")
//                    .append("   WHPCODE float NULL")
//                    .append(" ) ");
//		Statement statement = connection2.createStatement();
//		statement.executeUpdate(sql.toString());
//		instance.add(Calendar.MONTH, 1);
//		start = instance.getTimeInMillis();
//	}
}
