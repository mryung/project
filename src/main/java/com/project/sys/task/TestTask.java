package com.project.sys.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.PointInfo;
import com.project.entity.project.StartEndTime;
import com.project.entity.project.TmrWindElcpower;
import com.project.mapper.PointInfoDao;
import com.project.util.customer.DateUtile;
import com.project.util.customer.TableNameUtil;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
*/
@Component("testTask")
public class TestTask {
	
	@Autowired //现有连接
	private PointInfoDao pointInfoDao;
	
	//远程数据源
	@Resource(name="datasource1")
	private DataSource remoteDataSource;
	
	//本地数据源
	@Resource(name="datasource")
	private DataSource localDataSource;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void test(String params){
		//得到所有节点列表
		List<PointInfo> list = pointInfoDao.queryList();
		
		for (Iterator<PointInfo> iterator = list.iterator(); iterator.hasNext();) {
			PointInfo pointInfo = iterator.next();
			//节点有效
			if(pointInfo.getPointValid().equals(1)){
				long millisTime = 0;
				//判断出错次数
				if(pointInfo.getPointError() >= 3){
					millisTime = (pointInfo.getPointTime()+3600)*1000;
					pointInfo.setPointError(0);
					
					//记录日志
					System.err.println("-------------> 错误数达到上限");
					//日志记录出错错误
				}else{
					//开始判断时间节点
					millisTime = pointInfo.getPointTime()*1000;
				}
				long currentTimeMillis = System.currentTimeMillis();
				//抓取数据的时间大于现在是时间
				while(millisTime < currentTimeMillis){
					//抓取去数据
					String tableName = TableNameUtil.getTable(millisTime);
					try {
						// 1、判断远程表存在
						if(exitTable(remoteDataSource,tableName)){
							//2、判断本地数据库表是否存在
							if(!exitTable(localDataSource, tableName)){
								//3、创建本地数据库表
								logger.info("创建本地数据库。。。。。。。。。。。");
								createTable(localDataSource, tableName);
							}
							//得到远程数据库得数据
							TmrWindElcpower data = null;
							Long addHours = DateUtile.addHours(millisTime, 1);
							StartEndTime startEndTime = new StartEndTime(millisTime, addHours);
							data = getRemoteData(tableName,pointInfo.getPointCode(),startEndTime,false);

							//保存数据
							if(data != null){
								savePointData(tableName, data);
								pointInfo.setPointTime(pointInfo.getPointTime()+3600);;
								pointInfoDao.update(pointInfo);
								millisTime += 3600L*1000;
							}else{
								//为空数据
								//节点错误数加一
								pointInfo.setPointError(pointInfo.getPointError()+1); //默认错误三次
								pointInfoDao.update(pointInfo);
								break;
							}
							
							
						}else{
							System.err.println("-------------> 远程数据库不存在");
							break;
						};
					} catch (SQLException e) {
						// 数据库连接出错
						//节点错误数加一
						pointInfo.setPointError(pointInfo.getPointError()+1);
						pointInfoDao.update(pointInfo);
						e.printStackTrace();
					}
				}
			}
		}
		
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.err.println("********test*****开始执行");
		
	}
	
	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
		System.err.println("***************test2 开始执行************");
	}
	
	public boolean exitTable(DataSource dataSource, String tableName) throws SQLException{
	
		boolean flag = false;
		
		StringBuilder tableSql = new StringBuilder();
		tableSql.append("select count(*) from sysobjects where name = ? ");
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(tableSql.toString());
		statement.setString(1, tableName);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			int rows = resultSet.getInt(1);
			if(rows > 0){
				flag = true;
				break;
			}
		}
		//关闭远程连接
		connection.close();
		return flag;
	}
	
	public boolean createTable(DataSource datasource,String tableName) throws SQLException{
		boolean flag = false;
		StringBuilder sql = new StringBuilder();
		sql.append("create table " + tableName)
                    .append(" ( [Meterpointno] [int] NOT NULL ,")
                    .append("   [CLECTTIME] [int] NOT NULL ,")
                    .append("   [WHPCODE] [float] NULL")
                    .append(" ) ");
		Connection connection = datasource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.toString());
		
		statement.executeUpdate();
		connection.close();
		return flag;
	}
	
	public TmrWindElcpower getRemoteData(String tablename,int pointCode
			,StartEndTime startEndTime,boolean flag) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.Meterpointno,t.CLECTTIME,t.WHPCODE from ").append(tablename);
		sql.append(" t where t.Meterpointno = ? and t.CLECTTIME >= ? and t.CLECTTIME < ? ");
		sql.append("and A.RATETYPE = 0 AND A.WHPPROP = 1 ORDER BY t.CLECTTIME");
		if(flag){
			sql.append(" desc");
		}
		Connection connection = remoteDataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.toString());
		
		statement.setInt(1, pointCode);
		statement.setLong(2, startEndTime.getStartTime());
		statement.setLong(3, startEndTime.getEndTime());
		
		TmrWindElcpower point = null;
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			point = new TmrWindElcpower();
			point.setMeterpointno(pointCode);
			point.setClecttime(resultSet.getInt(2));
			point.setWhpcode(resultSet.getDouble(3));
		}
		connection.close();
		return point;
	}
	
	public void savePointData(String tablename,TmrWindElcpower data) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) from ").append(tablename);
		sql.append(" t where t.Meterpointno = ? and t.CLECTTIME = ?");
		
		Connection connection = localDataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.toString());
		statement.setInt(1, data.getMeterpointno());
		statement.setInt(2, data.getClecttime());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			int count = resultSet.getInt(1);
			if(count == 0){
				//添加
				sql.delete(0, sql.length() );
				sql.append("insert into ")
					.append(tablename)
					.append("(Meterpointno,CLECTTIME,WHPCODE) VALUES(?,?,?)");
				statement = connection.prepareStatement(sql.toString());
				statement.setInt(1, data.getMeterpointno());
				statement.setInt(2, data.getClecttime());
				statement.setDouble(3, data.getWhpcode());
				statement.executeUpdate();
			}
		}
		connection.close();
		
	}
}
