package com.gyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gyh.mapper")
public class Zk1Application {
    public static void main(String[] args) {
        SpringApplication.run(Zk1Application.class,args);
    }
}
