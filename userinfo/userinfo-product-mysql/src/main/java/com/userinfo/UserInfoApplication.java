package com.userinfo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.userinfo.userinfo.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class UserInfoApplication{
    public static void main(String[] args) {
        SpringApplication.run(UserInfoApplication.class,args);
    }
}
