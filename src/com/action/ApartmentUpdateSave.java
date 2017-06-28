package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApartmentBean;
import com.bean.EmployeeBean;
import com.dao.ApartmentDao;
import com.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

public class ApartmentUpdateSave extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Ano;
	private String Ssex;
	private int Fcount;
	private int Dcount;
	private int Aspend;
	private int Mtel;

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	public int getFcount() {
		return Fcount;
	}

	public void setFcount(int fcount) {
		Fcount = fcount;
	}

	public int getDcount() {
		return Dcount;
	}

	public void setDcount(int dcount) {
		Dcount = dcount;
	}

	public int getAspend() {
		return Aspend;
	}

	public void setAspend(int aspend) {
		Aspend = aspend;
	}

	public int getMtel() {
		return Mtel;
	}

	public void setMtel(int mtel) {
		Mtel = mtel;
	}

	// �����û������execute����
	public String execute() throws Exception {

		// ������룬����ҳ�����
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// ����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		// ��֤�Ƿ�������¼
		if (session.getAttribute("id") == null) {
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		
		
		// �޸�
		ApartmentBean cnbean = new ApartmentBean();
		cnbean = new ApartmentDao().GetBean(Ano);
		
		cnbean.setSsex(Ssex);
		cnbean.setAspend(Aspend);
		cnbean.setDcount(Dcount);
		cnbean.setFcount(Fcount);
		cnbean.setMtel(Mtel);
		new ApartmentDao().Update(cnbean);
		// ��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='ApartmentManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}



}
