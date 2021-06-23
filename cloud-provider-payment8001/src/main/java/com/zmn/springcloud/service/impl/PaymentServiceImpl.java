package com.zmn.springcloud.service.impl;

import com.zmn.springcloud.dao.PaymentDao;
import com.zmn.springcloud.entities.Payment;
import com.zmn.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * fileName: PaymentServiceImpl
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:44
 */
@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
