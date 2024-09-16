package com;

public class MemDTO {
	String name;
	int age;
	String ID;
	String pwd;
	String phone;
	String acount;
	
	String chPhone;
	String chPwd;
	String chAcount;

	public String getChPhone() {
		return chPhone;
	}

	public void setChPhone(String chPhone) {
		this.chPhone = chPhone;
	}

	public String getChPwd() {
		return chPwd;
	}

	public void setChPwd(String chPwd) {
		this.chPwd = chPwd;
	}

	public String getChAcount() {
		return chAcount;
	}

	public void setChAcount(String chAcount) {
		this.chAcount = chAcount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public String toString() {
		return "name : " + name + " age : " + age + " ID : " + ID;
	}

}
