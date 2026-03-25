package com.eva.vtiger.pojos;

import java.util.List;

public class Employee {

	private String firstName;
	private String lastName;
	private int age;
	private boolean married;
	private  AddressPojo address;
    private List<String> hobbies;
    private List<DepartmentPojo> departmentInfo;

	

	

	public Employee(String firstName,String lastName, int age, boolean married) {
		this.married=married;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public AddressPojo getAddress() {
		return address;
	}
	public void setAddress(AddressPojo address) {
		this.address=address;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<DepartmentPojo> getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(List<DepartmentPojo> departmentInfo) {
		this.departmentInfo = departmentInfo;
	}


	// POJO  - Plain old Java Objects



}
