package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class AdminHitchList extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private List<HitchBean> list;
	private List<ApartmentBean> ApartmentList;
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
	public List<ApartmentBean> getApartmentList() {
		return ApartmentList;
	}
	public void setApartmentList(List<ApartmentBean> apartmentList) {
		ApartmentList = apartmentList;
	}
	public List<HitchBean> getList() {
		return list;
	}
	public void setList(List<HitchBean> list) {
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

		//查询条件
		String strWhere="";
		
		if (!(isInvalid(SearchKey))) {
			strWhere += " " + SearchRow + "='" + SearchKey + "'";
		}

		//查询所有
		ApartmentList=new ApartmentDao().GetList("", "");
		list=new HitchDao().GetList(strWhere,"");
		
	
		return SUCCESS;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	
}
