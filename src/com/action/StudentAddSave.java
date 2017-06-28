package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EmployeeBean;
import com.bean.StudentBean;
import com.dao.EmployeeDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAddSave extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private int Sno;
	private String Sname;
	private String Ssex;
	private String Stel;
	private String Ttel;
	private int Ano;
	private int Dno;
	private int Bno;

	public int getBno() {
		return Bno;
	}

	public void setBno(int bno) {
		Bno = bno;
	}

	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String sex) {
		this.Ssex = sex;
	}

	

	public String getStel() {
		return Stel;
	}

	public void setStel(String stel) {
		Stel = stel;
	}

	public String getTtel() {
		return Ttel;
	}

	public void setTtel(String ttel) {
		Ttel = ttel;
	}

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

		// ��ѯѧ���Ƿ����
		List<StudentBean> list = new StudentDao().GetList("Sno='" + Sno + "'", "");
		if (list.size() > 0) {
			out.print("<script language='javascript'>alert('ѧ���Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		//��ѯ�绰�Ƿ����
				List<StudentBean> list1 = new StudentDao().GetList("Stel='" + Stel + "'", "");
				if (list1.size() > 0) {
					out.print("<script language='javascript'>alert('��ϵ�绰�����ظ���');history.back(-1);</script>");
					out.flush();
					out.close();
					return null;
				}
		// ���
		StudentBean cnbean = new StudentBean();
		cnbean.setSno(Sno);
		cnbean.setAno(Ano);
		cnbean.setDno(Dno);
		cnbean.setSname(Sname);
		cnbean.setSsex(Ssex);
		cnbean.setStel(Stel);
		cnbean.setTtel(Ttel);
		cnbean.setBno(Bno);;
		new StudentDao().Add(cnbean);

		// ��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='StudentManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
