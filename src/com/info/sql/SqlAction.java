package com.info.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlAction {
	
	private SqlAction() {
	}
	
	// 加载JDBC驱动
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// database infomation
	private static String dbUrl = "jdbc:sqlserver://localhost:1433; DatabaseName=info";
	// 默认用户名
	private static String userName = "sa"; 
	// 密码
	private static String userPwd = "123456"; 
	
	/**************************************************
	 * 数据库连接
	 * @return connection
	 *************************************************/
	public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName(driverName);
				con=DriverManager.getConnection(dbUrl, userName, userPwd);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
	
	/**********************************************************
	 * 查询数据表，返回符合条件的结果集
	 * @param sql
	 * @return list
	 *********************************************************/
	public static List<Map<String, Object>> query(String sql){
		List<Map<String, Object>> list = new ArrayList<>();
		Connection con = getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			ResultSetMetaData rsmd =  rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				for (int i = 0; i < colCount; i++) {
					map.put(rsmd.getColumnName(i+1), rs.getObject(rsmd.getColumnName(i+1)));
				}
				list.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm!=null) {
					stm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return list;
		
	}
	
	/******************************************************
	 * 获取查询后的单条记录
	 * @param sql语句
	 * @return 单条记录的全部信息
	 ******************************************************/
	public static Map<String, Object> sqlQueryUnique(String sql) {
		List<Map<String, Object>> list = query(sql);
		if (list.size()!=1) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
	/*******************************************************
	 * 向数据库insert update delete
	 * @param sql 
	 * @return 受影响行数
	 *******************************************************/
	public static int operate(String sql)
	{
		Connection conn = getConnection();
		int num=0;
		Statement state=null;
		try {
			state =conn.createStatement();
			num=state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{	
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}
	
	
	/*public static void main(String[] args) {
		String sql = "select u_name,u_password from b_user";
		System.out.println(query(sql));
	}*/
	
}
