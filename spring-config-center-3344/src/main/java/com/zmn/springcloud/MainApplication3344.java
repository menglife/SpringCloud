package com.zmn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer  //开启配置中心注解
@EnableEurekaClient
public class MainApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication3344.class, args);

    }
}
