package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class HitchAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private int Ano;
	private int Dno;
	private String Htype;
	private String Htime;
	private String Rperson;
	private String Rtime;
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
	public String getRperson() {
		return Rperson;
	}
	public void setRperson(String rperson) {
		Rperson = rperson;
	}
	public String getRtime() {
		return Rtime;
	}
	public void setRtime(String rtime) {
		Rtime = rtime;
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
		HitchBean cnbean=new HitchBean();
		cnbean.setAno(Ano);;
		cnbean.setDno(Dno);;
		cnbean.setHtime(Htime);;
		cnbean.setHtype(Htype);;
		cnbean.setRperson("无");
		cnbean.setRtime("无");

		new HitchDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('故障提交成功！');window.location='Index.jsp';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
