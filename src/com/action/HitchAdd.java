package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class HitchAdd extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	
	private int Ano;
	private int Dno;
	private String Htype;
	private String Htime;
	
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



	public String getHtype() {
		return Htype;
	}
	public void setHtype(String htype) {
		Htype = htype;
	}
	public String getHtime() {
		return Htime;
	}
	public void setHtime(String htime) {
		Htime = htime;
	}



	private DormitoryBean cnbean;
	
	public DormitoryBean getCnbean() {
		return cnbean;
	}
	public void setCnbean(DormitoryBean cnbean) {
		this.cnbean = cnbean;
	}
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}

		//查询
		cnbean=new DormitoryDao().GetBean(Ano,Dno);
	
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
}
