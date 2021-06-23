package com.zmn.springcloud.controller;

import com.zmn.springcloud.entities.CommonResult;
import com.zmn.springcloud.entities.Payment;
import com.zmn.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentById(id);

    }
    /**
     * @Description:  超时测试
     * @Date: 2021/6/12 18:30
     * @Param: []
     * @Return: java.lang.String
     **/
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
       return this.paymentFeignService.paymentFeignTimeout();
    }
}

