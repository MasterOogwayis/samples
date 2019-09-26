package com.zsw.spring.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Administrator on 2019/9/19 22:01
 **/
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.zsw.spring.web.controller")
public class SpringWebMvcConfiguration {
}
