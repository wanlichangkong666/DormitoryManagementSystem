package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmployeeBean;
import com.bean.StudentBean;
import com.dao.EmployeeDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;

public class StudentUpdateSave extends ActionSupport {

	// 下面是Action内用于封装用户请求参数的属性
	private int Sno;
	private String Sname;
	private String Ssex;
	private String Stel;
	private String Ttel;
	private int Ano;
	private int Dno;
	private int Bno;
	
	public int getBno() {
		return Bno;
	}

	public void setBno(int bno) {
		Bno = bno;
	}

	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String sex) {
		this.Ssex = sex;
	}

	

	public String getStel() {
		return Stel;
	}

	public void setStel(String stel) {
		Stel = stel;
	}

	public String getTtel() {
		return Ttel;
	}

	public void setTtel(String ttel) {
		Ttel = ttel;
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public int getDno() {
		return Dno;
	}

	public void setDno(int dno) {
		Dno = dno;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception {

		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 验证是否正常登录
		if (session.getAttribute("id") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		
		
		// 修改

		StudentBean cnbean = new StudentBean();
		cnbean = new StudentDao().GetBean(Sno);
		cnbean.setAno(Ano);
		cnbean.setDno(Dno);
		cnbean.setBno(Bno);
		cnbean.setSname(Sname);
		cnbean.setSsex(Ssex);
		cnbean.setStel(Stel);
		cnbean.setTtel(Ttel);
		new StudentDao().Update(cnbean);
		// 跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='StudentManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
