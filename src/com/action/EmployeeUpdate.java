package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeUpdate extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Eno;
	private EmployeeBean cnbean;

	public int getEno() {
		return Eno;
	}

	public void setEno(int eno) {
		Eno = eno;
	}

	public EmployeeBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(EmployeeBean cnbean) {
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
		cnbean = new EmployeeDao().GetBean(Eno);
		
		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
