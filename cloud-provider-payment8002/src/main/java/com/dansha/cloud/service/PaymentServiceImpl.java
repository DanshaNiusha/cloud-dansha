package com.dansha.cloud.service;

import com.dansha.cloud.dao.PaymentDao;
import com.danshacloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
