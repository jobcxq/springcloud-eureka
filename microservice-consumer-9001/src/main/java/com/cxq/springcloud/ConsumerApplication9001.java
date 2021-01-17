package com.cxq.springcloud;

import com.cxq.ribbon.Round5RobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name="MICROSERVICE-PROVIDER",configuration=Round5RobinRule.class)
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication9001 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication9001.class, args);
    }
}
