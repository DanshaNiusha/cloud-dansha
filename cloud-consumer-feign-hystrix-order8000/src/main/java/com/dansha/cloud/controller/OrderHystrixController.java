package com.dansha.cloud.controller;

import com.dansha.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/3/14 10:24
 */
@RestController
@Slf4j
public class OrderHystrixController {
    
    @Resource
    private PaymentHystrixService paymentHystrixService;
    
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }
    
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        // int age = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    
    
    public String paymentTimeOutFallBackMethod(@PathVariable("id") Integer id){
        return "我是消费者8000，对方支付系统繁忙，请稍后再试，o(╥﹏╥)o";
    }
}