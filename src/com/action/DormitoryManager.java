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

public class DormitoryManager extends ActionSupport {

	// ������Action�����ڷ�װ�û��������������
	private List<DormitoryBean> list;

	public List<DormitoryBean> getList() {
		return list;
	}

	public void setList(List<DormitoryBean> list) {
		this.list = list;
	}

	private String SearchRow;
	private String SearchKey;

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

	private List<ApartmentBean> ApartmentList;

	public List<ApartmentBean> getApartmentList() {
		return ApartmentList;
	}

	public void setApartmentlist(List<ApartmentBean> ApartmentList) {
		this.ApartmentList = ApartmentList;
	}

	private int Ano;

	

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
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
		/*if (Ano!=0){
			strWhere += " Ano='" + Ano + "'";
		}*/
		if (!(isInvalid(SearchKey))) {
			strWhere += ""+SearchRow+"='" + SearchKey + "'";
		}
		
		

		// ��ѯ���й�Ԣ
		ApartmentList = new ApartmentDao().GetList("", "Ano");

		// ��ѯ����
		list = new DormitoryDao().GetList(strWhere, "Ano");

		return SUCCESS;

	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
