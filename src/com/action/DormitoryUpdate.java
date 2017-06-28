package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApartmentBean;
import com.bean.DormitoryBean;
import com.dao.ApartmentDao;
import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionSupport;

public class DormitoryUpdate extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Ano;
	private int Dno;

	public int getDno() {
		return Dno;
	}

	public void setDno(int dno) {
		Dno = dno;
	}

	private DormitoryBean cnbean;

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public DormitoryBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(DormitoryBean cnbean) {
		this.cnbean = cnbean;
	}

	private List<ApartmentBean> list;

	public List<ApartmentBean> getList() {
		return list;
	}

	public void setList(List<ApartmentBean> list) {
		this.list = list;
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

		// ��ѯ���й�Ԣ
		list = new ApartmentDao().GetList("", "Ano");
		// ��ѯ
		cnbean = new DormitoryDao().GetBean(Ano, Dno);
		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
