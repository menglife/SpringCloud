package com.zmn.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zmn.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" +Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"/*指定善后方法名*/,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        try {
           // int i =10/0;超时和异常兜底方法处理专业术语服务降级
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"^^^^");
        return "线程池:" +Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t";
    }

    @Override
    public String getPaymentFallbackService() {
        return "测试消费端fallback = PaymentFallbackService";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        System.out.println(Thread.currentThread().getName()+"%%%%");
        return "线程池:" +Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id:"+id+"\t";
    }

}
