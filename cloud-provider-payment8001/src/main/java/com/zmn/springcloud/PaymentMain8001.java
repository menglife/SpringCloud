package com.zmn.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: zmn
 * @Description: PaymentMain8001
 * @CreateDate: 2021/6/11 22:48
 * @Version 1.0
 */
@MapperScan(basePackages = "com.zmn.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAsync
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
        //匿名类=>lambfa方式
        //匿名函数
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("采取匿名表达方式");
            }
        };
        runnable.run();
        //采用lambda方式
        Runnable runnable1 =()->{
            System.out.println("采用lambda方式");

        };
        runnable1.run();
        //匿名内部类作为参数传递
        TreeSet<String>  treeSet=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        TreeSet<String> treeSet1=new TreeSet<String>(
                (o1,o2) -> Integer.compare(o1.length(),o2.length())
        );



    }

}
