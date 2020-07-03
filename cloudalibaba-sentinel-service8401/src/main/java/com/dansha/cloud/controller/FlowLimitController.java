package com.dansha.cloud.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wsk
 * @date 2020/3/24 14:00
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "--------testB";
    }
    
    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(2);
            log.info("--------testD------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "--------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE测试异常数");
        int age = 10/0;
        return "--------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p1",required = false) String p2){
        // int i =1/0;
        return "testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "---------------deal_testHotKey,o(╥﹏╥)o";
    }

}