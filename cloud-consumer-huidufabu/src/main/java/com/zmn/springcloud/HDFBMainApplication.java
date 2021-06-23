package com.zmn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HDFBMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HDFBMainApplication.class,args);
    }
}
