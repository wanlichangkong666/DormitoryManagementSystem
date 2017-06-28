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

	//������Action�����ڷ�װ�û��������������
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

	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//���
		OutBean cnbean=new OutBean();
		cnbean.setOcause(Ocause);
		cnbean.setOrtime(Ortime);
		cnbean.setOstatus(0);
		cnbean.setOtime(Otime);
		cnbean.setSno(Sno);

		new OutDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('����Ǽǳɹ���');window.location='Index.jsp';</script>");
		out.flush();out.close();return null;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
