/**
 * 
 */
package com.hsj.girl.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hsj
 *
 */
@Component
@ConfigurationProperties(prefix="girl")
public class GirlProperties {
	
	private String name;
	
	private Integer age;
	
	private String cupSize;

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
