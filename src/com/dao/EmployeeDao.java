package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.EmployeeBean;
import com.db.DBHelper;

public class EmployeeDao {

	private int Eno;
	

	
	public int getEno() {
		return Eno;
	}

	public void setEno(int eno) {
		Eno = eno;
	}

	// ��ȡ�б�
	public List<EmployeeBean> GetList(String strwhere, String strorder) {
		String sql = "select * from Employee where ";
		if (!(isInvalid(strwhere))) {
			sql += strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		// System.out.println(sql);
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				EmployeeBean cnbean = new EmployeeBean();
				cnbean.setEano(rs.getInt("Eano"));
				cnbean.setEname(rs.getString("Ename"));
				cnbean.setEno(rs.getInt("Eno"));
				cnbean.setEpos(rs.getString("Epos"));
				cnbean.setEsex(rs.getString("Esex"));
				cnbean.setEtel(rs.getString("Etel"));
				cnbean.setEtime(rs.getString("Etime"));
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
	public EmployeeBean GetBean(int Eno) {
		String sql = "select * from employee where Eno=" + Eno;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EmployeeBean cnbean = new EmployeeBean();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {		
				cnbean.setEno(rs.getInt("Eno"));
				cnbean.setEano(rs.getInt("Eano"));
				cnbean.setEname(rs.getString("Ename"));				
				cnbean.setEpos(rs.getString("Epos"));
				cnbean.setEsex(rs.getString("Esex"));
				cnbean.setEtel(rs.getString("Etel"));
				cnbean.setEtime(rs.getString("Etime"));
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
	public void Add(EmployeeBean cnbean) {
		String sql = "insert into Employee (";
		sql += "Eno,Ename,Esex,Epos,Etel,Eano,Etime";
		sql += ") values(";
		sql += "'" + cnbean.getEno() + "','" + cnbean.getEname() + "','" + cnbean.getEsex() + "','" + cnbean.getEpos()
				+ "','" + cnbean.getEtel() + "','" + cnbean.getEano() + "','" + cnbean.getEtime() + "'";
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
	public void Update(EmployeeBean cnbean) {
		String sql = "update Employee set ";
		// sql += "Dno='" + cnbean.getDno() + "',";
		sql += "Ename='" + cnbean.getEname() + "',";
		sql += "Esex='" + cnbean.getEsex() + "',";
		sql += "Epos='" + cnbean.getEpos() + "',";
		sql += "Etel='" + cnbean.getEtel() + "',";
		sql += "Eano='" + cnbean.getEano() + "',";
		sql += "Etime='" + cnbean.getEtime() + "' ";
		sql += " where Eno='" + cnbean.getEno() + "'";
		
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
		String sql = "delete from Employee where ";
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
