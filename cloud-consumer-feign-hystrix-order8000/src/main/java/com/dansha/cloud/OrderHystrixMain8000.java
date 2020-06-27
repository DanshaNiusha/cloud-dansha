package com.dansha.cloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @date 2020/3/14 10:09
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8000.class,args);
    }
}