package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.DormitoryBean;
import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionSupport;

public class DormitoryAddSave extends ActionSupport {

	// 下面是Action内用于封装用户请求参数的属性
	private int Ano;
	private int Dno;
	private int Ycount;
	private int Scount;

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

	public int getYcount() {
		return Ycount;
	}

	public void setYcount(int ycount) {
		Ycount = ycount;
	}

	public int getScount() {
		return Scount;
	}

	public void setScount(int scount) {
		Scount = scount;
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

		// 查询是否存在
		List<DormitoryBean> list = new DormitoryDao().GetList("Dno='" + Dno + "'", "");
		if (list.size() > 0) {
			out.print("<script language='javascript'>alert('该公寓中已经存在该宿舍号！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}
		if(Scount>Ycount)
		{
			out.print("<script language='javascript'>alert('实住人数不能大于应住人数！');history.back(-1);</script>");
			out.flush();
			out.close();
			return null;
		}

		// 添加
		DormitoryBean cnbean = new DormitoryBean();
		cnbean.setAno(Ano);
		cnbean.setDno(Dno);
		cnbean.setScount(Scount);
		cnbean.setYcount(Ycount);
		new DormitoryDao().Add(cnbean);

		// 跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='DormitoryManager.action';</script>");
		out.flush();
		out.close();
		return null;

	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	

}
