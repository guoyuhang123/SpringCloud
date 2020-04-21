package com.gyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gyh.mapper")
public class FreemakerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreemakerApplication.class,args);
    }
}
