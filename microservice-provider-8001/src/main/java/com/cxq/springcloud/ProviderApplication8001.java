package com.cxq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient     //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient  //服务发现
@SpringBootApplication
public class ProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8001.class, args);
    }

}
