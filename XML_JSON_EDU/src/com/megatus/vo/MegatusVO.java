package com.megatus.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "megatus")
public class MegatusVO {
	
	private String company;
	private String address;
	private String number;
	private List<EmployeeVO> employee;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<EmployeeVO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeVO> employee) {
		this.employee = employee;
	}	
}
