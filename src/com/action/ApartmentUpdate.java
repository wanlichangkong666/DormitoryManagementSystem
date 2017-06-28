package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApartmentBean;
import com.dao.ApartmentDao;
import com.opensymphony.xwork2.ActionSupport;

public class ApartmentUpdate extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Ano;
	private ApartmentBean cnbean;

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public ApartmentBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(ApartmentBean cnbean) {
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
		cnbean = new ApartmentDao().GetBean(Ano);
		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}



}
