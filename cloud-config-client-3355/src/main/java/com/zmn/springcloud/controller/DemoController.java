package com.zmn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //支持动态刷新
public class DemoController {
    // 读取端口
    @Value("${server.port}")
    private String serverPort;
    // 读取应用名称
    @Value("${spring.application.name}")
    private String appName;


    @RequestMapping("/config")
    public String config() {
        return serverPort + "\n" + appName + "\n" ;
    }
}
