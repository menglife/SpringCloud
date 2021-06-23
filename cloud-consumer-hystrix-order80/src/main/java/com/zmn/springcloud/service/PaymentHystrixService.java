package com.zmn.springcloud.service;

import com.zmn.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT6001",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer  id);
    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer  id);
    @RequestMapping("/payment/hystrix/getPaymentFallbackService")
    public String getPaymentFallbackService();
}
