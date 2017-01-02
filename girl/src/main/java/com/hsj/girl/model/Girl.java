/**
 * 
 */
package com.hsj.girl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author hsj
 *
 */
@Entity
public class Girl {
	
	@Id
	@GeneratedValue
	private Long girlId;
	
	private String name;
	
	private Integer age;
	
	private String cupSize;

	public Girl() {
		super();
	}

	public Long getGirlId() {
		return girlId;
	}

	public void setGirlId(Long girlId) {
		this.girlId = girlId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

}
