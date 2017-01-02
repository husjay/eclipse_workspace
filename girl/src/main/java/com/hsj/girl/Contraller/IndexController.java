/**
 * 
 */
package com.hsj.girl.Contraller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsj.girl.Dao.GirlRepository;
import com.hsj.girl.model.Girl;

/**
 * @author hsj
 *
 */
@Controller
@SpringBootApplication
public class IndexController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("index");
		List<Girl> girls = girlRepository.findAll();
		
		model.addAttribute("girls", girls);
		return "index";
	}

}
