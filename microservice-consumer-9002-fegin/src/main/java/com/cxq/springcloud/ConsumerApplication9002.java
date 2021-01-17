package com.cxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = {"com.cxq.springcloud"})
@EnableEurekaClient
@SpringBootApplication
@ComponentScan("com.cxq.springcloud")
public class ConsumerApplication9002 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication9002.class, args);
    }
}
