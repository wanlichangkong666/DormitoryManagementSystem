package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.ApartmentBean;
import com.db.DBHelper;

public class ApartmentDao {

	// 获取列表
	public List<ApartmentBean> GetList(String strwhere, String strorder) {
		String sql = "select * from apartment";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ApartmentBean> list = new ArrayList<ApartmentBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ApartmentBean cnbean = new ApartmentBean();
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setSsex(rs.getString("Ssex"));
				cnbean.setAspend(rs.getInt("Aspend"));
				cnbean.setFcount(rs.getInt("Fcount"));
				cnbean.setDcount(rs.getInt("Dcount"));
				cnbean.setMtel(rs.getInt("Mtel"));
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
	public ApartmentBean GetBean(int Ano) {
		String sql = "select * from apartment where Ano=" + Ano;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ApartmentBean cnbean = new ApartmentBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setSsex(rs.getString("Ssex"));
				cnbean.setAspend(rs.getInt("Aspend"));
				cnbean.setFcount(rs.getInt("Fcount"));
				cnbean.setDcount(rs.getInt("Dcount"));
				cnbean.setMtel(rs.getInt("Mtel"));
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
	public void Add(ApartmentBean cnbean) {
		String sql = "insert into apartment (";
		sql += "Ano,Ssex,Fcount,Dcount,Aspend,Mtel";
		sql += ") values('" + cnbean.getAno() + "','" + cnbean.getSsex() + "','" + cnbean.getFcount() + "','"
				+ cnbean.getDcount() + "','" + cnbean.getAspend() + "','" + cnbean.getMtel();

		sql += "')";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		// System.out.println(conn);
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
	public void Update(ApartmentBean cnbean) {
		String sql = "update apartment set ";
		sql += "Ssex='" + cnbean.getSsex() + "'," + "Fcount='" + cnbean.getFcount() + "'," + "Dcount='"
				+ cnbean.getDcount() + "'," + "Aspend='" + cnbean.getAspend() + "'," + "Mtel='" + cnbean.getMtel()
				+ "'";
		sql += " where Ano='" + cnbean.getAno() + "'";
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
		String sql = "delete from apartment where ";
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

	
}
