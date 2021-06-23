package com.zmn.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zmn.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    //兜底的三种方式第一种服务down机用接口实现类兜底
    @RequestMapping("/consumer/hystrix/paymentFallbackService")
    public String PaymentFallbackService(){
        return paymentHystrixService.getPaymentFallbackService();
    }
  //兜底方式二 采样当前类的全局方法
    @RequestMapping("/consumer/hystrix/ok/{id}")
    @HystrixCommand  //降级兜底
    public String paymentInfo_OK(@PathVariable("id")Integer  id){
//        int i=10/0;

        return paymentHystrixService.paymentInfo_OK(id);
    }
  //兜底方式三 采用定制化兜底
    @RequestMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "OrderInfo_TimeOutHandler"/*指定善后方法名*/,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String OrderInfo_TimeOut(@PathVariable("id")Integer  id) {
        System.out.println(Thread.currentThread().getName()+"****");
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String OrderInfo_TimeOutHandler(Integer id){
        System.out.println(Thread.currentThread().getName()+"&&&");
        return "线程池:" +Thread.currentThread().getName()+"OrderInfo_TimeOutHandler,id:"+id+"\t";
    }
    public String payment_Global_FallbackMethod(){
        return "全局的兜底方法";
    }
}
