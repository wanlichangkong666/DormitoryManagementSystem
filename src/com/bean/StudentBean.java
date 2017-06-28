package com.bean;

public class StudentBean {
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

}