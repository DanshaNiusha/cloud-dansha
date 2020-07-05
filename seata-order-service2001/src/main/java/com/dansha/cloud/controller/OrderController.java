package com.dansha.cloud.controller;

import com.dansha.cloud.domain.CommonResult;
import com.dansha.cloud.domain.Order;
import com.dansha.cloud.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2020/3/25 21:24
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    
    @PostMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
