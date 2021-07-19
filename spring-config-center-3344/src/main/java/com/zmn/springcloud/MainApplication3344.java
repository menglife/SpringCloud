package com.zmn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer  //开启配置中心注解
public class MainApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication3344.class, args);

    }
}
