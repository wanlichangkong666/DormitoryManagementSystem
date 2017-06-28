package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.DormitoryBean;
import com.db.DBHelper;

public class DormitoryDao {

	// 获取列表
	public List<DormitoryBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Dormitory ";
		if (!(isInvalid(strwhere))) {
			sql +=" where "+strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<DormitoryBean> list = new ArrayList<DormitoryBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				DormitoryBean cnbean = new DormitoryBean();
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setDno(rs.getInt("Dno"));
				cnbean.setYcount(rs.getInt("Ycount"));
				cnbean.setScount(rs.getInt("Scount"));
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
	public DormitoryBean GetBean(int Ano, int Dno) {
		String sql = "select * from dormitory where Ano=" + Ano + " and Dno=" + Dno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		DormitoryBean cnbean = new DormitoryBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setDno(rs.getInt("Dno"));
				cnbean.setYcount(rs.getInt("Ycount"));
				cnbean.setScount(rs.getInt("Scount"));
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
	public void Add(DormitoryBean cnbean) {
		String sql = "insert into dormitory(";
		sql += "Ano,Dno,Ycount,Scount";
		sql += ") values(";
		sql += "'" + cnbean.getAno() + "','" + cnbean.getDno() + "','" + cnbean.getYcount() + "','" + cnbean.getScount()
				+ "'";
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
	public void Update(DormitoryBean cnbean) {
		String sql = "update dormitory set ";
		sql += "Ycount='" + cnbean.getYcount() + "',";
		sql += "Scount='" + cnbean.getScount() + "'";
		sql += " where Ano=" + cnbean.getAno() + " and " + "Dno=" + cnbean.getDno();
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
		String sql = "delete from dormitory where ";
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
