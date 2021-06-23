package com.zmn.springcloud.controller;


import com.zmn.springcloud.entities.CommonResult;
import com.zmn.springcloud.entities.Payment;
import com.zmn.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * fileName: PaymentController
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:49
 */
@RestController
@Slf4j
@Api(tags = "支付接口")
public class PaymentController {
//    @Resource
//    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * @Description:
     * @Date: 2021/6/11 17:06
     * @Param: [payment]
     * @Return: com.zmn.springcloud.entities.CommonResult
     **/
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){  //如果不加requetbody注解则消费端创建时候这儿参数接受不到

       int result= paymentService.create(payment);
       log.info("****插入结果"+result);
       if (result > 0){
           return  new CommonResult(200,"success"+this.serverPort,result);
       }else {
           return  new CommonResult(444,"faild",null);
       }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("****插入结果"+payment);
        if (payment != null){
            return  new CommonResult(200,"success"+this.serverPort,payment);
        }else {
            return  new CommonResult(444,"faild"+id,null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ele:services){
            log.info("****"+ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT800");
        for (ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;


    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.serverPort;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return this.serverPort;
    }
}
