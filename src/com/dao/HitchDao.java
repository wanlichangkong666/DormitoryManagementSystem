package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.HitchBean;
import com.db.DBHelper;

public class HitchDao {
	// 获取列表
		public List<HitchBean> GetList(String strwhere, String strorder) {
			String sql = "select * from hitch ";
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
			List<HitchBean> list = new ArrayList<HitchBean>();
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					HitchBean cnbean = new HitchBean();
					cnbean.setAno(rs.getInt("Ano"));
					cnbean.setDno(rs.getInt("Dno"));
					cnbean.setHtype(rs.getString("Htype"));
					cnbean.setHtime(rs.getString("Htime"));
					cnbean.setRperson(rs.getString("Rperson"));
					cnbean.setRtime(rs.getString("Rtime"));
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
		public List<HitchBean> GetMyList(String strwhere, String strorder) {
			String sql = "select * from hitch ";
			if (!(isInvalid(strwhere))) {
				sql +="where "+strwhere;
			}
			if (!(isInvalid(strorder))) {
				sql += " order by " + strorder;
			}
			
			
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			List<HitchBean> list = new ArrayList<HitchBean>();
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					HitchBean cnbean = new HitchBean();
					cnbean.setAno(rs.getInt("Ano"));
					cnbean.setDno(rs.getInt("Dno"));
					cnbean.setHtype(rs.getString("Htype"));
					cnbean.setHtime(rs.getString("Htime"));
					cnbean.setRperson(rs.getString("Rperson"));
					cnbean.setRtime(rs.getString("Rtime"));
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
		public HitchBean GetBean(int Ano,int Dno,String Htype,String Htime) {
			String sql = "select * from hitch where Ano="+Ano+" and Dno="+Dno+" and Htype='"+Htype+"' and Htime='"+Htime+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			HitchBean cnbean = new HitchBean();
			try {
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					
					cnbean.setAno(rs.getInt("Ano"));
					cnbean.setDno(rs.getInt("Dno"));
					cnbean.setHtype(rs.getString("Htype"));
					cnbean.setHtime(rs.getString("Htime"));
					cnbean.setRperson(rs.getString("Rperson"));
					cnbean.setRtime(rs.getString("Rtime"));
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
		public void Add(HitchBean cnbean) {
			String sql = "insert into hitch (";
			sql += "Ano,Dno,Htype,Htime,Rperson,Rtime";
			sql += ") values(";
			sql += "'" + cnbean.getAno() + "','" + cnbean.getDno() + "','" + cnbean.getHtype()
					+ "','" + cnbean.getHtime() + "','" + cnbean.getRperson()  + "','"+ cnbean.getRtime()+ "'";
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
		public void Update(HitchBean cnbean) {
			String sql = "update hitch set ";
					
			sql += "Rperson='" + cnbean.getRperson() + "',";
			sql += "Rtime='" + cnbean.getRtime() + "'";
			sql+="where Ano="+cnbean.getAno()+" and Dno="+cnbean.getDno()+" and Htype='"+cnbean.getHtype()+"' and Htime='"+cnbean.getHtime()+"'"; 
			
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
		public void Check(HitchBean cnbean) {
			String sql = "update hitch set Ostatus=1";
			sql += " where Ano='" + cnbean.getAno() + "' and Dno='"+cnbean.getDno()+"' and Htype='"+cnbean.getHtype()+"'";
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
			String sql = "delete from hitch where ";
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
