package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.DkeeperBean;
import com.db.DBHelper;

public class DkeeperDao {

	// 验证登录
	public String CheckLogin(String Username,String Password) {
		String Eno =null;
		String sql = "select * from Dkeeper where Username='" + Username+ "' and Password='" + Password + "'";
				
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Eno = rs.getString("Eno");
			}
		} catch (SQLException ex) {
		}
		return Eno;
	}

	// 验证密码
	public boolean CheckPassword(int Eno,String Password) {
		boolean ps = false;
		String sql = "select * from Dkeeper where Eno='" + Eno + "' and Password='" + Password + "'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps = true;
			}
		} catch (SQLException ex) {
		}
		return ps;
	}

	// 获取列表
	public List<DkeeperBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Dkeeper";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DkeeperBean> list = new ArrayList<DkeeperBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				DkeeperBean cnbean = new DkeeperBean();
				cnbean.setEno(rs.getInt("Eno"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setUsername(rs.getString("Username"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 获取指定ID的实体Bean
	public DkeeperBean GetBean(int Eno) {
		String sql = "select * from Dkeeper where Eno='" + Eno+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DkeeperBean cnbean = new DkeeperBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setEno(rs.getInt("Eno"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setUsername(rs.getString("Username"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	public DkeeperBean GetBean(String username) {
		String sql = "select * from Dkeeper where Username='" + username+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DkeeperBean cnbean = new DkeeperBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setEno(rs.getInt("Eno"));
				cnbean.setPassword(rs.getString("Password"));
				cnbean.setUsername(rs.getString("Username"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	// 添加
	public void Add(DkeeperBean cnbean) {
		String sql = "insert into Dkeeper (";
		sql += "Username,Password,Eno";
		sql += ") values(";
		sql += "'" + cnbean.getUsername() + "','" + cnbean.getPassword() + "','"
				+ cnbean.getEno() + "'";
		sql += ")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 修改
	public void Update(DkeeperBean cnbean) {
		String sql = "update Dkeeper set ";
	
		sql += "Password='" + cnbean.getPassword() + "',";
		
		sql += "Eno='" + cnbean.getEno() + "'";

		sql += " where Username='" + cnbean.getUsername() + "'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 删除
	public void Delete(String strwhere) {
		String sql = "delete from Dkeeper where ";
		sql += strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("");
	}

}
