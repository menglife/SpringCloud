package com.zmn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling //开启定时任务
public class FeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain80.class,args);
    }
}
