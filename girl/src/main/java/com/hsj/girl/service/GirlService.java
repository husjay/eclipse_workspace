/**
 * 
 */
package com.hsj.girl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hsj.girl.Dao.GirlRepository;
import com.hsj.girl.model.Girl;

/**
 * @author hsj
 *
 */
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwoGirls() {
		Girl girl1 = new Girl();
		girl1.setName("www");
		girl1.setAge(18);
		girl1.setCupSize("D");
		girlRepository.save(girl1);
		
		Girl girl2 = new Girl();
		girl2.setName("www");
		girl2.setAge(18);
		girl2.setCupSize("D");
		girlRepository.save(girl2);
	}

}
