package com.dansha.cloud.service;

import com.danshacloud.entities.CommonResult;
import com.danshacloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/6/27
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE") //指定调用哪个服务
public interface PaymentFeignService {
    
    @GetMapping(value = "/payment/get/{id}")  //哪个地址
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();


}
