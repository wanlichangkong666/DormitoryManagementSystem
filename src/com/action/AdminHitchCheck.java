package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.HitchBean;
import com.dao.ApartmentDao;
import com.dao.HitchDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminHitchCheck extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Ano;
	private int Dno;
	private String Htype;
	private String Htime;
	private HitchBean cnbean;

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public HitchBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(HitchBean cnbean) {
		this.cnbean = cnbean;
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

		// ��ѯ
		cnbean = new HitchDao().GetBean(Ano,Dno,Htype,Htime);
		return SUCCESS;

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

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
