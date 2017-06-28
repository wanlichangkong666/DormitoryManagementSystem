package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.bean.OutBean;
import com.db.DBHelper;

public class OutDao {

	// 获取列表
	public List<OutBean> GetList(String strwhere, String strorder) {
		String sql = "select * from out1 ";
		if (!(isInvalid(strwhere))) {
			sql +="where "+strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		// System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<OutBean> list = new ArrayList<OutBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OutBean cnbean = new OutBean();
				cnbean.setOcause(rs.getString("Ocause"));
				cnbean.setOrtime(rs.getString("Ortime"));
				cnbean.setOstatus(rs.getInt("Ostatus"));
				cnbean.setOtime(rs.getString("Otime"));
				cnbean.setSno(rs.getInt("Sno"));
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
	public List<OutBean> GetMyList(String strwhere, String strorder) {
		String sql = "select * from out1,Employee,Student where out1.Sno=Student.Sno and Student.Ano=Employee.Eano  ";
		if (!(isInvalid(strwhere))) {
			sql +="and "+strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		
		// System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<OutBean> list = new ArrayList<OutBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				OutBean cnbean = new OutBean();
				cnbean.setOcause(rs.getString("Ocause"));
				cnbean.setOrtime(rs.getString("Ortime"));
				cnbean.setOstatus(rs.getInt("Ostatus"));
				cnbean.setOtime(rs.getString("Otime"));
				cnbean.setSno(rs.getInt("Sno"));
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
	public OutBean GetBean(int sno) {
		String sql = "select * from out1 where Sno="
				+ sno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		OutBean cnbean = new OutBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				
				cnbean.setOcause(rs.getString("Ocause"));
				cnbean.setOrtime(rs.getString("Ortime"));
				cnbean.setOstatus(rs.getInt("Ostatus"));
				cnbean.setOtime(rs.getString("Otime"));
				cnbean.setSno(rs.getInt("Sno"));
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
	public void Add(OutBean cnbean) {
		String sql = "insert into out1 (";
		sql += "Sno,Otime,Ortime,Ocause,Ostatus";
		sql += ") values(";
		sql += "'" + cnbean.getSno() + "','" + cnbean.getOtime() + "','" + cnbean.getOrtime()
				+ "','" + cnbean.getOcause() + "','" + cnbean.getOstatus() + "'";
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
	public void Update(OutBean cnbean) {
		String sql = "update out1 set ";
		
		sql += "Otime='" + cnbean.getOtime() + "',";
		sql += "Ortime='" + cnbean.getOrtime() + "',";
		sql += "Ocause='" + cnbean.getOcause() + "',";
		sql += "Ostatus='" + cnbean.getOstatus() + "'";

		sql += " where Sno='" + cnbean.getSno() + "'";
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
	//
	public void Check(OutBean cnbean) {
		String sql = "update out1 set Ostatus=1";
		


		sql += " where Sno='" + cnbean.getSno() + "'";
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
		String sql = "delete from out1 where ";
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
