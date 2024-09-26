package com.may6.test.jdbc;

public class Employee
{
	int id; 
	String name;
	String address;
	double salary;
	double phno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getPhno() {
		return phno;
	}
	public void setPhno(double phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", phno="
				+ phno + "]";
	}
	
	
	
	
	
	

}
