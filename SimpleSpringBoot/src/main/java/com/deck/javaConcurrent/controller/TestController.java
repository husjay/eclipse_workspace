/**  
 * @Title: TestController.java
 * @Package com.deck.javaConcurrent.controller
 * @Description: TODO
 * @author h003
 * @date 2018-5-18
 */
package com.deck.javaConcurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController 
 * @Description: TODO
 * @author h003
 * @date 2018-5-18
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name) {
	return "Hello " + name;
    }
    
    @GetMapping("/hello1")
    public String hello1(@RequestParam(name="name") String name) {
	return "Hello111 " + name;
    }
}
