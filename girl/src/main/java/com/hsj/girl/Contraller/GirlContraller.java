/**
 * 
 */
package com.hsj.girl.Contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.girl.Dao.GirlRepository;
import com.hsj.girl.model.Girl;

/**
 * @author hsj
 *
 */
@RestController
public class GirlContraller {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@RequestMapping(value="/girls", method=RequestMethod.GET)
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}
	
	@RequestMapping(value="/girls", method=RequestMethod.POST)
	public Girl girlAdd(
			@RequestParam("name") String name, 
			@RequestParam("age") Integer age,
			@RequestParam("cupSize") String cupSize) {
		Girl girl = new Girl();
		girl.setName(name);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return girlRepository.save(girl);
	}

}
