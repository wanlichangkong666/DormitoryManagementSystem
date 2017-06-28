package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAddSave extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
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

		// ��ѯ����Ƿ����
		List<EmployeeBean> list = new EmployeeDao().GetList("Eno='" + Eno + "'", "");
		if (list.size() > 0) {
			out.print("<script language='javascript'>alert('����Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		//��ѯ�绰�Ƿ����
		List<EmployeeBean> list1 = new EmployeeDao().GetList("Etel='" + Etel + "'", "");
		if (list1.size() > 0) {
			out.print("<script language='javascript'>alert('��ϵ�绰�����ظ���');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		// ���
		EmployeeBean cnbean = new EmployeeBean();
		cnbean.setEno(Eno);
		cnbean.setEano(Eano);
		cnbean.setEtime(Etime);
		cnbean.setEname(Ename);
		cnbean.setEsex(Esex);
		cnbean.setEtel(Etel);
		cnbean.setEpos(Epos);
		new EmployeeDao().Add(cnbean);

		// ��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='EmployeeManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	
}
