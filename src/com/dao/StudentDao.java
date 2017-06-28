package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.db.DBHelper;

public class StudentDao {

	// ��ȡ�����б�
	public List<StudentBean> GetAllList(String strwhere, String strorder) {
		String sql = "select * from Student";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		// System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setDno(rs.getInt("Dno"));
				cnbean.setSname(rs.getString("Sname"));
				cnbean.setSsex(rs.getString("Ssex"));
				cnbean.setStel(rs.getString("Stel"));
				cnbean.setTtel(rs.getString("Ttel"));
				cnbean.setBno(rs.getInt("Bno"));
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

	// ��ȡ�б�
	public List<StudentBean> GetList(String strwhere, String strorder) {
		String sql = "select * from student ";
		if (!(isInvalid(strwhere))) {
			sql +="where " +strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		// System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentBean> list = new ArrayList<StudentBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				StudentBean cnbean = new StudentBean();
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setDno(rs.getInt("Dno"));
				cnbean.setBno(rs.getInt("Bno"));
				cnbean.setSname(rs.getString("Sname"));
				cnbean.setSsex(rs.getString("Ssex"));
				cnbean.setStel(rs.getString("Stel"));
				cnbean.setTtel(rs.getString("Ttel"));
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

	// ��ȡָ��ID��ʵ��Bean
	public StudentBean GetBean(int Sno) {
		String sql = "select * from Student where Sno=" + Sno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentBean cnbean = new StudentBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setSno(rs.getInt("Sno"));
				cnbean.setAno(rs.getInt("Ano"));
				cnbean.setDno(rs.getInt("Dno"));
				cnbean.setBno(rs.getInt("Bno"));
				cnbean.setSname(rs.getString("Sname"));
				cnbean.setSsex(rs.getString("Ssex"));
				cnbean.setStel(rs.getString("Stel"));
				cnbean.setTtel(rs.getString("Ttel"));
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

	// ���
	public void Add(StudentBean cnbean) {
		String sql = "insert into Student (";
		sql += "Sno,Sname,Ssex,Stel,Ttel,Ano,Dno,Bno";
		sql += ") values(";
		sql += "'" + cnbean.getSno() + "','" + cnbean.getSname() + "','" + cnbean.getSsex() + "','" + cnbean.getStel()
				+ "','" + cnbean.getTtel() + "','" + cnbean.getAno() + "','" + cnbean.getDno()+ "','" + cnbean.getBno() + "'";
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

	// �޸�
	public void Update(StudentBean cnbean) {
		String sql = "update Student set ";
		// sql += "Dno='" + cnbean.getDno() + "',";
		sql += "Sname='" + cnbean.getSname() + "',";
		sql += "Ssex='" + cnbean.getSsex() + "',";
		sql += "Stel='" + cnbean.getStel() + "',";
		sql += "Ttel='" + cnbean.getTtel() + "',";
		sql += "Ano='" + cnbean.getAno() + "',";
		sql += "Bno='" + cnbean.getBno() + "',";
		sql += "Dno='" + cnbean.getDno() + "' ";
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

	// ɾ��
	public void Delete(String strwhere) {
		String sql = "delete from Student where ";
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

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// ����
	public static void main(String[] args) {
		System.out.println("");
	}

}
