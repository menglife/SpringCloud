package com.zmn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${config.info}")
    private String configInfo;
    @RequestMapping("/test")
    public Object test(){
       return configInfo;
    }
}
