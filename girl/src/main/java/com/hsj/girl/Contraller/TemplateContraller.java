/**
 * 
 */
package com.hsj.girl.Contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hsj
 *
 */
@Controller
public class TemplateContraller {
	
	@RequestMapping(value="/template", method=RequestMethod.GET)
	public String template() {
		return "index";
	}

}
