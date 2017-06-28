package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.AdminBean;
import com.db.DBHelper;

public class AdminDao {

	// 验证登录
	public String CheckLogin(String username,String password) {
		String tel = null;
		String sql = "select * from Admin where AdminUsername='" + username + "' and AdminPassword='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				tel = rs.getString("AdminTel");
			}
		} catch (SQLException ex) {
		}
		return tel;
	}

	// 验证密码
	public boolean CheckPassword(String tel,String password) {
		boolean ps = false;
		String sql = "select * from Admin where AdminPassword='" + password + "' and AdminTel='"+tel+"'";
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
	public List<AdminBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Admin";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<AdminBean> list = new ArrayList<AdminBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				AdminBean cnbean = new AdminBean();
				
				cnbean.setAdminUsername(rs.getString("AdminUsername"));
				cnbean.setAdminPassword(rs.getString("AdminPassword"));
				cnbean.setAdminName(rs.getString("AdminName"));
				cnbean.setAdminSex(rs.getString("AdminSex"));
				cnbean.setAdminTel(rs.getString("AdminTel"));
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
	public AdminBean GetBean(String tel) {
		String sql = "select * from Admin where AdminTel='" + tel+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		AdminBean cnbean = new AdminBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				
				cnbean.setAdminUsername(rs.getString("AdminUsername"));
				cnbean.setAdminPassword(rs.getString("AdminPassword"));
				cnbean.setAdminName(rs.getString("AdminName"));
				cnbean.setAdminSex(rs.getString("AdminSex"));
				cnbean.setAdminTel(rs.getString("AdminTel"));

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
	public void Add(AdminBean cnbean) {
		String sql = "insert into Admin (";
		sql += "AdminUsername,AdminPassword,AdminName,AdminSex,AdminTel";
		sql += ") values(";
		sql += "'" + cnbean.getAdminUsername() + "','" + cnbean.getAdminPassword() + "','" + cnbean.getAdminName()
				+ "','" + cnbean.getAdminSex() + "','" + cnbean.getAdminTel() + "'";
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
	public void Update(AdminBean cnbean) {
		String sql = "update Admin set ";
		
		sql += "AdminPassword='" + cnbean.getAdminPassword() + "',";
		sql += "AdminName='" + cnbean.getAdminName() + "',";
		sql += "AdminSex='" + cnbean.getAdminSex() + "',";
		sql += "AdminTel='" + cnbean.getAdminTel() + "'";

		sql += " where AdminUsername='" + cnbean.getAdminUsername() + "'";
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
		String sql = "delete from Admin where ";
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
