package com.dansha.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8000.class,args);
    }
}