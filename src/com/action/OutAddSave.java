package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class OutAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private int Sno;
	private String Otime;
	private String Ortime;
	private String Ocause;
	private int Ostatus;
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getOtime() {
		return Otime;
	}
	public void setOtime(String otime) {
		Otime = otime;
	}
	public String getOrtime() {
		return Ortime;
	}
	public void setOrtime(String ortime) {
		Ortime = ortime;
	}
	public String getOcause() {
		return Ocause;
	}
	public void setOcause(String ocause) {
		Ocause = ocause;
	}
	public int getOstatus() {
		return Ostatus;
	}
	public void setOstatus(int ostatus) {
		Ostatus = ostatus;
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
		
		//添加
		OutBean cnbean=new OutBean();
		cnbean.setOcause(Ocause);
		cnbean.setOrtime(Ortime);
		cnbean.setOstatus(0);
		cnbean.setOtime(Otime);
		cnbean.setSno(Sno);

		new OutDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('外出登记成功！');window.location='Index.jsp';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
