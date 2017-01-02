/**
 * 
 */
package com.hsj.girl.Contraller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.girl.conf.GirlProperties;

/**
 * @author hsj
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloContraller {
	
	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value={"/say/{id}", "hi"}, method=RequestMethod.GET)
	public String say(@RequestParam(value="id", required=false, defaultValue="0") Integer id) {
		System.out.println(girlProperties.getName());
		return "hello spring boot " + id;
	}

}
