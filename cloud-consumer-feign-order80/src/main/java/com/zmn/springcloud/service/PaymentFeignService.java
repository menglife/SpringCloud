package com.zmn.springcloud.service;

import com.zmn.springcloud.entities.CommonResult;
import com.zmn.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT800")
public interface PaymentFeignService {
//    @PostMapping(value = "/payment/create")
//    public int create(Payment payment);
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    /**
     * @Description:  超时测试
     * @Date: 2021/6/12 18:22
     * @Param: []
     * @Return: java.lang.String
     **/
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
