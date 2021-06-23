package com.zmn.springcloud.controller;

import com.zmn.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zmn
 * @Description: CopyingController
 * @Date: 2021/6/11 14:08
 */
@RestController
public class CopyingController {
    @RequestMapping("/test")
    public Object test(){
        Payment payment=new Payment();
        payment.setId(1L);
        payment.setSerial("323ds");
        if (payment !=null){
            return new Exception("wwww");
        }

        return payment;

    }
}
