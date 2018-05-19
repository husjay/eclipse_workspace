/**  
 * @Title: Application.java
 * @Package com.deck.javaConcurrent
 * @Description: TODO
 * @author h003
 * @date 2018-5-18
 */
package com.deck.javaConcurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * ClassName: Application 
 * @Description: springboot启动类
 * @author h003
 * @date 2018-5-18
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
    
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
