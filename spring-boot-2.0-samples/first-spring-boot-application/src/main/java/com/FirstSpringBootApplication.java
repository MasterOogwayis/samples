package com;

import com.zsw.spring.boot.first.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebConfiguration.class, args);
    }


}
