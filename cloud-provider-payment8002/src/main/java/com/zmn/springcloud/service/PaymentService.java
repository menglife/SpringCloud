package com.zmn.springcloud.service;


import com.zmn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * fileName: PaymentService
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:43
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id );
}
