package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeUpdateSave extends ActionSupport {

	// 下面是Action内用于封装用户请求参数的属性
	private int Eno;
	private String Ename;
	private String Esex;
	private String Etel;
	private String Epos;
	private int Eano;
	private String Etime;

	public int getEno() {
		return Eno;
	}

	public void setEno(int eno) {
		Eno = eno;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getEsex() {
		return Esex;
	}

	public void setEsex(String esex) {
		Esex = esex;
	}

	

	public String getEtel() {
		return Etel;
	}

	public void setEtel(String etel) {
		Etel = etel;
	}

	public String getEpos() {
		return Epos;
	}

	public void setEpos(String epos) {
		Epos = epos;
	}

	public int getEano() {
		return Eano;
	}

	public void setEano(int eano) {
		Eano = eano;
	}

	public String getEtime() {
		return Etime;
	}

	public void setEtime(String etime) {
		Etime = etime;
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

		EmployeeBean cnbean = new EmployeeBean();
		cnbean = new EmployeeDao().GetBean(Eno);
		
		cnbean.setEano(Eano);
		cnbean.setEpos(Epos);
		cnbean.setEname(Ename);
		cnbean.setEsex(Esex);
		cnbean.setEtel(Etel);
		cnbean.setEtime(Etime);
		new EmployeeDao().Update(cnbean);
		// 跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='EmployeeManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
