package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/sushe";
	private static final String dbUser = "root";
	private static final String dbPassword = "123";
	private static final String jdbcName = "com.mysql.jdbc.Driver";
	public static Connection conn = null;
	// 加载数据库驱动
	static {
		try {
			Class.forName(jdbcName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public Connection getConn() {

		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return conn;

	}

	// 测试
	public static void main(String[] args) throws Exception {
		Connection conn = new DBHelper().getConn();
		if (conn != null)
			System.out.println("数据库连接成功");
		else
			System.out.println("数据库连接失败");

	}

}
