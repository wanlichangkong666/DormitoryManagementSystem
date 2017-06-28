package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApartmentBean;
import com.dao.ApartmentDao;
import com.opensymphony.xwork2.ActionSupport;

public class ApartmentManager extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private List<ApartmentBean> list;

	public List<ApartmentBean> getList() {
		return list;
	}

	public void setList(List<ApartmentBean> list) {
		this.list = list;
	}

	private String SearchKey;

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
			strWhere += " Ano='" + SearchKey + "'";
		}
		// ��ѯ����
		list = new ApartmentDao().GetList(strWhere, "Ano");

		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
