package com.zmn.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HuiDuController {
    @Value("${version}")
    private String version;
    @RequestMapping(value = "/getVersion")
    public String getVerseion(){
        return this.version;
    }

}
