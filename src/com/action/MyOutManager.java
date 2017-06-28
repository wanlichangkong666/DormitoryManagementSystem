package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class MyOutManager extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private int Dno;
	public int getDno() {
		return Dno;
	}

	public void setDno(int dno) {
		Dno = dno;
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


	private List<DormitoryBean> DormitoryList;
	public List<DormitoryBean> getDormitoryList() {
		return DormitoryList;
	}

	public void setDormitoryList(List<DormitoryBean> dormitoryList) {
		DormitoryList = dormitoryList;
	}

	
	private List<OutBean> list;
	public List<OutBean> getList() {
		return list;
	}

	public void setList(List<OutBean> list) {
		this.list = list;
	}

	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		
		//��ѯ����
		int Eno=Integer.parseInt(session.getAttribute("id").toString());
		EmployeeBean cnbean=new EmployeeDao().GetBean(Eno);
		String strWhere="Eno="+Eno;
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"='"+SearchKey+"'";
		}
		if(Dno!=0)
		{
			strWhere+=" and Dno="+Dno;
		}
		DormitoryList=new DormitoryDao().GetList("Ano="+cnbean.getEano(), "");
		list=new OutDao().GetMyList(strWhere,"");
		
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
