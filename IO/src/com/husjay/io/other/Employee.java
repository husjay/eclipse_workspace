package com.husjay.io.other;

import java.io.Serializable;

/**
 * Serializable标示可以序列化
 * @author hsj
 *
 */
public class Employee implements Serializable{
	//不想序列化，加transient,表示这个属性不需要序列化
	private transient String name;
	private double salary;
	
	public Employee() {
		
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
