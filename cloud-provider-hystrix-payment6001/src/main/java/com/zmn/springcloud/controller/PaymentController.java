package com.zmn.springcloud.controller;

import com.zmn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer  id){
        return paymentService.paymentInfo_OK(id);
    }
    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer  id){
        return  paymentService.paymentInfo_TimeOut(id);
    }
    @RequestMapping("/payment/hystrix/getPaymentFallbackService")
    public String getPaymentFallbackService(){
        return paymentService.getPaymentFallbackService();
    }
}
