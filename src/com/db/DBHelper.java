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
	// �������ݿ�����
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

	// ����
	public static void main(String[] args) throws Exception {
		Connection conn = new DBHelper().getConn();
		if (conn != null)
			System.out.println("���ݿ����ӳɹ�");
		else
			System.out.println("���ݿ�����ʧ��");

	}

}
