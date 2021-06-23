package com.zmn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMainApplication.class,args);
    }
    //灰度发布
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","" +
                "${version}/${name}");
    }
}
