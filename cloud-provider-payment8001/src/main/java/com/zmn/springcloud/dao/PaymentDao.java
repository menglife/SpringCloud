package com.zmn.springcloud.dao;

import com.zmn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * fileName: Payment
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:30
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
