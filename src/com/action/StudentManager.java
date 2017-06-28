package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;

public class StudentManager extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private List<StudentBean> list;

	public List<StudentBean> getList() {
		return list;
	}

	public void setList(List<StudentBean> list) {
		this.list = list;
	}

	private String SearchRow;
	private String SearchKey;
	private String State;

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getSearchRow() {
		return SearchRow;
	}

	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}

	public String getSearchKey() {
		return SearchKey;
	}

	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
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
		// ��ѯ����
		String strWhere = "";
		if (!(isInvalid(SearchKey))) {
			strWhere += " " + SearchRow + "='" + SearchKey + "'";
		}
	   
		list = new StudentDao().GetList(strWhere, "Sno");

		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
