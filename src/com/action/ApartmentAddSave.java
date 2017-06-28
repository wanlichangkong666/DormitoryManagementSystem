package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.ApartmentBean;
import com.bean.EmployeeBean;
import com.dao.ApartmentDao;
import com.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;

public class ApartmentAddSave extends ActionSupport {

	// 下面是Action内用于封装用户请求参数的属性
	private int Ano;
	private String Ssex;
	private int Fcount;
	private int Dcount;
	private int Aspend;
	private int Mtel;

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	public int getFcount() {
		return Fcount;
	}

	public void setFcount(int fcount) {
		Fcount = fcount;
	}

	public int getDcount() {
		return Dcount;
	}

	public void setDcount(int dcount) {
		Dcount = dcount;
	}

	public int getAspend() {
		return Aspend;
	}

	public void setAspend(int aspend) {
		Aspend = aspend;
	}

	public int getMtel() {
		return Mtel;
	}

	public void setMtel(int mtel) {
		Mtel = mtel;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception {

		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 验证是否正常登录
		if (session.getAttribute("id") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}

		// 查询楼号是否存在
		List<ApartmentBean> list = new ApartmentDao().GetList("Ano='" + Ano + "'", "");
		if (list.size() > 0) {
			out.print("<script language='javascript'>alert('楼号已经存在！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		//查询电话是否存在
				List<ApartmentBean> list1 = new ApartmentDao().GetList("Mtel='" + Mtel + "'", "");
				if (list1.size() > 0) {
					out.print("<script language='javascript'>alert('座机出现重复！');history.back(-1);</script>");
					out.flush();
					out.close();
					return null;
				}
		// 添加
		ApartmentBean cnbean = new ApartmentBean();
		cnbean.setAno(Ano);
		cnbean.setAspend(Aspend);
		cnbean.setDcount(Dcount);
		cnbean.setFcount(Fcount);
		cnbean.setMtel(Mtel);
		cnbean.setSsex(Ssex);
		new ApartmentDao().Add(cnbean);

		// 跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='ApartmentManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}


}
