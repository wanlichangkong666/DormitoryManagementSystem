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

	//下面是Action内用于封装用户请求参数的属性
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

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		
		//查询所有
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
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
