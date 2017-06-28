package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.DormitoryBean;
import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionSupport;

public class DormitoryUpdateSave extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Ano;
	private int Dno;
	private int Ycount;
	private int Scount;

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

	public int getYcount() {
		return Ycount;
	}

	public void setYcount(int ycount) {
		Ycount = ycount;
	}

	public int getScount() {
		return Scount;
	}

	public void setScount(int scount) {
		Scount = scount;
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
		if(Scount>Ycount)
		{
			out.print("<script language='javascript'>alert('ʵס�������ܴ���Ӧס������');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}

		DormitoryBean cnbean = new DormitoryBean();
		cnbean = new DormitoryDao().GetBean(Ano, Dno);
		cnbean.setScount(Scount);
		cnbean.setYcount(Ycount);
		new DormitoryDao().Update(cnbean);

		// ��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='DormitoryManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
