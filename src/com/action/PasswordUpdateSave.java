package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.AdminBean;
import com.bean.DkeeperBean;
import com.dao.AdminDao;
import com.dao.DkeeperDao;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordUpdateSave extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private String Password;
	private String Password2;
	private String Msg;

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
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
		String type = session.getAttribute("type").toString();
		if (type.equals("1"))// У԰����Ա����
		{
			// ��ѯԭ�����Ƿ���ȷ
			if (new AdminDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				// �޸�����
				AdminBean cnbean = new AdminBean();
				cnbean = new AdminDao().GetBean(session.getAttribute("id").toString());
				cnbean.setAdminPassword(Password2);
				new AdminDao().Update(cnbean);
				out.print(
						"<script language='javascript'>alert('�޸ĳɹ���');window.location='PasswordUpdate.jsp';</script>");
				out.flush();
				out.close();
				return null;
			} else {
				Msg = "ԭ�������";
				return INPUT;
			}
		} else if (type.equals("2"))// �޹��û�����
		{
			// ��ѯԭ�����Ƿ���ȷ
			if (new DkeeperDao().CheckPassword(Integer.parseInt(session.getAttribute("id").toString()), Password)) {
				// �޸�����
				DkeeperBean cnbean = new DkeeperBean();
				cnbean = new DkeeperDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setPassword(Password2);
				new DkeeperDao().Update(cnbean);
				out.print(
						"<script language='javascript'>alert('�޸ĳɹ���');window.location='PasswordUpdate.jsp';</script>");
				out.flush();
				out.close();
				return null;
			} else {
				Msg = "�û��������������";
				return INPUT;
			}
		}
		/*
		 * else if(type.equals("3"))//ѧ������ { //��ѯԭ�����Ƿ���ȷ if (new
		 * StudentDao().CheckPassword(session.getAttribute("id").toString(),
		 * Password)) { //�޸����� StudentBean cnbean=new StudentBean(); cnbean=new
		 * StudentDao().GetBean(Integer.parseInt(session.getAttribute("id").
		 * toString())); cnbean.setStudent_Password(Password2); new
		 * StudentDao().Update(cnbean); out.
		 * print("<script language='javascript'>alert('�޸ĳɹ���');window.location='PasswordUpdate.jsp';</script>"
		 * ); out.flush();out.close();return null; } else { Msg = "�û��������������";
		 * return INPUT; } }
		 */
		else {
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}